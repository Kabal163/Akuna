package com.akuna.journal.entities;

import com.akuna.journal.entities.abstracts.AbstractEntity;
import com.google.api.client.util.DateTime;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Date;
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
