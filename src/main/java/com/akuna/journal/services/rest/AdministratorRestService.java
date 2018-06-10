package com.akuna.journal.services.rest;

import com.akuna.journal.dto.impls.AdministratorDtoModel;
import com.akuna.journal.entities.impls.Administrator;
import com.akuna.journal.services.AdministratorService;
import com.akuna.journal.services.SecretQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/administrator")
public class AdministratorRestService
{
    @Autowired
    private AdministratorService administratorService;

    @Autowired
    private SecretQuestionService secretQuestionService;

    @RequestMapping(value = "/create")
    public ResponseEntity<Boolean> create(@RequestBody AdministratorDtoModel model
            , UriComponentsBuilder ucBuilder)
    {
        Administrator administrator = new Administrator();
        administrator.setFirstName(model.getFirstName());
        administrator.setLastName(model.getLastName());
        administrator.setMiddleName(model.getMiddleName());
        administrator.setPhoneNumber(model.getPhoneNumber());
        administrator.setSecretAnswer(model.getSecreteAnswer());
        administrator.setSecretQuestion(secretQuestionService.getSecreteQuestionById(model.getSecreteQuestionId()));
        administrator.setEmail(model.getEmail());

        return administratorService.save(administrator)
                ? new ResponseEntity<Boolean>(true, HttpStatus.OK)
                : new ResponseEntity<Boolean>(false, HttpStatus.CONFLICT) ;
    }
}
