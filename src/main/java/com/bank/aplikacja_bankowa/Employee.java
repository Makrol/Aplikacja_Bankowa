package com.bank.aplikacja_bankowa;

import java.time.LocalDate;

public class Employee extends Person{
    public Employee(String name, String surname, String citizenship, LocalDate dateOfBirth, String email, String phoneNumber, Boolean admin) {
        super(name, surname, citizenship, dateOfBirth, email, phoneNumber, admin);
    }
}
