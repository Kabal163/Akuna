package com.akuna.security.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/*
 *
 * @author dmitrii.kanaev
 *
 * Jul 7, 2018
 */

@Configuration
@ConfigurationProperties(prefix = "akuna.security.jwc")
public class JwtSettings
{
    private Integer tokenExpirationTime;

    private String tokenIssuer;

    private String tokenSigningKey;

    private Integer refreshTokenExpirationTime;

    public Integer getTokenExpirationTime()
    {
        return tokenExpirationTime;
    }

    public void setTokenExpirationTime(Integer tokenExpirationTime)
    {
        this.tokenExpirationTime = tokenExpirationTime;
    }

    public String getTokenIssuer()
    {
        return tokenIssuer;
    }

    public void setTokenIssuer(String tokenIssuer)
    {
        this.tokenIssuer = tokenIssuer;
    }

    public String getTokenSigningKey()
    {
        return tokenSigningKey;
    }

    public void setTokenSigningKey(String tokenSigningKey)
    {
        this.tokenSigningKey = tokenSigningKey;
    }

    public Integer getRefreshTokenExpirationTime()
    {
        return refreshTokenExpirationTime;
    }

    public void setRefreshTokenExpirationTime(Integer refreshTokenExpirationTime)
    {
        this.refreshTokenExpirationTime = refreshTokenExpirationTime;
    }
}
