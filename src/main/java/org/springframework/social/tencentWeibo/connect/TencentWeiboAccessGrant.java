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
package org.springframework.social.tencentWeibo.connect;

import org.springframework.social.oauth2.AccessGrant;

/**
 *
 * @author Gavin.Lin
 */
public class TencentWeiboAccessGrant extends AccessGrant {

    private final String openid;
    private final String name;
    private final String nick;
    private final String state;

    public TencentWeiboAccessGrant(String accessToken, String scope, String refreshToken, Long expiresIn) {
        this(accessToken, scope, refreshToken, expiresIn, null, null, null, null);
    }

    public TencentWeiboAccessGrant(String accessToken, String scope, String refreshToken, Long expiresIn,
            String openid, String name, String nick, String state) {
        super(accessToken, scope, refreshToken, expiresIn);
        this.openid = openid;
        this.name = name;
        this.nick = nick;
        this.state = state;
    }

    /**
     * @return the openid
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the nick
     */
    public String getNick() {
        return nick;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }
}
