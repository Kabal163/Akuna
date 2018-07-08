package com.akuna.security.auth;

import com.akuna.security.models.UserContext;
import com.akuna.security.models.token.RawAccessJwtToken;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/*
 * An {@link org.springframework.security.core.Authentication} implementation
 * that is designed for simple presentation of JwtToken.
 *
 * @author dmitrii.kanaev
 *
 * Jul 8, 2018
 */


public class JwtAuthenticationToken extends AbstractAuthenticationToken
{
    private RawAccessJwtToken rawAccessToken;
    private UserContext userContext;

    public JwtAuthenticationToken(RawAccessJwtToken unsafeToken )
    {
        super(null);
        this.rawAccessToken = unsafeToken;
        this.setAuthenticated(false);
    }

    public JwtAuthenticationToken(UserContext userContext, Collection<? extends GrantedAuthority> authorities)
    {
        super(authorities);
        this.eraseCredentials();
        this.userContext = userContext;
        this.setAuthenticated(true);
    }

    @Override
    public Object getCredentials()
    {
        return rawAccessToken;
    }

    @Override
    public Object getPrincipal()
    {
        return userContext;
    }

    @Override
    public void setAuthenticated(boolean authenticated)
    {
        if (authenticated)
            throw new IllegalArgumentException("Cannot set this token to trusted - use constructor which takes a GrantedAuthority list instead");

        super.setAuthenticated(false);
    }

    @Override
    public void eraseCredentials() {
        super.eraseCredentials();
        this.rawAccessToken = null;
    }
}
