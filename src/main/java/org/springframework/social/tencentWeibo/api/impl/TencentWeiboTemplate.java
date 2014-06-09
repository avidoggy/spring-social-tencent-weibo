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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rolltech.ayplus.social.openid.auth.AyplusFacebookErrorHandler;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import static org.springframework.http.converter.json.MappingJackson2HttpMessageConverter.DEFAULT_CHARSET;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.OAuth2Version;
import org.springframework.social.support.ClientHttpRequestFactorySelector;
import org.springframework.social.support.URIBuilder;
import org.springframework.social.tencentWeibo.api.FavoriteOperations;
import org.springframework.social.tencentWeibo.api.FriendOperations;
import org.springframework.social.tencentWeibo.api.HotTweetOperations;
import org.springframework.social.tencentWeibo.api.InformationOperations;
import org.springframework.social.tencentWeibo.api.ListOperations;
import org.springframework.social.tencentWeibo.api.LocationBasedServiceOperations;
import org.springframework.social.tencentWeibo.api.NotificationOperations;
import org.springframework.social.tencentWeibo.api.OtherOperations;
import org.springframework.social.tencentWeibo.api.PrivateMessageOperations;
import org.springframework.social.tencentWeibo.api.ShortUrlOperations;
import org.springframework.social.tencentWeibo.api.StatusOperations;
import org.springframework.social.tencentWeibo.api.TagOperations;
import org.springframework.social.tencentWeibo.api.TencentWeibo;
import org.springframework.social.tencentWeibo.api.TweetOperations;
import org.springframework.social.tencentWeibo.api.UserOperations;
import org.springframework.social.tencentWeibo.api.VoteOperations;
import org.springframework.social.tencentWeibo.api.impl.json.TencentWeiboModule;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Gavin.Lin
 */
public class TencentWeiboTemplate extends AbstractOAuth2ApiBinding implements TencentWeibo {

    public static final String API_V1_BASE_URL = "http://open.t.qq.com/api";
    public static final String API_V2_BASE_URL = "https://open.t.qq.com/api";
    private FavoriteOperations favoriteOperations;
    private FriendOperations friendOperations;
    private HotTweetOperations hotTweetOperations;
    private InformationOperations informationOperations;
    private ListOperations listOperations;
    private LocationBasedServiceOperations locationBasedServiceOperations;
    private NotificationOperations notificationOperations;
    private OtherOperations otherOperations;
    private PrivateMessageOperations privateMessageOperations;
    private ShortUrlOperations shortUrlOperations;
    private StatusOperations statusOperations;
    private TagOperations tagOperations;
    private TweetOperations tweetOperations;
    private UserOperations userOperations;
    private VoteOperations voteOperations;
    private String applicationNamespace;
    private String accessToken;
    private String app_key;
    private String openid;
    private String localIP;
    private ObjectMapper objectMapper;
    private final String oauth_version = "2.a";
    private final String scope = "all";

    /**
     * Create a new instance of TencentWeiboTemplate.
     */
    public TencentWeiboTemplate() {
        initialize();
    }

    /**
     * ONLY for offline testting. Create a new instance of TencentWeiboTemplate.
     * This constructor creates the TencentWeiboTemplate using a given access
     * token.
     *
     * @param accessToken An access token given by TencentWeibo after a
     * successful OAuth 2 authentication.
     */
    @Deprecated
    public TencentWeiboTemplate(String accessToken) {
        this(accessToken, null);
    }

    public TencentWeiboTemplate(String accessToken, String app_key, String openid, String localIP) {
        super(accessToken);
        this.applicationNamespace = null;
        this.accessToken = accessToken;
        this.app_key = app_key;
        this.openid = openid;
        this.localIP = localIP;
        initialize();
    }

    public TencentWeiboTemplate(String accessToken, String applicationNamespace) {
        super(accessToken);
        this.applicationNamespace = applicationNamespace;
        initialize();
    }

    @Override
    public void setRequestFactory(ClientHttpRequestFactory requestFactory) {
        // Wrap the request factory with a BufferingClientHttpRequestFactory so that the error handler can do repeat reads on the response.getBody()
        super.setRequestFactory(ClientHttpRequestFactorySelector.bufferRequests(requestFactory));
    }

    // AbstractOAuth2ApiBinding hooks
    @Override
    protected OAuth2Version getOAuth2Version() {
        return OAuth2Version.BEARER_DRAFT_2;
    }

    @Override
    protected void configureRestTemplate(RestTemplate restTemplate) {
        restTemplate.setErrorHandler(new AyplusFacebookErrorHandler());
    }

    @Override
    protected List<HttpMessageConverter<?>> getMessageConverters() {
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
//        messageConverters.add(new StringHttpMessageConverter());
        messageConverters.add(getFormMessageConverter());
        messageConverters.add(getJsonMessageConverter());
        messageConverters.add(getByteArrayMessageConverter());
        return messageConverters;
    }

