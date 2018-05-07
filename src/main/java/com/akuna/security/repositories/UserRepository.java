package com.akuna.security.repositories;

import com.akuna.security.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface UserRepository extends JpaRepository<User, BigInteger>
{
    User findByUserName(String userName);
}
