package com.bank.aplikacja_bankowa;

import java.io.Serializable;

public class Bank implements Serializable {
    private final static Long bankIdNumber = 43564879L;
    private Long currentMaxAccountNumber;

    public Bank(){
        currentMaxAccountNumber=1l;
    }
    public String generateAccountNumber(){
        String tmp="";
        Long tmpLong=(bankIdNumber*currentMaxAccountNumber)%100;
        tmp+=tmpLong+bankIdNumber;
        int currentAccountNumberLength = currentMaxAccountNumber.toString().length();
        while (currentAccountNumberLength<16){
            tmp+="0";
            currentAccountNumberLength++;
        }
        tmp+=currentMaxAccountNumber.toString();
        currentMaxAccountNumber++;
        return tmp;
    }
}
