package com.bank.aplikacja_bankowa;

import java.time.LocalDate;
import java.util.ArrayList;

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
    private String accountNumber;
    private Double money;

    private ArrayList<Transfer> transfers;

    public Client(String name, String surname, String citizenship, LocalDate dateOfBirth, String email, String phoneNumber, Boolean admin, String pesel, String countryOfBirth, String motherMaidenSurname, String placeOfBirth, LocalDate idExpirationDate, String idNumber, String city, String street, String buildingNumber, String flatNumber, String zipCode, String accountNumber) {
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
        this.accountNumber = accountNumber;
        money=200d;
        transfers = new ArrayList<>();
    }
    public String getAccountNumber(){
        return accountNumber;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
    public void changeMoney(Double money){this.money+=money;}
    public ArrayList<Transfer> getTransfers() {
        return transfers;
    }
}
