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

}
