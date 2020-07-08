package com.lzpeng.minimal.common.security.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * OAuth2 属性配置
 * @author: Lzpeng
 */
@Data
@ConfigurationProperties(prefix = "minimal.security.oauth2.client")
public class OAuth2Properties {

    private String clientId = "clientId";

    private String clientSecret = "clientSecret";

    private String registeredRedirectUri;

    private String[] grantType = { "authorization_code", "password", "refresh_token" };

    private String[] scopes = {"all"};

    private String[] permitAllUrls = {};
    /**
     * accessToken过期时间 秒
     */
    private int accessTokenValiditySeconds = 3600;
    /**
     * refreshToken过期时间 秒
     */
    private int refreshTokenValiditySeconds = 86400;
}
