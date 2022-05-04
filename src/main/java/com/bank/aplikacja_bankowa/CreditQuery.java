package com.bank.aplikacja_bankowa;

import java.io.Serializable;
import java.time.LocalDate;

public class CreditQuery implements Serializable {
     private Double amount;
     private Integer installmentsQuantity;
     private Double bruttoIncome;
     private Double averageExpenses;
     private Integer peopleSupported;
     private String contractType;
     private String companyName;
     private String companyAddress;
     private String companyNIP;
     private String accountNumber;
     private Double creditWorthiness;

     private String date;

    public CreditQuery(Double amount, Integer installmentsQuantity, Double bruttoIncome,Integer peopleSupported, Double averageExpenses , String contractType, String companyName, String companyNIP,String companyAddress, String accountNumber, Double creditWorthiness) {
        this.amount = amount;
        this.installmentsQuantity = installmentsQuantity;
        this.bruttoIncome = bruttoIncome;
        this.averageExpenses = averageExpenses;
        this.peopleSupported = peopleSupported;
        this.contractType = contractType;
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.companyNIP = companyNIP;
        this.accountNumber = accountNumber;
        this.creditWorthiness = creditWorthiness;
        date = LocalDate.now().toString();

    }

    public Double getAmount() {
        return amount;
    }

    public Integer getInstallmentsQuantity() {
        return installmentsQuantity;
    }

    public Double getBruttoIncome() {
        return bruttoIncome;
    }

    public Double getAverageExpenses() {
        return averageExpenses;
    }

    public Integer getPeopleSupported() {
        return peopleSupported;
    }

    public String getContractType() {
        return contractType;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public String getCompanyNIP() {return companyNIP;}

    public String getAccountNumber() {return accountNumber;}

    public Double getCreditWorthiness() {return creditWorthiness;}

    public String getDate() {
        return date;
    }
}
