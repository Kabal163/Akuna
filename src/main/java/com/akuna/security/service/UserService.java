package com.akuna.security.service;

import com.akuna.security.entities.User;

import java.util.Optional;

public interface UserService
{
    void save(User user);

    Optional<User> getByUsername(String username);

    boolean exists(User user);
}
