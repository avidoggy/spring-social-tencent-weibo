/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.springframework.social.tencentWeibo.connect;

import org.springframework.social.ApiException;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.UserProfileBuilder;
import org.springframework.social.tencentWeibo.api.TencentWeibo;

/**
 *
 * @author Gavin.Lin
 */
public class TencentWeiboAdapter implements ApiAdapter<TencentWeibo> {

    public boolean test(TencentWeibo tencentWeibo) {
        try {
            return true;
        } catch (ApiException e) {
            return false;
        }
    }

    public void setConnectionValues(TencentWeibo tencentWeibo, ConnectionValues values) {
//        FacebookProfile profile = facebook.userOperations().getUserProfile();
//        values.setProviderUserId(profile.getId());
//        values.setDisplayName(profile.getUsername());
//        values.setProfileUrl("http://facebook.com/profile.php?id=" + profile.getId());
//        values.setImageUrl("http://graph.facebook.com/" + profile.getId() + "/picture");
    }

    public UserProfile fetchUserProfile(TencentWeibo tencentWeibo) {
//        FacebookProfile profile = facebook.userOperations().getUserProfile();
//        return new UserProfileBuilder().setName(profile.getName()).setFirstName(profile.getFirstName()).setLastName(profile.getLastName()).
//                setEmail(profile.getEmail()).setUsername(profile.getUsername()).build();
        return null;
    }

    public void updateStatus(TencentWeibo tencentWeibo, String message) {
//        facebook.feedOperations().updateStatus(message);
    }
}
