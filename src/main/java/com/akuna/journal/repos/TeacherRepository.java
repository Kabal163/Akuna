package com.akuna.journal.repos;

import com.akuna.journal.entities.impls.Teacher;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;

public interface TeacherRepository extends CrudRepository<Teacher, BigInteger> {
}
