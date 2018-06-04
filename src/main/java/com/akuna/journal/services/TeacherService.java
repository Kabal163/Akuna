package com.akuna.journal.services;

import com.akuna.journal.dto.StatusDtoModel;
import com.akuna.journal.dto.TeacherDtoModel;
import com.akuna.journal.entities.impls.Project;
import com.akuna.journal.entities.impls.Section;
import com.akuna.journal.entities.impls.Teacher;
import com.akuna.journal.repos.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeacherService
{
    @Autowired
    TeacherRepository repository;

    @RequestMapping("/project/teacher/create")
    public StatusDtoModel create(@RequestParam(value="teacher")TeacherDtoModel model)
    {
        Project project = new Project();
        Section section = new Section("Example", project);
        Teacher teacher = new Teacher(section, project);
        repository.save(teacher);

        return new StatusDtoModel(StatusDtoModel.Status.SUCCESSFULLY);
    }
}

