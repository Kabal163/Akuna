package com.akuna.journal.entities;

import com.akuna.journal.entities.impls.Project;

import javax.persistence.*;

@MappedSuperclass
public abstract class AkunaEntity extends AbstractEntity
{
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "project_id", referencedColumnName = "project_id")
    private Project project;

    public AkunaEntity(Project project)
    {
        this.project = project;
    }

    public AkunaEntity() {}

    public Project getProject()
    {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
