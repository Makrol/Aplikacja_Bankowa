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

    public CreditQuery(Double amount, Integer installmentsQuantity, Double bruttoIncome, Double averageExpenses, Integer peopleSupported, TypeContract contractType, String companyName, String companyAddress, String companyNIP) {
        this.amount = amount;
        this.installmentsQuantity = installmentsQuantity;
        this.bruttoIncome = bruttoIncome;
        this.averageExpenses = averageExpenses;
        this.peopleSupported = peopleSupported;
        this.contractType = contractType;
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.companyNIP = companyNIP;
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

    public String getCompanyNIP() {
        return companyNIP;
    }
}
