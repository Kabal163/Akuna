package com.akuna.security.entities;

import com.akuna.journal.entities.AbstractEntity;

import javax.persistence.*;

@Entity
@Table(name = "roles", schema = "akuna_std")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "role_id"))
})
public class Role extends AbstractEntity
{
    private String name;

    public Role(String name)
    {
        this.name = name;
    }


    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "Role{" +
                ", name='" + name + '\'' +
                '}';
    }
}
