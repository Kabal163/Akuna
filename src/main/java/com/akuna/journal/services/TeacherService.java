package com.akuna.journal.services;

import com.akuna.journal.entities.impls.Teacher;
import com.akuna.journal.repos.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    @Autowired
    TeacherRepository repository;

    protected void createTeacher(Teacher teacher)
    {
        repository.save(teacher);
    }
}
