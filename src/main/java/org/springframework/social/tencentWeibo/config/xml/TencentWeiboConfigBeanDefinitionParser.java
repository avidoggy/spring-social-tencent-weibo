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
package org.springframework.social.tencentWeibo.config.xml;

import java.util.Map;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.social.config.xml.AbstractProviderConfigBeanDefinitionParser;
import org.springframework.social.security.provider.SocialAuthenticationService;
import org.springframework.social.tencentWeibo.config.support.TencentWeiboApiHelper;
import org.springframework.social.tencentWeibo.connect.TencentWeiboConnectionFactory;
import org.springframework.social.tencentWeibo.security.TencentWeiboAuthenticationService;

/**
 *
 * @author Gavin.Lin
 */
public class TencentWeiboConfigBeanDefinitionParser extends AbstractProviderConfigBeanDefinitionParser {

    public TencentWeiboConfigBeanDefinitionParser() {
        super(TencentWeiboConnectionFactory.class, TencentWeiboApiHelper.class);
    }

    @Override
    protected Class<? extends SocialAuthenticationService<?>> getAuthenticationServiceClass() {
        return TencentWeiboAuthenticationService.class;
    }

    @Override
    protected BeanDefinition getConnectionFactoryBeanDefinition(String appId, String appSecret, Map<String, Object> allAttributes) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(TencentWeiboConnectionFactory.class).addConstructorArgValue(appId).addConstructorArgValue(appSecret);
        if (allAttributes.containsKey("app-namespace")) {
            builder.addConstructorArgValue(allAttributes.get("app-namespace"));
        }
        return builder.getBeanDefinition();
    }
}
