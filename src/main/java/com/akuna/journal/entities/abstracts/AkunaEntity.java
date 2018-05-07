package com.akuna.journal.entities.abstracts;

import com.akuna.journal.entities.Project;
import com.akuna.journal.entities.abstracts.AbstractEntity;

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
