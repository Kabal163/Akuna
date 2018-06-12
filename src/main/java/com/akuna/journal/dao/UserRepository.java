package com.akuna.journal.dao;

import com.akuna.security.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface UserRepository extends JpaRepository<User, BigInteger>
{
    User findByUsername(String username);
}
