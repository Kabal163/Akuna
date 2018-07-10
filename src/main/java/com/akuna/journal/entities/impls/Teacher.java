package com.akuna.journal.entities.impls;

import com.akuna.journal.entities.Person;
import com.akuna.journal.entities.visitor.PersonVisitor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "teachers")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "teacher_id"))
})
public class Teacher extends Person
{
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "teachers")
    private List<Section> sections = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "teacher")
    private List<Group> groups = new ArrayList<>();

    public Teacher(List<Section> sections, Project project)
    {
        super(project);
        this.sections = sections;
    }

    public Teacher(Project project)
    {
        super(project);
    }

    public List<Section> getSections()
    {
        return sections;
    }

    public void setSections(List<Section> sections)
    {
        this.sections = sections;
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

    public void addSection(Section section)
    {
        this.sections.add(section);
    }

    public void removeSection(Section section)
    {
        this.sections.remove(section);
    }

    @Override
    public void accept(PersonVisitor visitor)
    {
        visitor.visit(this);
    }

    @Override
    public String toString()
    {
        return "Teacher{" +
                "sections=" + sections +
                ", groups=" + groups +
                '}';
    }
}
