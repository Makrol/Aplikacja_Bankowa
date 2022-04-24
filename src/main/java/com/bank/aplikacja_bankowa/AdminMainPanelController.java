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
    private TextField clientCountryOfBirth;

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
    private TextField clientPhoneNumber;

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
    private TextField employeePhoneNumber;

    @FXML
    private TextField employeeSurname;

    @FXML
    private TextField employeeUsername;

    @FXML
    private Text personName;

    @FXML
    private Text personSurname;

    @FXML
    private Button logoutButton;

    @FXML
    public void initialize(){
        validate();
       // personName.setText(Main.currentUser.name);
       // personSurname.setText(Main.currentUser.surname);

    }

    @FXML
    void addClient(ActionEvent event) throws IOException{
        String accountNumber = Main.bankData.generateAccountNumber();
        SerializeFunctions.serializeObjectToFile(Main.bankData,"src/main/resources/data/bankData.data");
        System.out.println("wybrany" + accountNumber);
        Client client = new Client(
                  clientName.getText(),
                clientSurname.getText(),
                clientCitizenship.getText(),
                clientDateOfBirth.getValue(),
                clientEmail.getText(),
                clientPhoneNumber.getText(),
                false,
                clientPesel.getText(),
                clientCountryOfBirth.getText(),
                clientMotherMaidenSurname.getText(),
                clientPlaceOfBirth.getText(),
                clientIdExpirationDate.getValue(),
                clientIdNumber.getText(),
                clientCity.getText(),
                clientStreet.getText(),
                clientBuildingNumber.getText(),
                clientFlatNumber.getText(),
                clientZipCode.getText(),
                accountNumber
        );
        SerializeFunctions.serializePerson(client,clientUsername.getText(),clientPassword.getText(),accountNumber);
        //String clientFileName = Main.userFileNameTab.findUserFileByLogin(clientUsername.getText());
       // Main.userFileNameTab.addNewAccountNumber(accountNumber,clientFileName);
    }
    @FXML
    void addEmployee(ActionEvent event) throws IOException {

        Employee employee = new Employee(
                employeeName.getText(),
                employeeSurname.getText(),
                employeeCitizenship.getText(),
                employeeDateOfBirth.getValue(),
                employeeEmail.getText(),
                employeePhoneNumber.getText(),
                true
        );

       SerializeFunctions.serializePerson(employee,employeeUsername.getText(),employeePassword.getText());
    }

    @FXML
    void clearClientForm(ActionEvent event) {
        clearClientFields();
    }

    @FXML
    void clearEmployeeForm(ActionEvent event) {
        clearEmployerFields();
    }
    @FXML
    void logout(ActionEvent event) throws IOException{
            Main.changeScreen("loginWindow.fxml",600,277);
            Main.currentUser = null;
    }
    private void clearEmployerFields(){
        employeeUsername.clear();
        employeeCitizenship.clear();
        employeePhoneNumber.clear();
        employeeEmail.clear();
        employeeName.clear();
        employeeDateOfBirth.getEditor().clear();
        employeePassword.clear();
        employeeSurname.clear();
    }
    private void clearClientFields(){
        clientPassword.clear();
        clientCitizenship.clear();
        clientCity.clear();
        clientUsername.clear();
        clientBuildingNumber.clear();
        clientCountryOfBirth.clear();
        clientDateOfBirth.getEditor().clear();
        clientEmail.clear();
        clientFlatNumber.clear();
        clientIdExpirationDate.getEditor().clear();
        clientIdNumber.clear();
        clientMotherMaidenSurname.clear();
        clientName.clear();
        clientPesel.clear();
        clientPhoneNumber.clear();
        clientPlaceOfBirth.clear();
        clientStreet.clear();
        clientSurname.clear();
        clientZipCode.clear();
    }
    @FXML
    public void validate(){
        clientPesel.focusedProperty().addListener((arg0, oldValue, newValue)->{
            if (!newValue) {
                if (!clientPesel.getText().matches("\\d+")) {
                    clientPesel.setText("");
                }
            }
        });
    }
}
