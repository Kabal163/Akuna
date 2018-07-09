package com.akuna.journal.dto.impls;

import com.akuna.journal.dto.PersonDto;

import java.math.BigInteger;
import java.util.Objects;

public class AdministratorDtoModel extends PersonDto
{
    private BigInteger secretQuestionId;
    private String secretAnswer;

    public AdministratorDtoModel(String firstName,
                                 String lastName,
                                 String middleName,
                                 String email,
                                 String phoneNumber,
                                 String city,
                                 String street,
                                 String password,
                                 String confirmPassword,
                                 BigInteger secretQuestionId,
                                 String secretAnswer)
    {
        super(firstName, lastName, middleName, email, phoneNumber, city, street, password, confirmPassword);
        this.secretQuestionId = secretQuestionId;
        this.secretAnswer = secretAnswer;
    }

    public AdministratorDtoModel() {}

    public BigInteger getSecretQuestionId() {
        return secretQuestionId;
    }

    public void setSecretQuestionId(BigInteger secretQuestionId) {
        this.secretQuestionId = secretQuestionId;
    }

    public String getSecretAnswer() {
        return secretAnswer;
    }

    public void setSecretAnswer(String secretAnswer) {
        this.secretAnswer = secretAnswer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AdministratorDtoModel that = (AdministratorDtoModel) o;
        return Objects.equals(getSecretQuestionId(), that.getSecretQuestionId()) &&
                Objects.equals(getSecretAnswer(), that.getSecretAnswer());
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), getSecretQuestionId(), getSecretAnswer());
    }

    @Override
    public String toString() {
        return "AdministratorDtoModel{" +
                "secretQuestionId=" + secretQuestionId +
                ", secretAnswer='" + secretAnswer + '\'' +
                '}';
    }
}
