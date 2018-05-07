package com.akuna.security.entites;

import com.akuna.journal.entities.abstracts.AbstractEntity;

import javax.persistence.*;

@Entity
@Table(name = "SECRET_QUESTION")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "QUESTION_ID"))
})
public class SecretQuestion extends AbstractEntity
{
    private String question;

    public SecretQuestion(String question)
    {
        this.question = question;
    }

    public String getQuestion()
    {
        return question;
    }

    @Override
    public String toString()
    {
        return "SecretQuestion{" +
                ", question='" + question + '\'' +
                '}';
    }
}
