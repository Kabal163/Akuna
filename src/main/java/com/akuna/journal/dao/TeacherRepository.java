package com.akuna.journal.dao;

import com.akuna.journal.entities.impls.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, BigInteger> {

    List<Teacher> findByLastName(String lastName);

}
