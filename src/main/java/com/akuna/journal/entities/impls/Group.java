package com.akuna.journal.entities.impls;

import com.akuna.journal.entities.AkunaEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "GROUPS")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "GROUP_ID"))
})
public class Group extends AkunaEntity
{
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "groups")
    private List<Section> sections = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "USERS_TO_GROUPS",
    joinColumns = {@JoinColumn(name = "GROUP_ID", referencedColumnName = "GROUP_ID")},
    inverseJoinColumns = {@JoinColumn(name = "STUDENT_ID", referencedColumnName = "STUDENT_ID")})
    private List<Student> students = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEACHER_ID", referencedColumnName = "TEACHER_ID")
    private Teacher teacher;

    @Column(name = "GROUP_NAME")
    private String groupName;

    @Column(name = "GROUP_NUMBER")
    private String groupNumber;

    public Group(String groupNumber, Section section, Project project)
    {
        super(project);
        this.groupNumber = groupNumber;
        this.sections.add(section);
    }

    public Group(List<Section> sections, String groupNumber, Project project)
    {
        super(project);
        this.sections = sections;
        this.groupNumber = groupNumber;
    }

    public List<Section> getSections()
    {
        return sections;
    }

    public void setSections(List<Section> sections)
    {
        this.sections = sections;
    }

    public Teacher getTeacher()
    {
        return teacher;
    }

    public void setTeacher(Teacher teacher)
    {
        this.teacher = teacher;
    }

    public String getGroupName()
    {
        return groupName;
    }

    public void setGroupName(String groupName)
    {
        this.groupName = groupName;
    }

    public String getGroupNumber()
    {
        return groupNumber;
    }

    public void setGroupNumber(String groupNumber)
    {
        this.groupNumber = groupNumber;
    }

    private void addSection(Section section)
    {
        this.sections.add(section);
    }

    private void removeSection(Section section)
    {
        sections.remove(section);
    }

    public void addStudent(Student student)
    {
        this.students.add(student);
    }

    public void removeStudent(Student student)
    {
        this.students.remove(student);
    }

    @Override
    public String toString()
    {
        return "Group{" +
                ", sections=" + sections +
                ", students=" + students +
                ", teacher=" + teacher +
                ", groupName='" + groupName + '\'' +
                ", groupNumber='" + groupNumber + '\'' +
                '}';
    }
}
