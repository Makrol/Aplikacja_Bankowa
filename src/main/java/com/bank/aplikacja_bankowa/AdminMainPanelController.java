package com.bank.aplikacja_bankowa;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;

public class AdminMainPanelController {
    @FXML
    private Button addClientButton;

    @FXML
    private Button addEmployeeFormButton;

    @FXML
    private Button clearClientFormButton;

    @FXML
    private Button clearEmployeeFormButton;

    @FXML
    private TextField clenntCountryOfBirth;

    @FXML
    private TextField clientBuildingNumber;

    @FXML
    private TextField clientCitizenship;

    @FXML
    private TextField clientCity;

    @FXML
    private DatePicker clientDateOfBirth;

    @FXML
    private TextField clientEmail;

    @FXML
    private TextField clientFlatNumber;

    @FXML
    private DatePicker clientIdExpirationDate;

    @FXML
    private TextField clientIdNumber;

    @FXML
    private TextField clientMotherMaidenSurname;

    @FXML
    private TextField clientName;

    @FXML
    private PasswordField clientPassword;

    @FXML
    private TextField clientPesel;

    @FXML
    private TextField clientPhonNumber;

    @FXML
    private TextField clientPlaceOfBirth;

    @FXML
    private TextField clientStreet;

    @FXML
    private TextField clientSurname;

    @FXML
    private TextField clientUsername;

    @FXML
    private TextField clientZipCode;

    @FXML
    private TextField employeeCitizenship;

    @FXML
    private DatePicker employeeDateOfBirth;

    @FXML
    private TextField employeeEmail;

    @FXML
    private TextField employeeName;

    @FXML
    private PasswordField employeePassword;

    @FXML
    private TextField employeePhonNumber;

    @FXML
    private TextField employeeSurname;

    @FXML
    private TextField employeeUsername;

    @FXML
    private Text personName;

    @FXML
    private Text personSurname;

    @FXML
    void addClient(ActionEvent event) {

    }

    @FXML
    void addEmployee(ActionEvent event) throws IOException {
        Employee employee = new Employee(
                employeeName.getText(),
                employeeSurname.getText(),
                employeeCitizenship.getText(),
                employeeDateOfBirth.getValue(),
                employeeEmail.getText(),
                employeePhonNumber.getText()
        );
        SerializeFunctions.serializeObjectToFile(employee,"src/main/resources/data/u1.data");
    }

    @FXML
    void clearClientForm(ActionEvent event) {

    }

    @FXML
    void clearEmployeeForm(ActionEvent event) {

    }
}
