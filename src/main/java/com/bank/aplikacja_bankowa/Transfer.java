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

    public Transfer(LocalDate date, Type type, String title, Double amount) {
        this.date = date.toString();
        if(type == Type.OUTGOING)
            this.type = "Przelew wychodzący";
        else if(type == Type.INCOMING)
            this.type = "Przelew przychodzący";
        this.title = title;
        this.amount = amount.toString();
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
}
