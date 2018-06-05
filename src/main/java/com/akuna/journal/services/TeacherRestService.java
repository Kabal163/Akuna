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
public class TeacherRestService
{

    @Autowired
    private TeacherService teacherService;

    @RequestMapping("/project/teacher/create")
    public StatusDtoModel create(@RequestParam(value="teacher") TeacherDtoModel model)
    {

        System.out.println("got it + " + model.toString());

        Project project = new Project();
        Section section = new Section("Example", project);
        Teacher teacher = new Teacher(section, project);

        teacher.setFirstName(model.getFirstName());
        teacher.setLastName(model.getLastName());
        teacher.setMiddleName(model.getMiddleName());
        teacher.setPhoneNumber(model.getPhoneNumber());

        teacherService.createTeacher(teacher);

        return new StatusDtoModel(StatusDtoModel.Status.SUCCESSFULLY);
    }

    @RequestMapping("/example")
    public String example(@RequestParam(value="ex") String test)
    {
        System.out.println("test: " + test);
        return "OK";
    }
}

