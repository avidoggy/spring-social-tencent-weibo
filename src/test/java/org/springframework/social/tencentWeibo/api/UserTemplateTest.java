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
package org.springframework.social.tencentWeibo.api;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import static org.springframework.http.HttpMethod.GET;
import org.springframework.http.MediaType;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

/**
 *
 * @author Gavin.Lin
 */
public class UserTemplateTest extends AbstractTencentWeiboApiTest {

    public UserTemplateTest() {
    }

    @Test
    public void testGetInfo() {
        mockServer.expect(requestTo("https://open.t.qq.com/api/user/info" + "?format=json&access_token=&oauth_consumer_key=&openid=&clientip=&oauth_version=2.a&scope=all"))
                .andExpect(method(GET))
                .andRespond(withSuccess(jsonResource("full-profile"), MediaType.TEXT_HTML));

        TencentWeiboProfile profile = tencentWeibo.userOperations().getInfo();
        assertEquals("F11C339C7FA5FBCA844B947701CBBC60", profile.getOpenid());
        assertEquals("rolltech168", profile.getName());
        assertEquals("滾雷科技股份有限公司", profile.getNick());
        assertEquals(1, profile.getSex());
        assertEquals("male", profile.getGender());
        assertEquals("http://app.qlogo.cn/mbloghead/2532fd22748a7ec76662", profile.getHead());
        assertEquals(1396858811, profile.getSeqid());
    }
}