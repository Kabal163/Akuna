package com.akuna.journal.services.rest;

import com.akuna.journal.dto.impls.AdministratorDtoModel;
import com.akuna.journal.entities.impls.Administrator;
import com.akuna.journal.entities.impls.Project;
import com.akuna.journal.services.AdministratorService;
import com.akuna.journal.services.ProjectService;
import com.akuna.security.entities.Role;
import com.akuna.security.entities.User;
import com.akuna.security.service.SecretQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping(value = "/api/auth/register/admin")
public class AdminRestServiceImpl implements AdminRestService
{
    private final AdministratorService administratorService;
    private final SecretQuestionService secretQuestionService;
    private final ProjectService projectService;

    @Autowired
    public AdminRestServiceImpl(AdministratorService administratorService,
                                SecretQuestionService secretQuestionService,
                                ProjectService projectService)
    {
        this.administratorService = administratorService;
        this.secretQuestionService = secretQuestionService;
        this.projectService = projectService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Boolean> create(@RequestBody AdministratorDtoModel model
            , UriComponentsBuilder ucBuilder)
    {
        Administrator administrator = new Administrator();
        administrator.setFirstName(model.getFirstName());
        administrator.setLastName(model.getLastName());
        administrator.setMiddleName(model.getMiddleName());
        administrator.setPhoneNumber(model.getPhoneNumber());
        administrator.setSecretAnswer(model.getSecretAnswer());
        administrator.setSecretQuestion(secretQuestionService
                .getById(model.getSecretQuestionId())
                .orElseThrow(EntityNotFoundException::new));
        administrator.setEmail(model.getEmail());

        User user = new User();
        user.setUsername(model.getEmail());
        user.setPassword(model.getPassword());
        user.setConfirmPassword(model.getConfirmPassword());
        user.setActive(true);
        user.addRole(Role.ADMIN);

        administrator.setUser(user);

        Project project = projectService.getNewProject();
        administrator.setProject(project);

        return administratorService.save(administrator)
                ? new ResponseEntity<Boolean>(true, HttpStatus.OK)
                : new ResponseEntity<Boolean>(false, HttpStatus.CONFLICT) ;
    }
}
