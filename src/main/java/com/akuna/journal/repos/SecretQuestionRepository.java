package com.akuna.journal.repos;

import com.akuna.security.entities.SecretQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;

public interface SecretQuestionRepository extends JpaRepository<SecretQuestion, BigInteger>
{
    List<SecretQuestion> getAllBy();
}
