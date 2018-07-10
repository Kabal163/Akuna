package com.akuna.security.entities;

import com.akuna.journal.entities.Person;
import com.akuna.journal.entities.impls.*;
import com.akuna.journal.entities.AkunaEntity;
import com.akuna.journal.entities.visitor.PersonVisitor;
import org.hibernate.annotations.Check;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
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
    @JoinColumn(name = "admin_id", referencedColumnName = "admin_id")
    @Check(constraints = "teacher_id is null and parent_id is null and student_id is null")
    private Administrator administrator;

    @OneToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "teacher_id")
    @Check(constraints = "admin_id is null and parent_id is null and student_id is null")
    private Teacher teacher;

    @OneToOne
    @JoinColumn(name = "parent_id", referencedColumnName = "parent_id")
    @Check(constraints = "teacher_id is null and admin_id is null and student_id is null")
    private Parent parent;

    @OneToOne
    @JoinColumn(name = "student_id", referencedColumnName = "student_id")
    @Check(constraints = "teacher_id is null and parent_id is null and admin_id is null")
    private Student student;

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
                Person person,
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
        setPerson(person);
    }

    public User(Project project) {
        super(project);
        this.roles = new HashSet<>();
    }

    public void setPerson(Person person)
    {
        //todo throw some exception
        if (getPerson() != null)
        {
            return;
        }

        PersonVisitor visitor = new PersonVisitor()
        {
            @Override
            public void visit(Administrator administrator)
            {
                setPerson(administrator);
            }

            @Override
            public void visit(Parent parent)
            {
                setPerson(parent);
            }

            @Override
            public void visit(Teacher teacher)
            {
                setPerson(teacher);
            }

            @Override
            public void visit(Student student)
            {
                setPerson(student);
            }
        };

        person.accept(visitor);
    }

    public Person getPerson()
    {
        return administrator != null
                ? administrator : teacher != null
                ? teacher : parent != null
                ? parent : student;
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

    private void setPerson(Administrator administrator)
    {
        this.administrator = administrator;
    }

    private void setPerson(Teacher teacher)
    {
        this.teacher = teacher;
    }

    private void setPerson(Parent parent)
    {
        this.parent = parent;
    }

    private void setPerson(Student student)
    {
        this.student = student;
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
