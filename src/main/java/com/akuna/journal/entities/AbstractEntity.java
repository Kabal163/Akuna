package com.akuna.journal.entities;

import javax.persistence.*;
import java.math.BigInteger;

@MappedSuperclass
public abstract class AbstractEntity
{
    @Id
    @GeneratedValue
    private BigInteger id;

    public void setId(BigInteger id)
    {
        this.id = id;
    }

    public BigInteger getId()
    {
        return id;
    }
}
