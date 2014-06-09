/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.springframework.social.tencentWeibo.connect;

import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.tencentWeibo.api.TencentWeibo;
import org.springframework.social.tencentWeibo.api.impl.TencentWeiboTemplate;

/**
 *
 * @author Gavin.Lin
 */
public class TencentWeiboServiceProvider extends AbstractOAuth2ServiceProvider<TencentWeibo> {

    private String appNamespace;

    /**
     * Creates a TencentWeiboServiceProvider for the given application ID, secret,
     * and namespace.
     *
     * @param appId The application's App ID as assigned by TencentWeibo
     * @param appSecret The application's App Secret as assigned by TencentWeibo
     * @param appNamespace The application's App Namespace as configured with
     * TencentWeibo.
     */
    public TencentWeiboServiceProvider(String appId, String appSecret, String appNamespace) {
        super(new TencentWeiboOAuth2Template(appId, appSecret));
        this.appNamespace = appNamespace;
    }

    public TencentWeibo getApi(String accessToken) {
        return new TencentWeiboTemplate(accessToken, appNamespace);
    }
}
