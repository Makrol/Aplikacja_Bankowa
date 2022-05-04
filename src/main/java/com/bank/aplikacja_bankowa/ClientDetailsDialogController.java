package com.bank.aplikacja_bankowa;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ClientDetailsDialogController {

    static private Dialog ClientDetailsDialog;

    private static Client currentClient;
    @FXML
    private Label balance;

    @FXML
    private Label buildingNumber;

    @FXML
    private Label citizenship;

    @FXML
    private Label city;

    @FXML
    private Button closeButton;

    @FXML
    private Label countryOfBirth;

    @FXML
    private Label dateOfBirth;

    @FXML
    private Label emailAddress;

    @FXML
    private Label expiryDate;

    @FXML
    private Label flatNumber;

    @FXML
    private Button historyOfTransfersButton;

    @FXML
    private Label idNumber;

    @FXML
    private Label motherMaidenName;

    @FXML
    private Label name;

    @FXML
    private Label pesel;

    @FXML
    private Label phoneNumber;

    @FXML
    private Label placeOfBirth;

    @FXML
    private Label street;

    @FXML
    private Label surname;

    @FXML
    private Label zipCode;

    @FXML
    void initialize(){
        surname.setText(currentClient.getSurname());
        name.setText(currentClient.getName());
        zipCode.setText(currentClient.getZipCode());
        street.setText(currentClient.getStreet());
        placeOfBirth.setText(currentClient.getPlaceOfBirth());
        phoneNumber.setText(currentClient.getPhoneNumber());
        pesel.setText(currentClient.getPesel());
        motherMaidenName.setText(currentClient.getMotherMaidenSurname());
        idNumber.setText(currentClient.getIdNumber());
        flatNumber.setText(currentClient.getFlatNumber());
        emailAddress.setText(currentClient.getEmailAddress());
        dateOfBirth.setText(currentClient.getDateOfBirth());
        countryOfBirth.setText(currentClient.getCountryOfBirth());
        city.setText(currentClient.getCity());
        citizenship.setText(currentClient.getCitizenship());
        buildingNumber.setText(currentClient.getBuildingNumber());
        balance.setText(currentClient.getMoney().toString());
        expiryDate.setText(currentClient.getIdExpirationDate().toString());

    }
    @FXML
    void closeDialog(ActionEvent event) {
        ClientDetailsDialog.setResult(true);
        ClientDetailsDialog.close();
    }
    static public void setDialog(Dialog dialog) {
        ClientDetailsDialog = dialog;

    }
    @FXML
    void showHistoryOfTransfers(ActionEvent event) {

    }
    public static void setCurrentClient(Client client){
        currentClient = client;
    }

}

