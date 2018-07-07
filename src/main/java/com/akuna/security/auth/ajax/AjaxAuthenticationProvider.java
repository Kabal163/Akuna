package com.akuna.security.auth.ajax;

import com.akuna.security.entities.User;
import com.akuna.security.models.UserContext;
import com.akuna.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/*
 *
 * @author dmitrii.kanaev
 *
 * Jul 7, 2018
 */

@Component
public class AjaxAuthenticationProvider implements AuthenticationProvider
{
    private final BCryptPasswordEncoder encoder;
    private final UserService userService;

    //todo ENCODER
    @Autowired
    public AjaxAuthenticationProvider(/*final BCryptPasswordEncoder encoder,*/ final UserService userService)
    {
        this.encoder = new BCryptPasswordEncoder();//encoder;
        this.userService = userService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException
    {
       Assert.notNull(authentication, "No authentication data provided");

       String username = (String) authentication.getPrincipal();
       CharSequence password = (CharSequence) authentication.getCredentials();

       User user = userService.getByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found " + username));

       if (!encoder.matches(password, user.getPassword()))
       {
           throw new BadCredentialsException("Authentication failed. Username or password not valid");
       }

       if (user.getRoles() == null) throw new InsufficientAuthenticationException("User has no roles assigned");

       Set<GrantedAuthority> authorities = user.getRoles().stream()
               .map(role -> new SimpleGrantedAuthority(role.authority()))
               .collect(Collectors.toSet());

       UserContext userContext = UserContext.create(username, authorities);

       return new UsernamePasswordAuthenticationToken(userContext, null, userContext.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication)
    {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
