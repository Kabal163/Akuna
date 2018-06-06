package com.akuna.security.entities;

import com.akuna.journal.entities.AbstractEntity;

import javax.persistence.*;

@Entity
@Table(name = "secret_question", schema = "akuna_std")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "question_id"))
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
