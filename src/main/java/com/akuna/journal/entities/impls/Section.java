package com.akuna.journal.entities.impls;

import com.akuna.journal.entities.AkunaEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sections")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "section_id"))
})
public class Section extends AkunaEntity
{
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "sections_to_groups",
    joinColumns = {@JoinColumn(name = "section_id", referencedColumnName = "section_id")},
    inverseJoinColumns = {@JoinColumn(name = "group_id", referencedColumnName = "group_id")})
    private List<Group> groups = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "sections_to_teachers",
    joinColumns = {@JoinColumn(name = "section_id", referencedColumnName = "section_id")},
    inverseJoinColumns = {@JoinColumn(name = "teacher_id", referencedColumnName = "teacher_id")})
    private List<Teacher> teachers = new ArrayList<>();

    @Column(name = "section_name")
    private String sectionName;

    public Section(String sectionName, Project project)
    {
        super(project);
        this.sectionName = sectionName;
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

    public List<Teacher> getTeachers()
    {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers)
    {
        this.teachers = teachers;
    }

    public void addTeacher(Teacher teacher)
    {
        this.teachers.add(teacher);
    }

    public void removeTeacher(Teacher teacher)
    {
        this.teachers.remove(teacher);
    }

    public String getSectionName()
    {
        return sectionName;
    }

    public void setSectionName(String sectionName)
    {
        this.sectionName = sectionName;
    }

    @Override
    public String toString()
    {
        return "Section{" +
                ", groups=" + groups +
                ", teachers=" + teachers +
                ", sectionName='" + sectionName + '\'' +
                '}';
    }
}
