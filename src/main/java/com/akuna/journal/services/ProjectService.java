package com.akuna.journal.services;

import com.akuna.journal.entities.impls.Project;

import java.math.BigInteger;
import java.util.Optional;

public interface ProjectService
{
    public void save(Project project);

    Optional<Project> getById(BigInteger id);

    Project getNewProject();
}
