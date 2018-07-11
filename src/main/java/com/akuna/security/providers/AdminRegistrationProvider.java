package com.akuna.security.providers;

import com.akuna.journal.dto.impls.AdministratorDtoModel;
import com.akuna.journal.entities.impls.Administrator;
import com.akuna.journal.entities.impls.Project;
import com.akuna.journal.services.AdministratorService;
import com.akuna.journal.services.ProjectService;
import com.akuna.security.entities.Role;
import com.akuna.security.entities.User;
import com.akuna.security.service.SecretQuestionService;
import com.akuna.security.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Component
public class AdminRegistrationProvider implements RegistrationProvider<AdministratorDtoModel>
{
    private final AdministratorService administratorService;
    private final SecretQuestionService secretQuestionService;
    private final ProjectService projectService;
    private final UserService userService;
    private final Project project;

    @Autowired
    public AdminRegistrationProvider(AdministratorService administratorService,
                                     SecretQuestionService secretQuestionService,
                                     UserService userService,
                                     ProjectService projectService)
    {
        this.administratorService = administratorService;
        this.secretQuestionService = secretQuestionService;
        this.projectService = projectService;
        this.userService = userService;
        this.project = projectService.getNewProject();
    }

    @Override
    @Transactional
    public void register(AdministratorDtoModel model)
    {
        Administrator administrator = createAdministrator(model);
        administrator.setUser(createUser(model));

        projectService.save(project);
        userService.save(administrator.getUser());
        administratorService.save(administrator);
    }

    private Administrator createAdministrator(AdministratorDtoModel model)
    {
        Administrator administrator = new Administrator(project);
        administrator.setFirstName(model.getFirstName());
        administrator.setLastName(model.getLastName());
        administrator.setMiddleName(model.getMiddleName());
        administrator.setPhoneNumber(model.getPhoneNumber());
        administrator.setSecretAnswer(model.getSecretAnswer());
        administrator.setSecretQuestion(secretQuestionService
                .getById(model.getSecretQuestionId())
                .orElseThrow(EntityNotFoundException::new));
        administrator.setEmail(model.getEmail());

        return administrator;
    }

    private User createUser(AdministratorDtoModel model)
    {
        User user = new User(project);
        user.setUsername(model.getEmail());
        user.setPassword(model.getPassword().toString());
        user.setConfirmPassword(model.getConfirmPassword());
        user.setActive(true);
        user.addRole(Role.ADMIN);

        return user;
    }
}
