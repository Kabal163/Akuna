package com.akuna.security.models;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.GrantedAuthority;

/*
 *
 * @author dmitrii.kanaev
 *
 * Jul 7, 2018
 */

import java.util.Set;

public class UserContext
{
    private final String username;
    private final Set<GrantedAuthority> authorities;

    private UserContext(String username, Set<GrantedAuthority> authorities)
    {
        this.username = username;
        this.authorities = authorities;
    }

    public static UserContext create(String username, Set<GrantedAuthority> authorities)
    {
        if (StringUtils.isBlank(username)) throw new IllegalArgumentException("Username is blank");
        return new UserContext(username, authorities);
    }

    public String getUsername()
    {
        return username;
    }

    public Set<GrantedAuthority> getAuthorities()
    {
        return authorities;
    }
}
