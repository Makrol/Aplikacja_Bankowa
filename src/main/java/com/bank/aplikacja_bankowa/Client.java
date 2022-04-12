package com.bank.aplikacja_bankowa;

import java.time.LocalDate;

public class Client extends Person{
    private String pesel;
    private String countryOfBirth;
    private String motherMaidenSurname;
    private String placeOfBirth;
    private LocalDate idExpirationDate;
    private String idNumber;
    private String city;
    private String street;
    private String buildingNumber;
    private String flatNumber;
    private String zipCode;

    public Client(String name, String surname, String citizenship, LocalDate dateOfBirth, String email, String phoneNumber, Boolean admin, String pesel, String countryOfBirth, String motherMaidenSurname, String placeOfBirth, LocalDate idExpirationDate, String idNumber, String city, String street, String buildingNumber, String flatNumber, String zipCode) {
        super(name, surname, citizenship, dateOfBirth, email, phoneNumber, admin);
        this.pesel = pesel;
        this.countryOfBirth = countryOfBirth;
        this.motherMaidenSurname = motherMaidenSurname;
        this.placeOfBirth = placeOfBirth;
        this.idExpirationDate = idExpirationDate;
        this.idNumber = idNumber;
        this.city = city;
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.flatNumber = flatNumber;
        this.zipCode = zipCode;
    }
}
