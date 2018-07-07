package com.akuna.security.models.token;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.jsonwebtoken.Claims;

/*
 *
 * @author dmitrii.kanaev
 *
 * Jul 7, 2018
 */

public class AccessJwtToken implements JwtToken
{
    private final String raw_token;

    @JsonIgnore
    private Claims claims;

    public AccessJwtToken(final String token, Claims claims)
    {
        this.raw_token = token;
        this.claims = claims;
    }

    @Override
    public String getToken()
    {
        return this.raw_token;
    }

    public Claims getClaims()
    {
        return claims;
    }
}
