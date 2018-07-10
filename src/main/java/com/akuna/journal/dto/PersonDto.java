package com.akuna.journal.dto;

import java.util.Objects;

public abstract class PersonDto
{
    private String firstName;
    private String lastName;
    private String middleName;
    private String email;
    private String phoneNumber;
    private String city;
    private String street;
    private CharSequence password;
    private CharSequence confirmPassword;

    public PersonDto(String firstName,
                     String lastName,
                     String middleName,
                     String email,
                     String phoneNumber,
                     String city,
                     String street,
                     CharSequence password,
                     CharSequence confirmPassword)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.street = street;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public PersonDto() {}

    public CharSequence getPassword()
    {
        return password;
    }

    public void setPassword(CharSequence password)
    {
        this.password = password;
    }

    public CharSequence getConfirmPassword()
    {
        return confirmPassword;
    }

    public void setConfirmPassword(CharSequence confirmPassword)
    {
        this.confirmPassword = confirmPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonDto personDto = (PersonDto) o;
        return Objects.equals(getFirstName(), personDto.getFirstName()) &&
                Objects.equals(getLastName(), personDto.getLastName()) &&
                Objects.equals(getMiddleName(), personDto.getMiddleName()) &&
                Objects.equals(getEmail(), personDto.getEmail()) &&
                Objects.equals(getPhoneNumber(), personDto.getPhoneNumber()) &&
                Objects.equals(getCity(), personDto.getCity()) &&
                Objects.equals(getStreet(), personDto.getStreet());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getFirstName(), getLastName(), getMiddleName(), getEmail(), getPhoneNumber(), getCity(), getStreet());
    }

    @Override
    public String toString() {
        return "PersonDto{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}
