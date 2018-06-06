package com.akuna.journal.entities.impls;

import com.akuna.journal.entities.Person;
import com.akuna.security.entities.SecretQuestion;

import javax.persistence.*;

@Entity
@Table(name = "administrators")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "admin_id"))
})
public class Administrator extends Person
{
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", referencedColumnName = "question_id")
    private SecretQuestion secretQuestion;

    @Column(name = "secret_answer")
    private String secretAnswer;

    public Administrator(SecretQuestion secretQuestion, String secretAnswer, Project project)
    {
        super(project);
        this.secretQuestion = secretQuestion;
        this.secretAnswer = secretAnswer;
    }

    public SecretQuestion getSecretQuestion()
    {
        return secretQuestion;
    }

    public String getSecretAnswer()
    {
        return secretAnswer;
    }

    @Override
    public String toString()
    {
        return "Administrator{" +
                "secretQuestion=" + secretQuestion +
                ", secretAnswer='" + secretAnswer + '\'' +
                '}';
    }
}
