package com.akuna.journal.entities.impls;

import com.akuna.journal.entities.Person;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "parents")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "parent_id"))
})
public class Parent extends Person
{
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "students_to_parents",
    joinColumns = {@JoinColumn(name = "parent_id", referencedColumnName = "parent_id")},
    inverseJoinColumns = {@JoinColumn(name = "student_id", referencedColumnName = "student_id")})
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
