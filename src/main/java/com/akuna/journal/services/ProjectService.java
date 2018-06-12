package com.akuna.journal.services;

import com.akuna.journal.entities.impls.Project;
import com.akuna.journal.dao.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class ProjectService
{
    @Autowired
    private ProjectRepository repository;

    public void save(Project project)
    {
        repository.save(project);
    }

    public Project getById(BigInteger id)
    {
        return repository.getOne(id);
    }

    public Project getNewProject()
    {
        return new Project();
    }
}
