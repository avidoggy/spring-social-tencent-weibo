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
package org.springframework.social.tencentWeibo.api.impl.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Gavin.Lin
 */
//@JsonIgnoreProperties(value = {"tweetinfo"})
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class TencentWeiboProfileDataMixin extends TencentWeiboObjectMixin {

    @JsonCreator
    TencentWeiboProfileDataMixin(
            @JsonProperty("openid") String openid,
            @JsonProperty("name") String name,
            @JsonProperty("nick") String nick,
            //@JsonProperty("first_name") String first_name,
            //@JsonProperty("last_name") String last_name,
            @JsonProperty("sex") int sex,
            @JsonProperty("location") String location) {
    }
    @JsonProperty("birth_day")
    int birth_day;
    @JsonProperty("birth_month")
    int birth_month;
    @JsonProperty("birth_year")
    int birth_year;
    @JsonProperty("city_code")
    String city_code;
    @JsonProperty("comp")
    String comp;
    @JsonProperty("country_code")
    String country_code;
    @JsonProperty("edu")
    String edu;
    @JsonProperty("email")
    String email;
    @JsonProperty("exp")
    int exp;
    @JsonProperty("fansnum")
    int fansnum;
    @JsonProperty("favnum")
    int favnum;
    @JsonProperty("head")
    String head;
    @JsonProperty("homecity_code")
    String homecity_code;
    @JsonProperty("homecountry_code")
    String homecountry_code;
    @JsonProperty("homepage")
    String homepage;
    @JsonProperty("homeprovince_code")
    String homeprovince_code;
    @JsonProperty("hometown_code")
    String hometown_code;
    @JsonProperty("https_head")
    String https_head;
    @JsonProperty("idolnum")
    int idolnum;
    @JsonProperty("industry_code")
    int industry_code;
    @JsonProperty("introduction")
    String introduction;
    @JsonProperty("isent")
    int isent;
    @JsonProperty("ismyblack")
    int ismyblack;
    @JsonProperty("ismyfans")
    int ismyfans;
    @JsonProperty("ismyidol")
    int ismyidol;
    @JsonProperty("isrealname")
    int isrealname;
    @JsonProperty("isvip")
    int isvip;
    @JsonProperty("level")
    int level;
    @JsonProperty("location")
    String location;
    @JsonProperty("mutual_fans_num")
    int mutual_fans_num;
//    @JsonProperty("name")
//    String name;
//    @JsonProperty("nick")
//    String nick;
//    @JsonProperty("openid")
//    String openid;
    @JsonProperty("province_code")
    String province_code;
    @JsonProperty("regtime")
    int regtime;
    @JsonProperty("send_private_flag")
    int send_private_flag;
//    @JsonProperty("sex")
//    int sex;
    @JsonProperty("tag")
    String tag;
//    @JsonProperty("tweetinfo")
//    tweetinfo tweetinfo;
}
