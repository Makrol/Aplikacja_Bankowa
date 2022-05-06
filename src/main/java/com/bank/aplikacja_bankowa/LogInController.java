package com.bank.aplikacja_bankowa;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


import java.io.IOException;


public class LogInController {




    @FXML
    private Label wrongLogin;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    void userLogin(ActionEvent event) throws IOException,ClassNotFoundException {
        //Main.changeScreen("adminMainPanel.fxml",904.0f,634.0f);

        if((!username.getText().isEmpty())&&(!password.getText().isEmpty())&&
            Main.userFileNameTab.userLoginData.containsKey(username.getText())&&
            Main.userFileNameTab.userLoginData.get(username.getText()).equals(password.getText())){

            Main.currentUser = (Person) SerializeFunctions.deSerializeObjectFromFile("src/main/resources/data/"+Main.userFileNameTab.userFileName.get(username.getText())+".data");
            if(Main.currentUser.admin){
                Main.changeScreen("adminMainPanel.fxml",904.0f,634.0f);

            }
            else{
                Main.changeScreen("userMainPanel.fxml",904.0f,634.0f);
            }
        }
        else{
            wrongLogin.setText("Niepoprawny login lub hasło !!");
        }

    }
    @FXML
    void cancelLogin(ActionEvent event){
        Platform.exit();
    }
}
