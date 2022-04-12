package com.bank.aplikacja_bankowa;

import java.io.Serializable;
import java.util.HashMap;

public class UserFileNameTab implements Serializable {
    public HashMap<String,String> userFileName;
    public HashMap<String,String> userLoginData;
    Integer userCounter;

    UserFileNameTab(){
        userFileName = new HashMap<>();
        userLoginData = new HashMap<>();
        userCounter = 0;
    }
}
