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
package org.springframework.social.tencentWeibo.security;

import org.springframework.social.security.provider.OAuth2AuthenticationService;
import org.springframework.social.tencentWeibo.api.TencentWeibo;
import org.springframework.social.tencentWeibo.connect.TencentWeiboConnectionFactory;

/**
 *
 * @author Gavin.Lin
 */
public class TencentWeiboAuthenticationService extends OAuth2AuthenticationService<TencentWeibo>{
    public TencentWeiboAuthenticationService(String apiKey, String appSecret) {
		super(new TencentWeiboConnectionFactory(apiKey, appSecret));
	}

	public TencentWeiboAuthenticationService(String apiKey, String appSecret, String appNamespace) {
		super(new TencentWeiboConnectionFactory(apiKey, appSecret, appNamespace));
	}
}
