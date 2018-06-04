package com.akuna.journal.entities.impls;

import com.akuna.journal.entities.AbstractEntity;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "PROJECTS")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "PROJECT_ID"))
})public class Project extends AbstractEntity
{
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="CREATION_DATE")
    private Calendar creationDate;

    public Calendar getCreationDate()
    {
        return creationDate;
    }
}
