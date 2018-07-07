package com.akuna.security.entities;

import com.akuna.journal.entities.AbstractEntity;

import javax.persistence.*;

public enum Role
{
    ADMIN, TEACHER, STUDENT, PARENT;

    public String authority()
    {
        return this.name();
    }
}
