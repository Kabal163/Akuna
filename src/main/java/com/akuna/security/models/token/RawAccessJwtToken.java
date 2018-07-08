package com.akuna.security.models.token;

import com.akuna.security.exceptions.JwtExpiredTokenException;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.BadCredentialsException;

public class RawAccessJwtToken implements JwtToken
{
    private static Logger LOGGER = LoggerFactory.getLogger(RawAccessJwtToken.class);

    private final String token;

    public RawAccessJwtToken(String token)
    {
        this.token = token;
    }

    /**
     * Parses and validates JWT Token signature.
     *
     * @throws BadCredentialsException
     * @throws JwtExpiredTokenException
     *
     */

    public Jws<Claims> parseClaims(String signingKey)
    {
        try
        {
            return Jwts.parser().setSigningKey(signingKey).parseClaimsJws(this.token);
        }
        catch (UnsupportedJwtException | MalformedJwtException | IllegalArgumentException | SignatureException ex)
        {
            LOGGER.error("Invalid JWT token", ex);
            throw new BadCredentialsException("Invalid JWT token", ex);
        }
        catch (ExpiredJwtException ex)
        {
            LOGGER.info("JWT Token is expired", ex);
            throw new JwtExpiredTokenException(this, "JWT Token expired", ex);
        }
    }

    @Override
    public String getToken()
    {
        return token;
    }
}
