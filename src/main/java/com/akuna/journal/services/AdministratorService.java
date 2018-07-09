package com.akuna.journal.services;

import com.akuna.journal.entities.impls.Administrator;
import com.akuna.journal.entities.impls.Project;
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
    private final UserService userService;
    private final ProjectService projectService;

    @Autowired
    public AdministratorService(AdministratorRepository repository,
                                UserService userService,
                                ProjectService projectService)
    {
        this.repository = repository;
        this.userService = userService;
        this.projectService = projectService;
    }

    @Transactional
    public boolean save(Administrator administrator)
    {
        if (exists(administrator)) return false;

        projectService.save(administrator.getProject());
        userService.save(administrator.getUser());
        repository.save(administrator);

        return true;
    }

    public boolean exists(Administrator administrator)
    {
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("phoneNumber", exact())
                .withMatcher("email", exact());

        Example<Administrator> example = Example.of(administrator, matcher);

        return repository.exists(example);
    }
}
