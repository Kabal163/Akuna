package com.akuna.security.service.rest;

import com.akuna.security.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestServiceImpl implements UserRestService<User>
{
    @Override
    public ResponseEntity<User> register()
    {
        return null;
    }

    @Override
    public ResponseEntity<User> getUserByUsername(String username)
    {
        return null;
    }
}
