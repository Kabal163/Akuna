package com.akuna.security.exceptions;

import com.akuna.security.models.token.JwtToken;
import org.springframework.security.core.AuthenticationException;

public class JwtExpiredTokenException extends AuthenticationException
{
    private JwtToken token;

    public JwtExpiredTokenException(String msg)
    {
        super(msg);
    }

    public JwtExpiredTokenException(String msg, Throwable t, JwtToken token)
    {
        super(msg, t);
        this.token = token;
    }

    public String token()
    {
        return this.token.getToken();
    }
}
