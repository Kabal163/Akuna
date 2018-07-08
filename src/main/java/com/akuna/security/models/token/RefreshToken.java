package com.akuna.security.models.token;

import com.akuna.security.models.Scopes;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

import java.util.List;
import java.util.Optional;

/*
 *
 * @author dmitrii.kanaev
 *
 * Jul 7, 2018
 */

public class RefreshToken implements JwtToken
{
    private final Jws<Claims> claims;


    public RefreshToken(Jws<Claims> claims)
    {
        this.claims = claims;
    }

    public static Optional<RefreshToken> create(RawAccessJwtToken rawToken, String signingKey)
    {
        Jws<Claims> claims = rawToken.parseClaims(signingKey);

        List<String> scopes = claims.getBody().get("scopes", List.class);
        if (scopes == null || scopes.isEmpty() || scopes.stream().noneMatch(s -> Scopes.REFRESH_TOKEN.name().equals(s)))
            return Optional.empty();

        return Optional.of(new RefreshToken(claims));
    }

    @Override
    public String getToken()
    {
        return null;
    }

    public Jws<Claims> getClaims() {
        return claims;
    }

    public String getJti() {
        return claims.getBody().getId();
    }

    public String getSubject() {
        return claims.getBody().getSubject();
    }
}
