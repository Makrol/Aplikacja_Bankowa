package com.bank.aplikacja_bankowa;

import java.time.LocalDate;

public class Employee extends Person{
    public Employee(String name, String surname, String citizenship, LocalDate dateOfBirth, String email, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.citizenship = citizenship;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
