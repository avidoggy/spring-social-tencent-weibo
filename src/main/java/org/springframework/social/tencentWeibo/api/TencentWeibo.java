/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.springframework.social.tencentWeibo.api;

import org.springframework.social.ApiBinding;
import org.springframework.web.client.RestOperations;

/**
 *
 * @author Gavin.Lin
 */
public interface TencentWeibo extends RequestAPI, ApiBinding {
//    public static final String API_V1_BASE_URL="http://open.t.qq.com/api";
//    public static final String API_V2_BASE_URL="https://open.t.qq.com/api";

    public static final String HELLO_AYPLUS_KEY = "801494156";
    public static final String HELLO_AYPLUS_SECRET = "b0ad5f20f90345c20c2c70f5adb9feaf";

    FavoriteOperations favoriteOperations();

    FriendOperations friendOperations();

    HotTweetOperations hotTweetOperations();

    InformationOperations informationOperations();

    ListOperations listOperations();

    LocationBasedServiceOperations locationBasedServiceOperations();

    NotificationOperations notificationOperations();

    OtherOperations otherOperations();

    PrivateMessageOperations privateMessageOperations();

    ShortUrlOperations shortUrlOperations();

    StatusOperations statusOperations();

    TagOperations tagOperations();

    TweetOperations tweetOperations();

    UserOperations userOperations();

    VoteOperations voteOperations();
}
