package com.akuna.security.service;

import com.akuna.security.entities.SecretQuestion;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface SecretQuestionService
{
    List<SecretQuestion> getAll();

    boolean save(SecretQuestion secretQuestion);

    boolean exists(SecretQuestion secretQuestion);

    Optional<SecretQuestion> getById(BigInteger id);
}
