package com.akuna.journal.entities.impls;

import com.akuna.journal.entities.Person;
import com.akuna.journal.entities.visitor.PersonVisitor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "student_id"))
})
public class Student extends Person
{
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "students")
    private List<Parent> parents = new ArrayList<>(2);

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "students")
    private List<Group> groups = new ArrayList<>();

    public Student(Project project)
    {
        super(project);
    }

    public List<Parent> getParents()
    {
        return parents;
    }

    public void setParents(List<Parent> parents)
    {
        this.parents = parents;
    }

    public void addParent(Parent parent)
    {
        this.parents.add(parent);
    }

    public void removeParent(Parent parent)
    {
        this.parents.remove(parent);
    }

    public List<Group> getGroups()
    {
        return groups;
    }

    public void setGroups(List<Group> groups)
    {
        this.groups = groups;
    }

    public void addGroup(Group group)
    {
        this.groups.add(group);
    }

    public void removeGroup(Group group)
    {
        this.groups.remove(group);
    }

    @Override
    public void accept(PersonVisitor visitor)
    {
        visitor.visit(this);
    }

    @Override
    public String toString()
    {
        return "Student{" +
                "parents=" + parents +
                ", groups=" + groups +
                '}';
    }
}
