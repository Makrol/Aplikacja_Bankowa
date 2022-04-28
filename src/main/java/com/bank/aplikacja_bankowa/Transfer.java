package com.bank.aplikacja_bankowa;

import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;
import java.time.LocalDate;

public class Transfer implements Serializable {
    public static enum Type {OUTGOING,INCOMING,CREDIT,PAYOFF};

    private String date;
    private String type;
    private String title;
    private String amount;

    private String sourceAccountNumber;
    private String sourceAddress;
    private String sourceName;


    private String destinationAccountNumber;
    private String destinationAddress;
    private String destinationName;


    private String id;

    public Transfer(LocalDate date, Type type, String title, Double amount, String sourceAccountNumber, String sourceAddress,
                    String sourceName, String destinationAccountNumber, String destinationAddress,
                    String destinationName) {
        this.date = date.toString();
        if(type == Type.OUTGOING)
            this.type = "Przelew wychodzący";
        else if(type == Type.INCOMING)
            this.type = "Przelew przychodzący";
        this.title = title;
        this.amount = amount.toString();
        this.sourceAccountNumber = sourceAccountNumber;
        this.sourceAddress = sourceAddress;
        this.sourceName = sourceName;

        this.destinationAccountNumber = destinationAccountNumber;
        this.destinationAddress = destinationAddress;
        this.destinationName = destinationName;
    }

    public String getDate() {
        return date;
    }

    public String getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public String getAmount() {
        return amount;
    }

    public String getSourceAccountNumber() {
        return sourceAccountNumber;
    }

    public String getSourceAddress() {
        return sourceAddress;
    }

    public String getSourceName() {
        return sourceName;
    }

    public String getDestinationAccountNumber() {
        return destinationAccountNumber;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public String getDestinationName() {
        return destinationName;
    }
}
