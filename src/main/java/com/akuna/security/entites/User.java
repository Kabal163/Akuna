package com.akuna.security.entites;

import com.akuna.journal.entities.impls.Project;
import com.akuna.journal.entities.AkunaEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USERS")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "USER_ID"))
})
public class User extends AkunaEntity
{
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "USERS_ROLES",
    joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")},
    inverseJoinColumns = {@JoinColumn(name = "ROLE_ID", referencedColumnName = "ROLE_ID")})
    private List<Role> roles = new ArrayList<>(2);

    private String userName;
    private String password;

    public User(List<Role> roles, String userName, String password, Project project)
    {
        super(project);
        this.roles = roles;
        this.userName = userName;
        this.password = password;
    }

    public User(String userName, String password, Project project)
    {
        super(project);
        this.userName = userName;
        this.password = password;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public void addRole(Role role)
    {
        this.roles.add(role);
    }

    public void removeRole(Role role)
    {
        this.roles.remove(role);
    }

    public List<Role> getRoles()
    {
        return roles;
    }

    public void setRoles(List<Role> roles)
    {
        this.roles = roles;
    }

    @Override
    public String toString()
    {
        return "User{" +
                ", roles=" + roles +
                ", userName='" + userName + '\'' +
                '}';
    }
}
