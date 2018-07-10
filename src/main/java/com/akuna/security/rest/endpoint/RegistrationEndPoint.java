package com.akuna.security.rest.endpoint;

import com.akuna.journal.dto.impls.AdministratorDtoModel;
import com.akuna.security.entities.SecretQuestion;
import com.akuna.security.providers.RegistrationProvider;
import com.akuna.security.service.SecretQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(value = "/api/auth/register")
@SuppressWarnings("unchecked")
public class RegistrationEndPoint
{
    private final RegistrationProvider adminRegistrationProvider;
    private final SecretQuestionService secretQuestionService;

    @Autowired
    public RegistrationEndPoint(RegistrationProvider adminRegistrationProvider, SecretQuestionService secretQuestionService)
    {
        this.adminRegistrationProvider = adminRegistrationProvider;
        this.secretQuestionService = secretQuestionService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> create(@RequestBody AdministratorDtoModel model
            , UriComponentsBuilder ucBuilder)
    {
        if (model == null)
            return new ResponseEntity<>("Registration form cannot be null", HttpStatus.BAD_REQUEST);

        adminRegistrationProvider.register(model);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/secretQuestion", method = RequestMethod.GET)
    public ResponseEntity<List<SecretQuestion>> getSecreteQuestions()
    {
        List<SecretQuestion> questions = secretQuestionService.getAll();
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }
}
