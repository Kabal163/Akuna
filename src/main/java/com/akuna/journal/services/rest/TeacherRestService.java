package com.akuna.journal.services.rest;

import com.akuna.journal.dto.impls.TeacherDtoModel;
import com.akuna.journal.entities.impls.Project;
import com.akuna.journal.entities.impls.Teacher;
import com.akuna.journal.services.ProjectService;
import com.akuna.journal.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigInteger;

@RestController
@RequestMapping("/{project}/teacher")
public class TeacherRestService
{

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private ProjectService projectService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<Boolean> create(@PathVariable("projectId") BigInteger projectId
            , @RequestBody TeacherDtoModel model
            , UriComponentsBuilder ucBuilder)
    {
        Project project = projectService.getById(projectId);
        Teacher teacher = new Teacher(project);

        teacher.setFirstName(model.getFirstName());
        teacher.setLastName(model.getLastName());
        teacher.setMiddleName(model.getMiddleName());
        teacher.setPhoneNumber(model.getPhoneNumber());
        teacher.setEmail(model.getEmail());

        return teacherService.save(teacher)
                ? new ResponseEntity<Boolean>(true, HttpStatus.OK)
                : new ResponseEntity<Boolean>(false, HttpStatus.CONFLICT) ;
    }
}

