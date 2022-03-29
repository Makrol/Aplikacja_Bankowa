package com.bank.aplikacja_bankowa;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.HashMap;

public class LogInController {
    private HashMap<String,String> loginData = new HashMap<>();
    @FXML
    private Button loginButton;

    @FXML
    private Button cancelButton;

    @FXML
    private Label wrongLogin;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    public LogInController (){
        loginData.put("system","1234");
    }

    @FXML
    void userLogin(ActionEvent event) throws IOException {

        //Main main = new Main();
        if(loginData.get(username.getText()).equals(password.getText())){

           Main.addAndActiveScreen("adminMainPanel.fxml");
        }
        else
            wrongLogin.setText("Nie poprawny login lub hasło!");
    }
    @FXML
    void cancelLogin(ActionEvent event) throws IOException{
        Platform.exit();
    }
}
