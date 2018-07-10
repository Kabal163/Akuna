package com.akuna.security.service;

import com.akuna.journal.dao.UserRepository;
import com.akuna.journal.entities.impls.Administrator;
import com.akuna.security.entities.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.exact;

@Service
public class UserServiceImpl implements UserService
{
    private final UserRepository repository;

    private final PasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository repository,
                           PasswordEncoder bCryptPasswordEncoder)
    {
        this.repository = repository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public void save(User user) {
        checkLogin(user);
        checkPassword(user);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        repository.save(user);
    }

    @Override
    public Optional<User> getByUsername(String username) {
        return repository.findByUsername(username);
    }

    private void checkPassword(User user)
    {
        if (user.getPassword() == null
                || StringUtils.isBlank(user.getPassword()))
            throw new IllegalArgumentException("Password cannot be empty");

        else if (StringUtils.containsWhitespace(user.getPassword())
                || StringUtils.containsAny(user.getPassword(), '/', '\\', '\'', '"', '%'))
            throw new IllegalArgumentException("Password contains unsuitable characters");

        else if (!StringUtils.equals(user.getPassword(), user.getConfirmPassword()))
            throw new IllegalArgumentException("Password doesn't match confirmed password");
    }

    private void checkLogin(User user)
    {
        if (user.getUsername() == null
                || StringUtils.isBlank(user.getUsername()))
            throw new IllegalArgumentException("Username cannot be empty");
        if (exists(user))
            throw new IllegalArgumentException("Such user has already registered");
    }

    public boolean exists(User user)
    {
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("phoneNumber", exact())
                .withMatcher("email", exact());

        Example<User> example = Example.of(user, matcher);

        return repository.exists(example);
    }
}
