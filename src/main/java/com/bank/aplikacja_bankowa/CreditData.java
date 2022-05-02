package com.bank.aplikacja_bankowa;

import java.io.Serializable;
import java.util.ArrayList;

public class CreditData implements Serializable {
    private ArrayList<CreditQuery> creditDataContainer;

    public CreditData(){
        creditDataContainer = new ArrayList<>();
    }

    public void addCreditQuery(CreditQuery creditQuery){
        creditDataContainer.add(creditQuery);
    }

    public ArrayList<CreditQuery> getCreditDataContainer() {
        return creditDataContainer;
    }
}
