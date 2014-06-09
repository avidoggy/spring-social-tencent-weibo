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
package org.springframework.social.tencentWeibo.api.impl;

import org.springframework.social.tencentWeibo.api.LocationBasedServiceOperations;
import org.springframework.social.tencentWeibo.api.RequestAPI;

/**
 *
 * @author Gavin.Lin
 */
class LocationBasedServiceTemplate extends AbstractTencentWeiboOperations implements LocationBasedServiceOperations {

    private RequestAPI requestAPI;

    public LocationBasedServiceTemplate(RequestAPI requestAPI, boolean isAuthorizedForUser) {
        super(isAuthorizedForUser);
        this.requestAPI = requestAPI;
    }
}
