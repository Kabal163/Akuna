package com.akuna.security.service;

import com.akuna.journal.dao.SecretQuestionRepository;
import com.akuna.security.entities.SecretQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.exact;

@Component
public class SecretQuestionServiceImpl implements SecretQuestionService
{
    private final SecretQuestionRepository repository;

    @Autowired
    public SecretQuestionServiceImpl(SecretQuestionRepository repository)
    {
        this.repository = repository;
    }

    @Override
    public List<SecretQuestion> getAll()
    {
        return repository.findAll();
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

    @Override
    public Optional<SecretQuestion> getById(BigInteger id)
    {
        return repository.findById(id);
    }
}
