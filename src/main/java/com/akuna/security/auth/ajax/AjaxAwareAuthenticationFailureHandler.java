package com.akuna.security.auth.ajax;

import com.akuna.common.ErrorCode;
import com.akuna.common.ErrorResponse;
import com.akuna.security.exceptions.AuthMethodNotSupportedException;
import com.akuna.security.exceptions.JwtExpiredTokenException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
 *
 * @author dmitrii.kanaev
 *
 * Jul 7, 2018
 */

public class AjaxAwareAuthenticationFailureHandler implements AuthenticationFailureHandler
{
    private final ObjectMapper mapper;

    public AjaxAwareAuthenticationFailureHandler(ObjectMapper mapper)
    {
        this.mapper = mapper;
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response,
                                        AuthenticationException e)
            throws IOException
    {
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);

        if (e instanceof BadCredentialsException)
        {
            mapper.writeValue(response.getWriter(), ErrorResponse.of("Invalid username or password", ErrorCode.AUTHENTICATION, HttpStatus.UNAUTHORIZED));
        }
        else if (e instanceof JwtExpiredTokenException)
        {
            mapper.writeValue(response.getWriter(), ErrorResponse.of("Token has expired", ErrorCode.JWT_TOKEN_EXPIRED, HttpStatus.UNAUTHORIZED));
        }
        else if (e instanceof AuthMethodNotSupportedException)
        {
            mapper.writeValue(response.getWriter(), ErrorResponse.of(e.getMessage(), ErrorCode.AUTHENTICATION, HttpStatus.UNAUTHORIZED));
        }

        mapper.writeValue(response.getWriter(), ErrorResponse.of("Authentication failed", ErrorCode.AUTHENTICATION, HttpStatus.UNAUTHORIZED));
    }
}