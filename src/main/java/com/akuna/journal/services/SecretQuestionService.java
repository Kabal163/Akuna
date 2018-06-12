package com.akuna.journal.services;

import com.akuna.journal.dao.SecretQuestionRepository;
import com.akuna.security.entities.SecretQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.exact;

@Service
public class SecretQuestionService
{
    @Autowired
    private SecretQuestionRepository repository;

    public SecretQuestion getSecreteQuestionById(BigInteger id)
    {
        return repository.getOne(id);
    }

    public List<SecretQuestion> getAll()
    {
        return repository.getAllBy();
    }

    public boolean save(SecretQuestion secretQuestion)
    {
        if (exists(secretQuestion)) return true;

        repository.save(secretQuestion);
        return true;
    }

    public boolean exists(SecretQuestion secretQuestion)
    {
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("question", exact());

        Example<SecretQuestion> example = Example.of(secretQuestion, matcher);

        return repository.exists(example);
    }
}
