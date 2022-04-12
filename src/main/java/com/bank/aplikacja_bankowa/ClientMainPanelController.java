package com.bank.aplikacja_bankowa;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;

import java.io.IOException;

public class ClientMainPanelController {

    @FXML
    private Label currency;

    @FXML
    private Button logoutButton;

    @FXML
    private Label money;

    @FXML
    private Text name;

    @FXML
    private TableView<?> operationHistoryTable;

    @FXML
    private Text surname;

    @FXML
    void logout(ActionEvent event)throws IOException {
        Main.changeScreen("loginWindow.fxml",600,400);
        Main.currentUser = null;
    }

    @FXML
    public void initialize(){

        name.setText(Main.currentUser.name);
        surname.setText(Main.currentUser.surname);

    }

}

