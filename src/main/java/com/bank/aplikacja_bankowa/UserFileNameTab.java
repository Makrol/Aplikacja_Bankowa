package com.bank.aplikacja_bankowa;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.io.Serializable;
import java.util.HashMap;

public class UserFileNameTab implements Serializable {
    public HashMap<String,String> userFileName;
    public HashMap<String,String> userLoginData;
    public HashMap<String,String> accountNumberFile;
    Integer userCounter;

    UserFileNameTab(){
        userFileName = new HashMap<>();
        userLoginData = new HashMap<>();
        accountNumberFile = new HashMap<>();
        userCounter = 0;
    }
    public String findUserFileByLogin(String login){
        return userFileName.get(login);
    }
    public String findUserFileByAccountNumber(String accountNumber){
        if(accountNumberFile.containsKey(accountNumber)){
            return accountNumberFile.get(accountNumber);
        }
        return "";
    }
    public void addNewAccountNumber(String accountNumber,String fileName){
        accountNumberFile.put(accountNumber,fileName);
    }
}
