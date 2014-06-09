/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.springframework.social.tencentWeibo.connect;

import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import org.springframework.social.tencentWeibo.api.TencentWeibo;

/**
 *
 * @author Gavin.Lin
 */
public class TencentWeiboConnectionFactory extends OAuth2ConnectionFactory<TencentWeibo> {

    /**
     * Creates a FacebookConnectionFactory for the given application ID and
     * secret. Using this constructor, no application namespace is set (and
     * therefore Facebook's Open Graph operations cannot be used).
     *
     * @param appId The application's App ID as assigned by Facebook
     * @param appSecret The application's App Secret as assigned by Facebook
     */
    public TencentWeiboConnectionFactory(String appId, String appSecret) {
        this(appId, appSecret, null);
    }

    /**
     * Creates a FacebookConnectionFactory for the given application ID, secret,
     * and namespace.
     *
     * @param appId The application's App ID as assigned by Facebook
     * @param appSecret The application's App Secret as assigned by Facebook
     * @param appNamespace The application's App Namespace as configured with
     * Facebook. Enables use of Open Graph operations.
     */
    public TencentWeiboConnectionFactory(String appId, String appSecret, String appNamespace) {
        super("tencentWeibo", new TencentWeiboServiceProvider(appId, appSecret, appNamespace), new TencentWeiboAdapter());
    }
}
