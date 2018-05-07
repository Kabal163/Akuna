package com.akuna.journal.entities;

import com.akuna.security.entites.SecretQuestion;

import javax.persistence.*;

@Entity
@Table(name = "ADMINISTRATORS")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "ADMIN_ID"))
})
public class Administrator extends Person
{
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "QUESTION_ID", referencedColumnName = "QUESTION_ID")
    private SecretQuestion secretQuestion;

    @Column(name = "SECRET_ANSWER")
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
