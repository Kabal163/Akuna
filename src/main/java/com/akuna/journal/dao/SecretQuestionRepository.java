package com.akuna.journal.dao;

import com.akuna.security.entities.SecretQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface SecretQuestionRepository extends JpaRepository<SecretQuestion, BigInteger>
{
}
