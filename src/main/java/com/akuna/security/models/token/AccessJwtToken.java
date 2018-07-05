package com.akuna.security.models.token;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.jsonwebtoken.Claims;

public class AccessJwtToken implements JwtToken
{
    private final String RAW_TOKEN;

    @JsonIgnore
    private Claims claims;

    public AccessJwtToken(final String token, Claims claims)
    {
        this.RAW_TOKEN = token;
        this.claims = claims;
    }

    @Override
    public String getToken()
    {
        return null;
    }

    public Claims getClaims()
    {
        return claims;
    }
}
