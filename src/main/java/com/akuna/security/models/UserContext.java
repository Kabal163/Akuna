package com.akuna.security.models;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.GrantedAuthority;

/*
 *
 * @author dmitrii.kanaev
 *
 * Jul 7, 2018
 */

import java.util.List;
import java.util.Set;

public class UserContext
{
    private final String username;
    private final List<GrantedAuthority> authorities;

    private UserContext(String username, List<GrantedAuthority> authorities)
    {
        this.username = username;
        this.authorities = authorities;
    }

    public static UserContext create(String username, List<GrantedAuthority> authorities)
    {
        if (StringUtils.isBlank(username)) throw new IllegalArgumentException("Username is blank");
        return new UserContext(username, authorities);
    }

    public String getUsername()
    {
        return username;
    }

    public List<GrantedAuthority> getAuthorities()
    {
        return authorities;
    }
}
