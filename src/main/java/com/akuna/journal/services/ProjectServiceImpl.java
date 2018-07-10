package com.akuna.journal.services;

import com.akuna.journal.entities.impls.Project;
import com.akuna.journal.dao.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService
{
    private final ProjectRepository repository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository repository)
    {
        this.repository = repository;
    }

    public void save(Project project)
    {
        repository.save(project);
    }

    public Optional<Project> getById(BigInteger id)
    {
        return repository.findById(id);
    }

    public Project getNewProject()
    {
        return new Project();
    }
}