    @Override
    protected MappingJackson2HttpMessageConverter getJsonMessageConverter() {
        MappingJackson2HttpMessageConverter converter = super.getJsonMessageConverter();
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new TencentWeiboModule());
        converter.setObjectMapper(objectMapper);

        List<MediaType> supportedMediaTypes = new ArrayList<MediaType>();
        supportedMediaTypes.add(new MediaType("application", "json", DEFAULT_CHARSET));
        supportedMediaTypes.add(new MediaType("application", "*+json", DEFAULT_CHARSET));
        supportedMediaTypes.add(new MediaType("text", "plain", DEFAULT_CHARSET));
        supportedMediaTypes.add(new MediaType("text", "html", DEFAULT_CHARSET));
        supportedMediaTypes.add(new MediaType("text", "xml", DEFAULT_CHARSET));
        converter.setSupportedMediaTypes(supportedMediaTypes);

        return converter;
    }

    // private helpers
    private void initialize() {
        // Wrap the request factory with a BufferingClientHttpRequestFactory so that the error handler can do repeat reads on the response.getBody()
        super.setRequestFactory(ClientHttpRequestFactorySelector.bufferRequests(getRestTemplate().getRequestFactory()));
        initSubApis();
    }

    private void initSubApis() {
        favoriteOperations = new FavoriteTemplate(this, isAuthorized());
        friendOperations = new FriendTemplate(this, isAuthorized());
        hotTweetOperations = new HotTweetTemplate(this, isAuthorized());
        informationOperations = new InformationTemplate(this, isAuthorized());
        listOperations = new ListTemplate(this, isAuthorized());
        locationBasedServiceOperations = new LocationBasedServiceTemplate(this, isAuthorized());
        notificationOperations = new NotificationTemplate(this, isAuthorized());
        otherOperations = new OtherTemplate(this, isAuthorized());
        privateMessageOperations = new PrivateMessageTemplate(this, isAuthorized());
        shortUrlOperations = new ShortUrlTemplate(this, isAuthorized());
        statusOperations = new StatusTemplate(this, isAuthorized());
        tagOperations = new TagTemplate(this, isAuthorized());
        tweetOperations = new TweetTemplate(this, isAuthorized());
        userOperations = new UserTemplate(this, isAuthorized());
        voteOperations = new VoteTemplate(this, isAuthorized());
    }

    public FavoriteOperations favoriteOperations() {
        return favoriteOperations;
    }

    public FriendOperations friendOperations() {
        return friendOperations;
    }

    public HotTweetOperations hotTweetOperations() {
        return hotTweetOperations;
    }

    public InformationOperations informationOperations() {
        return informationOperations;
    }

    public ListOperations listOperations() {
        return listOperations;
    }

    public LocationBasedServiceOperations locationBasedServiceOperations() {
        return locationBasedServiceOperations;
    }

    public NotificationOperations notificationOperations() {
        return notificationOperations;
    }

    public OtherOperations otherOperations() {
        return otherOperations;
    }

    public PrivateMessageOperations privateMessageOperations() {
        return privateMessageOperations;
    }

    public ShortUrlOperations shortUrlOperations() {
        return shortUrlOperations;
    }

    public StatusOperations statusOperations() {
        return statusOperations;
    }

    public TagOperations tagOperations() {
        return tagOperations;
    }

    public TweetOperations tweetOperations() {
        return tweetOperations;
    }

    public UserOperations userOperations() {
        return userOperations;
    }

    public VoteOperations voteOperations() {
        return voteOperations;
    }

    protected MultiValueMap<String, String> insertOAuthInfor(MultiValueMap<String, String> paramsList) {
        paramsList.add("access_token", accessToken);
        paramsList.add("oauth_consumer_key", app_key);
        paramsList.add("openid", openid);
        paramsList.add("clientip", localIP);
        paramsList.add("oauth_version", oauth_version);
        paramsList.add("scope", scope);
        return paramsList;
    }

    public <T> T getResource(String url, MultiValueMap<String, String> paramsList, Class<T> type) {
        paramsList = insertOAuthInfor(paramsList); // add oauth information into paramsList
        URI uri = URIBuilder.fromUri(API_V2_BASE_URL + url).queryParams(paramsList).build();
        return getRestTemplate().getForObject(uri, type);
    }

    public <T> T postContent(String url, MultiValueMap<String, String> paramsList, Class<T> type) {
        paramsList = insertOAuthInfor(paramsList); // add oauth information into paramsList
        URI uri = URIBuilder.fromUri(API_V2_BASE_URL + url).queryParams(paramsList).build();
        return getRestTemplate().postForObject(uri, new LinkedMultiValueMap<String, String>(paramsList), type);
    }

    public <T> T postFile(String url, MultiValueMap<String, String> paramsList, MultiValueMap<String, String> files, Class<T> type) {
        URI uri = URIBuilder.fromUri(url).build();
        getRestTemplate().postForObject(uri, new LinkedMultiValueMap<String, String>(paramsList), String.class);
        return getRestTemplate().getForObject(uri, type);
    }
}
