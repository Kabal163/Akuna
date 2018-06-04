package com.akuna.journal.entities.impls;

import com.akuna.journal.entities.Person;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PARENTS")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "PARENT_ID"))
})
public class Parent extends Person
{
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "STUDENTS_TO_PARENTS",
    joinColumns = {@JoinColumn(name = "PARENT_ID", referencedColumnName = "PARENT_ID")},
    inverseJoinColumns = {@JoinColumn(name = "STUDENT_ID", referencedColumnName = "STUDENT_ID")})
    private List<Student> students = new ArrayList<>();

    public Parent(List<Student> students, Project project)
    {
        super(project);
        this.students = students;
    }

    public Parent(Student student, Project project)
    {
        super(project);
        this.students.add(student);
    }

    public List<Student> getStudents()
    {
        return students;
    }

    public void setStudents(List<Student> students)
    {
        this.students = students;
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
        return "Parent{" +
                "students=" + students +
                '}';
    }
}
