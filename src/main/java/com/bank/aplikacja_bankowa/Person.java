package com.bank.aplikacja_bankowa;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class Person implements Serializable {
    protected String name;
    protected String surname;
    protected String citizenship;
    protected LocalDate dateOfBirth;
    protected String email;
    protected String phoneNumber;
    protected Boolean admin;

    public Person(String name, String surname, String citizenship, LocalDate dateOfBirth, String email, String phoneNumber, Boolean admin) {
        this.name = name;
        this.surname = surname;
        this.citizenship = citizenship;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.admin = admin;
    }
}
