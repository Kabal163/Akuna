package com.akuna.journal.services;

import com.akuna.journal.entities.impls.Administrator;
import com.akuna.journal.dao.AdministratorRepository;
import com.akuna.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.exact;

@Service
public class AdministratorService
{
    private final AdministratorRepository repository;

    @Autowired
    public AdministratorService(AdministratorRepository repository)
    {
        this.repository = repository;
    }

    @Transactional
    public void save(Administrator administrator)
    {
        repository.save(administrator);
    }
}
