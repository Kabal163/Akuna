package com.akuna.security.entites;

import com.akuna.journal.entities.AbstractEntity;

import javax.persistence.*;

@Entity
@Table(name = "ROLES")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "ROLE_ID"))
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
