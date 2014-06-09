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

import java.io.UnsupportedEncodingException;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import static org.springframework.http.HttpMethod.POST;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

/**
 *
 * @author Gavin.Lin
 */
public class TencentWeiboOAuth2TemplateTest {

    protected TencentWeiboOAuth2Template tencentWeiboOAuth2Template;
    protected MockRestServiceServer mockServer;

    @Before
    public void setup() throws UnsupportedEncodingException {
        tencentWeiboOAuth2Template = new TencentWeiboOAuth2Template("clientId", "clientSecret");
        mockServer = MockRestServiceServer.createServer(tencentWeiboOAuth2Template.getRestTemplate());
    }

    @Test
    public void testGetAccessToken() throws Exception {
        mockServer.expect(requestTo("https://open.t.qq.com/cgi-bin/oauth2/access_token"
                + "?client_id=clientId"
                + "&client_secret=clientSecret"
                + "&grant_type=authorization_code"
                + "&code=code"
                + "&redirect_uri=redirect_uri"))
                .andExpect(method(POST))
                .andRespond(withSuccess(loadResource("accessToken"), MediaType.APPLICATION_FORM_URLENCODED));

        TencentWeiboAccessGrant accessGrant = tencentWeiboOAuth2Template.exchangeForAccess("code", "redirect_uri", null);
        Long exceptExpireTime = System.currentTimeMillis() + 1234567 * 1000l;
        assertEquals("testAccessToken", accessGrant.getAccessToken());
        assertEquals(exceptExpireTime, accessGrant.getExpireTime());
        assertEquals("testRefreshToken", accessGrant.getRefreshToken());
        assertEquals("testOpenid", accessGrant.getOpenid());
        assertEquals("testName", accessGrant.getName());
        assertEquals("testNick", accessGrant.getNick());
        assertEquals("testState", accessGrant.getState());
    }

    protected Resource loadResource(String filename) {
        return new ClassPathResource(filename, getClass());
    }
}