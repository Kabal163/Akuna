package com.akuna.security.models.token;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

/*
 *
 * @author dmitrii.kanaev
 *
 * Jul 7, 2018
 */

public class RefreshJwtToken implements JwtToken
{
    private final Jws<Claims> claims;

    public RefreshJwtToken(Jws<Claims> claims)
    {
        this.claims = claims;
    }

    @Override
    public String getToken()
    {
        return null;
    }
}
