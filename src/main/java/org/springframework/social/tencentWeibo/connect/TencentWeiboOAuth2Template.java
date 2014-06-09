/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.springframework.social.tencentWeibo.connect;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.shindig.common.logging.i18n.MessageKeys;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Template;
import org.springframework.social.support.ClientHttpRequestFactorySelector;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Gavin.Lin
 */
public class TencentWeiboOAuth2Template extends OAuth2Template {

    private static final String classname = TencentWeiboOAuth2Template.class.getName();
    private static final Logger LOG = Logger.getLogger(classname, MessageKeys.MESSAGES);
    private final String clientId;
    private final String clientSecret;
    private final String accessTokenUrl;
    private final String authorizeUrl;
    private final boolean useParametersForClientAuthentication = true;

    public TencentWeiboOAuth2Template(String clientId, String clientSecret) {
        super(clientId, clientSecret,
                "https://open.t.qq.com/cgi-bin/oauth2/authorize",
                "https://open.t.qq.com/cgi-bin/oauth2/access_token");
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.authorizeUrl = "https://open.t.qq.com/cgi-bin/oauth2/authorize";
        this.accessTokenUrl = "https://open.t.qq.com/cgi-bin/oauth2/access_token";
        setUseParametersForClientAuthentication(useParametersForClientAuthentication);
    }

    @Override
    protected RestTemplate createRestTemplate() {
        ClientHttpRequestFactory requestFactory = ClientHttpRequestFactorySelector.getRequestFactory();
        RestTemplate restTemplate = new RestTemplate(requestFactory);
        List<HttpMessageConverter<?>> converters = new ArrayList<HttpMessageConverter<?>>(2);
        StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
        stringHttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_FORM_URLENCODED));
        converters.add(stringHttpMessageConverter);
        restTemplate.setMessageConverters(converters);

        return restTemplate;
    }

    @Override
    public TencentWeiboAccessGrant exchangeForAccess(String authorizationCode, String redirectUri, MultiValueMap<String, String> additionalParameters) {
        //URL:https://open.t.qq.com/cgi-bin/oauth2/access_token
        //?client_id=
        //&client_secret=
        //&grant_type=authorization_code
        //&code=
        //&redirect_uri=
        StringBuilder url = new StringBuilder(accessTokenUrl);
        url.append('?').append(formEncode("client_id")).append('=').append(formEncode(clientId));
        url.append('&').append(formEncode("client_secret")).append('=').append(formEncode(clientSecret));
        url.append('&').append(formEncode("grant_type")).append('=').append(formEncode("authorization_code"));
        url.append('&').append(formEncode("code")).append('=').append(formEncode(authorizationCode));
        url.append('&').append(formEncode("redirect_uri")).append('=').append(formEncode(redirectUri));

        return this.postForAccessGrant(url.toString(), null);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected TencentWeiboAccessGrant postForAccessGrant(String accessTokenUrl, MultiValueMap<String, String> parameters) {
        return this.extractAccessGrant(getRestTemplate().postForObject(accessTokenUrl, parameters, String.class));
    }

    private TencentWeiboAccessGrant extractAccessGrant(String body) {
        Charset charset = Charset.forName("UTF-8");
        String[] pairs = StringUtils.tokenizeToStringArray(body, "&");

        Map<String, Object> result = new HashMap<String, Object>(pairs.length);
        try {
            for (String pair : pairs) {
                int idx = pair.indexOf('=');
                if (idx == -1) {
                    result.put(URLDecoder.decode(pair, charset.name()), null);
                } else {
                    String name = URLDecoder.decode(pair.substring(0, idx), charset.name());
                    String value = URLDecoder.decode(pair.substring(idx + 1), charset.name());
                    result.put(name, value);
                }
            }
            return this.createAccessGrant(
                    (String) result.get("access_token"),
                    (String) result.get("scope"),
                    (String) result.get("refresh_token"),
                    getIntegerValue(result, "expires_in"),
                    result);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(TencentWeiboOAuth2Template.class.getName()).log(Level.SEVERE, null, ex);
            return this.createAccessGrant("", "", "", Long.getLong("-1"), new HashMap<String, Object>());
        }
    }

    @Override
    protected TencentWeiboAccessGrant createAccessGrant(String accessToken, String scope, String refreshToken, Long expiresIn, Map<String, Object> response) {
        return new TencentWeiboAccessGrant(accessToken, scope, refreshToken, expiresIn,
                (String) response.get("openid"),
                (String) response.get("name"),
                (String) response.get("nick"),
                (String) response.get("state"));
    }

    // Retrieves object from map into an Integer, regardless of the object's actual type. Allows for flexibility in object type (eg, "3600" vs 3600).
    private Long getIntegerValue(Map<String, Object> map, String key) {
        try {
            return Long.valueOf(String.valueOf(map.get(key))); // normalize to String before creating integer value;			
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private String formEncode(String data) {
        try {
            return URLEncoder.encode(data, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            // should not happen, UTF-8 is always supported
            throw new IllegalStateException(ex);
        }
    }

    @Override
    public RestTemplate getRestTemplate() {
        return super.getRestTemplate();
    }
}
