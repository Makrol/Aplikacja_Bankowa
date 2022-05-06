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

    public static Double convertCurrency(String srcCurrency,String dstCurrency, Double amount){
        Double tmp;
        Double tmp2;
        for(int i = 0;i<Main.ratesTable.getExchangeRatesTables().get(0).getRates().size();i++ ){
            if(Main.ratesTable.getExchangeRatesTables().get(0).getRates().get(i).getCode().equals(srcCurrency)){
                tmp = amount * Main.ratesTable.getExchangeRatesTables().get(0).getRates().get(i).getMid();

                for(int j = 0;j<Main.ratesTable.getExchangeRatesTables().get(0).getRates().size();j++ ){
                    if(Main.ratesTable.getExchangeRatesTables().get(0).getRates().get(j).getCode().equals(dstCurrency)) {
                        tmp2 =  tmp / Main.ratesTable.getExchangeRatesTables().get(0).getRates().get(j).getMid();
                        tmp2*=100;
                        return Math.round(tmp2)/100.d;
                    }
                }
            }
        }
        if(srcCurrency.equals("PLN")){
            for(int j = 0;j<Main.ratesTable.getExchangeRatesTables().get(0).getRates().size();j++ ){
                if(Main.ratesTable.getExchangeRatesTables().get(0).getRates().get(j).getCode().equals(dstCurrency)) {
                    tmp2 =  amount / Main.ratesTable.getExchangeRatesTables().get(0).getRates().get(j).getMid();
                    tmp2*=100;
                    return Math.round(tmp2)/100.d;
                } else if(dstCurrency.equals("PLN")){
                    tmp2 =  amount;
                    tmp2*=100;
                    return Math.round(tmp2)/100.d;
                }
            }
        }else if(dstCurrency.equals("PLN")){
            for(int j = 0;j<Main.ratesTable.getExchangeRatesTables().get(0).getRates().size();j++ ){
                if(Main.ratesTable.getExchangeRatesTables().get(0).getRates().get(j).getCode().equals(srcCurrency)) {
                    tmp2 =  amount * Main.ratesTable.getExchangeRatesTables().get(0).getRates().get(j).getMid();
                    tmp2*=100;
                    return Math.round(tmp2)/100.d;
                } else if(srcCurrency.equals("PLN")){
                    tmp2 = amount;
                    tmp2*=100;
                    return Math.round(tmp2)/100.d;
                }
            }
        }
        return 0.d;
    }
}
