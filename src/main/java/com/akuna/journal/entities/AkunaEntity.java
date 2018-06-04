package com.akuna.journal.entities;

import com.akuna.journal.entities.impls.Project;

import javax.persistence.*;

@MappedSuperclass
public abstract class AkunaEntity extends AbstractEntity
{
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PROJECT_ID", referencedColumnName = "PROJECT_ID")
    private Project project;

    public AkunaEntity(Project project)
    {
        this.project = project;
    }

    public Project getProject()
    {
        return project;
    }
}
