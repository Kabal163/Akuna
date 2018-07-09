package com.akuna.security.rest.endpoint;

import com.akuna.security.entities.SecretQuestion;
import com.akuna.security.service.SecretQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/auth/register/secretQuestion")
public class SecretQuestionEndpoint
{
    private final SecretQuestionService secretQuestionService;

    @Autowired
    public SecretQuestionEndpoint(SecretQuestionService secretQuestionService)
    {
        this.secretQuestionService = secretQuestionService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<SecretQuestion>> getSecreteQuestions()
    {
        List<SecretQuestion> questions = secretQuestionService.getAll();
        return new ResponseEntity<List<SecretQuestion>>(questions, HttpStatus.OK);
    }
}
