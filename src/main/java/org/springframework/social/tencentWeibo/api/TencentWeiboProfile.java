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

import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Gavin.Lin
 */
@SuppressWarnings("serial")
public class TencentWeiboProfile extends TencentWeiboObject implements Serializable {
//errcode : 返回错误码,
//msg : 错误信息,
//ret : 返回值，0-成功，非0-失败,
//seqid : 序列号

    private TencentWeiboProfileData data;
    private int errcode;
    private String msg;
    private int ret;
    private long seqid;

    public TencentWeiboProfile(int errcode, String msg, int ret) {
        this.errcode = errcode;
        this.msg = msg;
        this.ret = ret;
    }

    /**
     * @return the data
     */
    public TencentWeiboProfileData getData() {
        return data;
    }

    /**
     * @return the errcode
     */
    public int getErrcode() {
        return errcode;
    }

    /**
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @return the ret
     */
    public int getRet() {
        return ret;
    }

    /**
     * @return the seqid
     */
    public long getSeqid() {
        return seqid;
    }

    /**
     * @return the birth_day
     */
    public int getBirth_day() {
        return data.getBirth_day();
    }

    /**
     * @return the birth_month
     */
    public int getBirth_month() {
        return data.getBirth_month();
    }

    /**
     * @return the birth_year
     */
    public int getBirth_year() {
        return data.getBirth_year();
    }

    /**
     * @return the city_code
     */
    public String getCity_code() {
        return data.getCity_code();
    }

    /**
     * @return the comp
     */
    public String getComp() {
        return data.getComp();
    }

    /**
     * @return the country_code
     */
    public String getCountry_code() {
        return data.getCountry_code();
    }

    /**
     * @return the edu
     */
    public String getEdu() {
        return data.getEdu();
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return data.getEmail();
    }

    /**
     * @return the exp
     */
    public int getExp() {
        return data.getExp();
    }

    /**
     * @return the fansnum
     */
    public int getFansnum() {
        return data.getFansnum();
    }

    /**
     * @return the favnum
     */
    public int getFavnum() {
        return data.getFavnum();
    }

    /**
     * @return the head
     */
    public String getHead() {
        return data.getHead();
    }

    /**
     * @return the homecity_code
     */
    public String getHomecity_code() {
        return data.getHomecity_code();
    }

    /**
     * @return the homecountry_code
     */
    public String getHomecountry_code() {
        return data.getHomecountry_code();
    }

    /**
     * @return the homepage
     */
    public String getHomepage() {
        return data.getHomepage();
    }

    /**
     * @return the homeprovince_code
     */
    public String getHomeprovince_code() {
        return data.getHomeprovince_code();
    }

    /**
     * @return the hometown_code
     */
    public String getHometown_code() {
        return data.getHometown_code();
    }

    /**
     * @return the https_head
     */
    public String getHttps_head() {
        return data.getHttps_head();
    }

    /**
     * @return the idolnum
     */
    public int getIdolnum() {
        return data.getIdolnum();
    }

    /**
     * @return the industry_code
     */
    public int getIndustry_code() {
        return data.getIndustry_code();
    }

    /**
     * @return the introduction
     */
    public String getIntroduction() {
        return data.getIntroduction();
    }

    /**
     * @return the isent
     */
    public int getIsent() {
        return data.getIsent();
    }

    /**
     * @return the ismyblack
     */
    public int getIsmyblack() {
        return data.getIsmyblack();
    }

    /**
     * @return the ismyfans
     */
    public int getIsmyfans() {
        return data.getIsmyfans();
    }

    /**
     * @return the ismyidol
     */
    public int getIsmyidol() {
        return data.getIsmyidol();
    }

    /**
     * @return the isrealname
     */
    public int getIsrealname() {
        return data.getIsrealname();
    }

    /**
     * @return the isvip
     */
    public int getIsvip() {
        return data.getIsvip();
    }

    /**
     * @return the level
     */
    public int getLevel() {
        return data.getLevel();
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return data.getLocation();
    }

    /**
     * @return the mutual_fans_num
     */
    public int getMutual_fans_num() {
        return data.getMutual_fans_num();
    }

    /**
     * @return the name
     */
    public String getName() {
        return data.getName();
    }

    /**
     * @return the nick
     */
    public String getNick() {
        return data.getNick();
    }

    /**
     * @return the openid
     */
    public String getOpenid() {
        return data.getOpenid();
    }

    /**
     * @return the province_code
     */
    public String getProvince_code() {
        return data.getProvince_code();
    }

    /**
     * @return the regtime
     */
    public int getRegtime() {
        return data.getRegtime();
    }

    /**
     * @return the send_private_flag
     */
    public int getSend_private_flag() {
        return data.getSend_private_flag();
    }

    /**
     * @return the sex
     */
    public int getSex() {
        return data.getSex();
    }

    /**
     * 用户性别，1-男，2-女，0-未填写,
     * @return 
     */
    public String getGender(){
        return (data.getSex() == 1 || data.getSex() == 2) 
                ? (data.getSex() == 1) ? "male" : "female"
                : "unknown";
    }
    /**
     * @return the tag
     */
    public String getTag() {
        return data.getTag();
    }

//    public JSONObject toJSONObject() {
//        // &fields=first_name,last_name,name,username,id,gender,picture,locale,birthday,email
//        JSONObject json = null;
//        try {
//            json = new JSONObject();
////            json.put("first_name", firstName);
////            json.put("last_name", lastName);
//            json.put("username", data.getName());
//            json.put("name", data.getNick());
//            json.put("id", data.getOpenid());
//            json.put("gender", this.getGender());
//            json.put("locale", data.getLocation());
//            json.put("birthday", data.getBirth_month() + "/" + data.getBirth_day() + "/" + data.getBirth_year());
//            json.put("email", data.getEmail());
//            json.put("picture", new JSONObject().put("data", new JSONObject().put("is_silhouette", false).put("url", data.getHead() + "/0")));
//        } catch (JSONException jsone) {
//        }
//        return json;
//    }
//
//    public JSONObject toJSONObject(String person_oid) {
//        // put("oid", String.valueOf(person.getObjectId()));
//        JSONObject json = toJSONObject();
//        try {
//            json.put("oid", String.valueOf(person_oid));
//        } catch (JSONException jsone) {
//        }
//        return json;
//    }
}
