package com.akuna.security.service;

import com.akuna.security.entities.Role;

public interface RoleService
{
    Role getDefaultRole();

    Role getRoleByRoleName(String roleName);

    void save(Role role);
}
