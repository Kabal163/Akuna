package com.akuna.security.service.rest;

import com.akuna.security.entities.User;
import org.springframework.http.ResponseEntity;

public interface UserRestService<T>
{
    ResponseEntity<T> register();

    ResponseEntity<T> getUserByUsername(String username);
}
