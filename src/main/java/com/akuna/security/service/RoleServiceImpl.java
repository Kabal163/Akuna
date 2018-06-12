package com.akuna.security.service;

import com.akuna.journal.dao.RoleRepository;
import com.akuna.security.entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService
{
    @Autowired
    private RoleRepository repository;

    @Override
    public Role getDefaultRole()
    {
        return getRoleByRoleName("User");
    }

    @Override
    public Role getRoleByRoleName(String roleName)
    {
        return repository.getRoleByRoleName(roleName);
    }

    @Override
    public void save(Role role)
    {
        repository.save(role);
    }
}
