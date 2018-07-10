package com.akuna.journal.entities.visitor;

import com.akuna.journal.entities.impls.Administrator;
import com.akuna.journal.entities.impls.Parent;
import com.akuna.journal.entities.impls.Student;
import com.akuna.journal.entities.impls.Teacher;

public interface PersonVisitor
{
    void visit(Administrator administrator);

    void visit(Parent administrator);

    void visit(Teacher administrator);

    void visit(Student administrator);
}
