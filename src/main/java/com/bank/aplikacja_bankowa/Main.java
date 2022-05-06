package com.bank.aplikacja_bankowa;




import http.TableA;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.tables.ArrayOfExchangeRatesTable;
import org.json.JSONException;


import java.io.IOException;
import java.math.BigDecimal;


public class Main extends Application {
    private static Stage mainStage;
    public static UserFileNameTab userFileNameTab;// = new UserFileNameTab();
    public static Person currentUser;
    public static Bank bankData;
    public static CreditData creditData;

    public static ArrayOfExchangeRatesTable ratesTable;

    static {
        try {
            ratesTable = new TableA().lastTopCountTables(30);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage stage) throws IOException,ClassNotFoundException{


        //bankData = new Bank();
        //SerializeFunctions.serializeObjectToFile(bankData,"src/main/resources/data/bankData.data");
        //SerializeFunctions.serializeObjectToFile(new CreditData(),"src/main/resources/data/creditData.data");
        creditData = (CreditData)SerializeFunctions.deSerializeObjectFromFile("src/main/resources/data/creditData.data");
        bankData = (Bank)SerializeFunctions.deSerializeObjectFromFile("src/main/resources/data/bankData.data");
        userFileNameTab = (UserFileNameTab) SerializeFunctions.deSerializeObjectFromFile("src/main/resources/data/loginData.data");
        mainStage = stage;
        stage.setResizable(false);
        changeScreen("loginWindow.fxml",600,277);
        stage.setTitle("Aplikacja Bankowa!");
        stage.show();
       /* System.out.println("numer "+ Bank.generateAccountNumber());
        System.out.println("numer "+ Bank.generateAccountNumber());
        System.out.println("numer "+ Bank.generateAccountNumber());
        System.out.println("numer "+ Bank.generateAccountNumber());*/
        System.out.println(userFileNameTab.userFileName);
        System.out.println(userFileNameTab.userLoginData);
        System.out.println(userFileNameTab.accountNumberFile);

    }public static void main(String[] args) {
        launch();
    }
    public static void changeScreen(String name, float width, float height) throws  IOException{
        mainStage.setScene(new Scene(new FXMLLoader(Main.class.getResource(name)).load(),width,height));
    }
}