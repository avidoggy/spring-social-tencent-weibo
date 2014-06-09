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

/**
 *
 * @author Gavin.Lin
 */
@SuppressWarnings("serial")
public class TencentWeiboProfileData extends TencentWeiboObject implements Serializable {
//birth_day : 出生天,
//birth_month : 出生月,
//birth_year : 出生年,
//city_code : 城市id,
//fansnum : 听众数,
//favnum : 收藏数,
//head : 头像url,
//homecity_code : 家乡所在城市id,
//homecountry_code : 家乡所在国家id,
//homepage : 个人主页,
//homeprovince_code : 家乡所在省id,
//hometown_code : 家乡所在城镇id,
//idolnum : 收听的人数,
//industry_code : 行业id,
//introduction : 个人介绍,
//isent : 是否企业机构,
//ismyblack : 是否在当前用户的黑名单中，0-不是，1-是,
//ismyfans : 是否是当前用户的听众，0-不是，1-是,
//ismyidol : 是否是当前用户的偶像，0-不是，1-是,
//isrealname : 是否实名认证，1-已实名认证，2-未实名认证,
//isvip : 是否认证用户，0-不是，1-是,
//location : 所在地,
//mutual_fans_num : 互听好友数,
//name : 用户帐户名,
//nick : 用户昵称,
//openid : 用户唯一id，与name相对应,
//province_code : 地区id,
//regtime : 注册时间,
//send_private_flag : 是否允许所有人给当前用户发私信，0-仅有偶像，1-名人+听众，2-所有人,
//sex : 用户性别，1-男，2-女，0-未填写,
//tweetnum : 发表的微博数,
//verifyinfo : 认证信息,
//exp : 经验值,
//level : 微博等级

    public TencentWeiboProfileData(
            String openid,
            String name,
            String nick,
            //String first_name,
            //String last_name,
            int sex,
            String location) {
        this.openid = openid;
        this.name = name;
        this.nick = nick;
        this.sex = sex;
        this.location = location;
    }
    private int birth_day;
    private int birth_month;
    private int birth_year;
    private String city_code;
    private String comp;
    private String country_code;
    private String edu;
    private String email;
    private int exp;
    private int fansnum;
    private int favnum;
    private String head;
    private String homecity_code;
    private String homecountry_code;
    private String homepage;
    private String homeprovince_code;
    private String hometown_code;
    private String https_head;
    private int idolnum;
    private int industry_code;
    private String introduction;
    private int isent;
    private int ismyblack;
    private int ismyfans;
    private int ismyidol;
    private int isrealname;
    private int isvip;
    private int level;
    private String location;
    private int mutual_fans_num;
    private String name;
    private String nick;
    private String openid;
    private String province_code;
    private int regtime;
    private int send_private_flag;
    private int sex;
    private String tag;
//    private tweetinfo tweetinfo;

    /**
     * @return the birth_day
     */
    protected int getBirth_day() {
        return birth_day;
    }

    /**
     * @return the birth_month
     */
    protected int getBirth_month() {
        return birth_month;
    }

    /**
     * @return the birth_year
     */
    protected int getBirth_year() {
        return birth_year;
    }

    /**
     * @return the city_code
     */
    protected String getCity_code() {
        return city_code;
    }

    /**
     * @return the comp
     */
    protected String getComp() {
        return comp;
    }

    /**
     * @return the country_code
     */
    protected String getCountry_code() {
        return country_code;
    }

    /**
     * @return the edu
     */
    protected String getEdu() {
        return edu;
    }

    /**
     * @return the email
     */
    protected String getEmail() {
        return email;
    }

    /**
     * @return the exp
     */
    protected int getExp() {
        return exp;
    }

    /**
     * @return the fansnum
     */
    protected int getFansnum() {
        return fansnum;
    }

    /**
     * @return the favnum
     */
    protected int getFavnum() {
        return favnum;
    }

    /**
     * @return the head
     */
    protected String getHead() {
        return head;
    }

    /**
     * @return the homecity_code
     */
    protected String getHomecity_code() {
        return homecity_code;
    }

    /**
     * @return the homecountry_code
     */
    protected String getHomecountry_code() {
        return homecountry_code;
    }

    /**
     * @return the homepage
     */
    protected String getHomepage() {
        return homepage;
    }

    /**
     * @return the homeprovince_code
     */
    protected String getHomeprovince_code() {
        return homeprovince_code;
    }

    /**
     * @return the hometown_code
     */
    protected String getHometown_code() {
        return hometown_code;
    }

    /**
     * @return the https_head
     */
    protected String getHttps_head() {
        return https_head;
    }

    /**
     * @return the idolnum
     */
    protected int getIdolnum() {
        return idolnum;
    }

    /**
     * @return the industry_code
     */
    protected int getIndustry_code() {
        return industry_code;
    }

    /**
     * @return the introduction
     */
    protected String getIntroduction() {
        return introduction;
    }

    /**
     * @return the isent
     */
    protected int getIsent() {
        return isent;
    }

    /**
     * @return the ismyblack
     */
    protected int getIsmyblack() {
        return ismyblack;
    }

    /**
     * @return the ismyfans
     */
    protected int getIsmyfans() {
        return ismyfans;
    }

    /**
     * @return the ismyidol
     */
    protected int getIsmyidol() {
        return ismyidol;
    }

    /**
     * @return the isrealname
     */
    protected int getIsrealname() {
        return isrealname;
    }

    /**
     * @return the isvip
     */
    protected int getIsvip() {
        return isvip;
    }

    /**
     * @return the level
     */
    protected int getLevel() {
        return level;
    }

    /**
     * @return the location
     */
    protected String getLocation() {
        return location;
    }

    /**
     * @return the mutual_fans_num
     */
    protected int getMutual_fans_num() {
        return mutual_fans_num;
    }

    /**
     * @return the name
     */
    protected String getName() {
        return name;
    }

    /**
     * @return the nick
     */
    protected String getNick() {
        return nick;
    }

    /**
     * @return the openid
     */
    protected String getOpenid() {
        return openid;
    }

    /**
     * @return the province_code
     */
    protected String getProvince_code() {
        return province_code;
    }

    /**
     * @return the regtime
     */
    protected int getRegtime() {
        return regtime;
    }

    /**
     * @return the send_private_flag
     */
    protected int getSend_private_flag() {
        return send_private_flag;
    }

    /**
     * @return the sex
     */
    protected int getSex() {
        return sex;
    }

    /**
     * @return the tag
     */
    protected String getTag() {
        return tag;
    }
}
