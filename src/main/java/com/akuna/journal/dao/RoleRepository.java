package com.akuna.journal.dao;

import com.akuna.security.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface RoleRepository extends JpaRepository<Role, BigInteger>
{
    Role getRoleByRoleName(String roleName);
}
