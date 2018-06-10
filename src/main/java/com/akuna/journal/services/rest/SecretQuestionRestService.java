package com.akuna.journal.services.rest;

import com.akuna.journal.services.SecretQuestionService;
import com.akuna.security.entities.SecretQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/secreteQuestion")
public class SecretQuestionRestService
{
    @Autowired
    private SecretQuestionService secretQuestionService;

    @RequestMapping("/getAll")
    public ResponseEntity<List<SecretQuestion>> getAll()
    {
        List<SecretQuestion> questions = secretQuestionService.getAll();
        return new ResponseEntity<List<SecretQuestion>>(questions, HttpStatus.OK);
    }
}
