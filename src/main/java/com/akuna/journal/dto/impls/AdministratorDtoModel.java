package com.akuna.journal.dto.impls;

import com.akuna.journal.dto.PersonDto;

import java.math.BigInteger;
import java.util.Objects;

public class AdministratorDtoModel extends PersonDto
{
    private BigInteger secreteQuestionId;
    private String secreteAnswer;

    public AdministratorDtoModel(String firstName, String lastName, String middleName, String email, String phoneNumber, String city, String street, BigInteger secreteQuestionId, String secreteAnswer) {
        super(firstName, lastName, middleName, email, phoneNumber, city, street);
        this.secreteQuestionId = secreteQuestionId;
        this.secreteAnswer = secreteAnswer;
    }

    public BigInteger getSecreteQuestionId() {
        return secreteQuestionId;
    }

    public void setSecreteQuestionId(BigInteger secreteQuestionId) {
        this.secreteQuestionId = secreteQuestionId;
    }

    public String getSecreteAnswer() {
        return secreteAnswer;
    }

    public void setSecreteAnswer(String secreteAnswer) {
        this.secreteAnswer = secreteAnswer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AdministratorDtoModel that = (AdministratorDtoModel) o;
        return Objects.equals(getSecreteQuestionId(), that.getSecreteQuestionId()) &&
                Objects.equals(getSecreteAnswer(), that.getSecreteAnswer());
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), getSecreteQuestionId(), getSecreteAnswer());
    }

    @Override
    public String toString() {
        return "AdministratorDtoModel{" +
                "secreteQuestionId=" + secreteQuestionId +
                ", secreteAnswer='" + secreteAnswer + '\'' +
                '}';
    }
}
