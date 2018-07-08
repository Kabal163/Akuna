package com.akuna.security.auth.jwt.extractor;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.stereotype.Component;

/*
 *
 * @author dmitrii.kanaev
 *
 * Jul 8, 2018
 */

@Component
public class JwtHeaderTokenExtractor implements TokenExtractor
{
    public static final String HEADER_PREFIX = "Bearer ";

    @Override
    public String extract(String header)
    {
        if (StringUtils.isBlank(header))
            throw new AuthenticationServiceException("Authorization header cannot be blank!");

        if (header.length() < HEADER_PREFIX.length())
            throw new AuthenticationServiceException("Invalid authorization header size");

        return header.substring(HEADER_PREFIX.length(), header.length());
    }
}
