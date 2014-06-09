/*
 * Copyright 2014 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.tencentWeibo.config.support;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.social.UserIdSource;
import org.springframework.social.config.xml.ApiHelper;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.tencentWeibo.api.TencentWeibo;
import org.springframework.social.tencentWeibo.api.impl.TencentWeiboTemplate;

/**
 *
 * @author Gavin.Lin
 */
public class TencentWeiboApiHelper implements ApiHelper<TencentWeibo> {

    private final UsersConnectionRepository usersConnectionRepository;
    private final UserIdSource userIdSource;

    private TencentWeiboApiHelper(UsersConnectionRepository usersConnectionRepository, UserIdSource userIdSource) {
        this.usersConnectionRepository = usersConnectionRepository;
        this.userIdSource = userIdSource;
    }

    public TencentWeibo getApi() {
        if (logger.isDebugEnabled()) {
            logger.debug("Getting API binding instance for TencentWeibo");
        }

        Connection<TencentWeibo> connection = usersConnectionRepository.createConnectionRepository(userIdSource.getUserId()).findPrimaryConnection(TencentWeibo.class);
        if (logger.isDebugEnabled() && connection == null) {
            logger.debug("No current connection; Returning default TencentWeiboTemplate instance.");
        }
        return connection != null ? connection.getApi() : new TencentWeiboTemplate();
    }
    private final static Log logger = LogFactory.getLog(TencentWeiboApiHelper.class);
}
