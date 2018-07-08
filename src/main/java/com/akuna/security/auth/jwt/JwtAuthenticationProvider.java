package com.akuna.security.auth.jwt;

import com.akuna.security.auth.JwtAuthenticationToken;
import com.akuna.security.config.JwtSettings;
import com.akuna.security.models.Scopes;
import com.akuna.security.models.UserContext;
import com.akuna.security.models.token.RawAccessJwtToken;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/*
 *
 * @author dmitrii.kanaev
 *
 * Jul 8, 2018
 */

@Component
public class JwtAuthenticationProvider implements AuthenticationProvider
{
    private final JwtSettings settings;

    @Autowired
    public JwtAuthenticationProvider(JwtSettings settings)
    {
        this.settings = settings;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException
    {
        RawAccessJwtToken rawAccessToken = (RawAccessJwtToken) authentication.getCredentials();

        Jws<Claims> jwsClaims = rawAccessToken.parseClaims(settings.getTokenSigningKey());
        String subject = jwsClaims.getBody().getSubject();
        List<String> scopes = jwsClaims.getBody().get("scopes", List.class);
        List<GrantedAuthority> authorities = scopes.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
        UserContext userContext = UserContext.create(subject, authorities);

        return new JwtAuthenticationToken(userContext, authorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (JwtAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
