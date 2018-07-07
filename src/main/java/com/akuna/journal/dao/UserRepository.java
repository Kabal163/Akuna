package com.akuna.journal.dao;

import com.akuna.security.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, BigInteger>
{
    Optional<User> findByUsername(String username);
}
