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
    @Column(name = "role_name")
    private String roleName;

    public Role(String roleName)
    {
        this.roleName = roleName;
    }


    public String getRoleName()
    {
        return roleName;
    }

    public void setRoleName(String roleName)
    {
        this.roleName = roleName;
    }

    @Override
    public String toString()
    {
        return "Role{" +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
