package com.akuna;


import com.akuna.security.entites.wrappers.CustomUserDetails;
import com.akuna.security.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;

@SpringBootApplication
//@EnableOAuth2Sso
public class Application
{
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public AuthorizationCodeResourceDetails authorizationCodeResourceDetails()
    {
        return new AuthorizationCodeResourceDetails();
    }

    @Autowired
    public void authenticationManager(AuthenticationManagerBuilder builder, UserRepository repo) throws Exception
    {
        builder.userDetailsService(s -> new CustomUserDetails(repo.findByUserName(s)));
    }

}
