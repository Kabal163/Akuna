package com.akuna.security.entities;

import com.akuna.journal.entities.impls.*;
import com.akuna.journal.entities.AkunaEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users", schema = "akuna_std")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "user_id"))
})
public class User extends AkunaEntity
{
//    @ManyToMany
//    @JoinTable(name = "users_to_roles",
//    joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "user_id")},
//    inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "role_id")})
//    private Set<Role> roles;


    @ElementCollection(targetClass = Role.class)
    @CollectionTable(name = "user_role",
        joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "active")
    private boolean isActive;

    @Transient
    private CharSequence confirmPassword;

    public User(Project project,
                Set<Role> roles,
                String username,
                String password,
                boolean isActive,
                CharSequence confirmPassword)
    {
        super(project);
        this.roles = roles;
        this.username = username;
        this.password = password;
        this.isActive = isActive;
        this.confirmPassword = confirmPassword;
    }

    public User(Project project) {
        super(project);
        this.roles = new HashSet<>();
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
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

    public Set<Role> getRoles()
    {
        return roles;
    }

    public void setRoles(Set<Role> roles)
    {
        this.roles = roles;
    }

    public CharSequence getConfirmPassword()
    {
        return confirmPassword;
    }

    public void setConfirmPassword(CharSequence confirmPassword)
    {
        this.confirmPassword = confirmPassword;
    }

    public boolean isActive()
    {
        return isActive;
    }

    public void setActive(boolean active)
    {
        isActive = active;
    }

    @Override
    public String toString()
    {
        return "User{" +
                ", roles=" + roles +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", isActive=" + isActive +
                ", confirmPassword='" + confirmPassword + '\'' +
                '}';
    }
}
