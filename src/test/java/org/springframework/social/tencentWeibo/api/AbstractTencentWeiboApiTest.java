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

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.junit.Before;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.social.tencentWeibo.api.impl.TencentWeiboTemplate;
import org.springframework.test.web.client.MockRestServiceServer;

/**
 *
 * @author Gavin.Lin
 */
public class AbstractTencentWeiboApiTest {
    protected static final String ACCESS_TOKEN = "someAccessToken";
    protected TencentWeiboTemplate tencentWeibo;
    protected TencentWeiboTemplate unauthorizedTencentWeibo;
    protected MockRestServiceServer mockServer;
    protected MockRestServiceServer unauthorizedMockServer;
    protected String ROLLTECH_PROFILE_FIELDS;

    @Before
    public void setup() throws UnsupportedEncodingException {
        tencentWeibo = createTencentWeiboTemplate();
        mockServer = MockRestServiceServer.createServer(tencentWeibo.getRestTemplate());

        unauthorizedTencentWeibo = new TencentWeiboTemplate();
        unauthorizedMockServer = MockRestServiceServer.createServer(unauthorizedTencentWeibo.getRestTemplate());

        ROLLTECH_PROFILE_FIELDS = URLEncoder.encode("id,username,name,first_name,last_name,gender,locale,picture,birthday,email", "UTF-8");
    }

    protected TencentWeiboTemplate createTencentWeiboTemplate() {
        return new TencentWeiboTemplate(ACCESS_TOKEN);
    }

    protected Resource jsonResource(String filename) {
        return new ClassPathResource(filename + ".json", getClass());
    }

    protected Date toDate(String dateString) {
        try {
            return FB_DATE_FORMAT.parse(dateString);
        } catch (ParseException e) {
            return null;
        }
    }
    private static final DateFormat FB_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.ENGLISH);
}
