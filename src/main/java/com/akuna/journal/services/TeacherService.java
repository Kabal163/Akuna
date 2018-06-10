package com.akuna.journal.services;

import com.akuna.journal.entities.impls.Teacher;
import com.akuna.journal.repos.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.exact;


@Service
public class TeacherService {

    @Autowired
    private TeacherRepository repository;

    public boolean save(Teacher teacher)
    {
        if (exists(teacher)) return false;

        repository.save(teacher);
        return true;
    }

    public boolean exists(Teacher teacher)
    {
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("phoneNumber", exact())
                .withMatcher("email", exact());
        
        Example<Teacher> example = Example.of(teacher, matcher);
        return repository.exists(example);
    }
}
