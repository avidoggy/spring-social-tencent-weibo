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

import org.springframework.social.tencentWeibo.api.RequestAPI;
import org.springframework.social.tencentWeibo.api.TencentWeiboProfile;
import org.springframework.social.tencentWeibo.api.UserOperations;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @author Gavin.Lin
 */
public class UserTemplate extends AbstractTencentWeiboOperations implements UserOperations {

    private final RequestAPI requestAPI;

    public UserTemplate(RequestAPI requestAPI, boolean isAuthorizedForUser) {
        super(isAuthorizedForUser);
        this.requestAPI = requestAPI;
    }

    public void update(String format, String nick, String sex, String year, String month, String day, String countryCode, String provinceCode, String cityCode, String introduction) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void update(String nick, String sex, String year, String month, String day, String countryCode, String provinceCode, String cityCode, String introduction) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void updateEdu(String format, String dieldId, String year, String school, String departmentId, String level) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void updateEdu(String dieldId, String year, String school, String departmentId, String level) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void updateHead(String format, String file) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void updateHead(String file) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void verify(String format, String name, String fopenid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void verify(String name, String fopenid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void getEmotion(String format, String name, String fopenid, String pageFlag, String id, String timestamp, String type, String contentType, String emotionType, String reqnum, String listType) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void getEmotion(String name, String fopenid, String pageFlag, String id, String timestamp, String type, String contentType, String emotionType, String reqnum, String listType) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public TencentWeiboProfile getInfo(String format) {
        MultiValueMap<String, String> queryParameters = new LinkedMultiValueMap<String, String>();
        queryParameters.set(FORMAT, format);
        return requestAPI.getResource("/user/info", queryParameters, TencentWeiboProfile.class);
    }

    public TencentWeiboProfile getInfo() {
        return getInfo(JSON_FORMAT);
    }

    public void getInfos(String format, String names, String fopenids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void getInfos(String names, String fopenids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void getOtherInfo(String format, String name, String fopenid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void getOtherInfo(String name, String fopenid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
