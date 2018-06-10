package com.akuna.journal.repos;

import com.akuna.journal.entities.impls.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface ProjectRepository extends JpaRepository<Project, BigInteger>
{

}
