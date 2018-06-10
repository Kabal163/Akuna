package com.akuna.journal.repos;

import com.akuna.journal.entities.impls.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface AdministratorRepository extends JpaRepository<Administrator, BigInteger>
{
}
