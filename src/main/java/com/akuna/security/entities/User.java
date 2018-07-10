package com.akuna.security.entities;

import com.akuna.journal.entities.Person;
import com.akuna.journal.entities.impls.Project;
import com.akuna.journal.entities.AkunaEntity;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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

    @OneToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;

    @ElementCollection(targetClass = Role.class)
    @CollectionTable(name = "user_role",
        joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    private Set<Role> roles;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private CharSequence password;

    @Column(name = "active")
    private boolean isActive;

    @Transient
    private CharSequence confirmPassword;

    public User(Project project, Person person, Set<Role> roles, String username, CharSequence password, boolean isActive, CharSequence confirmPassword)
    {
        super(project);
        this.person = person;
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

    public Person getPerson()
    {
        return person;
    }

    public void setPerson(Person person)
    {
        this.person = person;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public CharSequence getPassword()
    {
        return password;
    }

    public void setPassword(CharSequence password)
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
                "person=" + person +
                ", roles=" + roles +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", isActive=" + isActive +
                ", confirmPassword='" + confirmPassword + '\'' +
                '}';
    }
}
