package com.bank.aplikacja_bankowa;

public class CreditQuery {
    public static enum TypeContract {NULL,TRIAL,LIMITED_PERIOD,INDEFINITE_PERIOD};
     private Double amount;
     private Integer installmentsQuantity;
     private Double bruttoIncome;
     private Double averageExpenses;
     private Integer peopleSupported;
     private TypeContract contractType;
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

    public TypeContract getContractType() {
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
