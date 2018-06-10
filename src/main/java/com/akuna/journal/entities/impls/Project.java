package com.akuna.journal.entities.impls;

import com.akuna.journal.entities.AbstractEntity;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "projects")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "project_id"))
})public class Project extends AbstractEntity
{
    @Temporal(TemporalType.DATE)
    @Column(name="creation_date")
    private Calendar creationDate;

    public Project() {}

    public Calendar getCreationDate()
    {
        return creationDate;
    }

    public void setCreationDate(Calendar creationDate) {
        this.creationDate = creationDate;
    }
}
