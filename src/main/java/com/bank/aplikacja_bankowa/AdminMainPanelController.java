package com.bank.aplikacja_bankowa;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.io.IOException;
import java.time.LocalDate;

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
    private TableView creditTable;

    private TableColumn<CreditQuery,String> creditDateColumn;
    private TableColumn<CreditQuery,String> creditAccountNumberColumn;
    private TableColumn<CreditQuery,String> creditAmount;

    @FXML
    private TableView clientsTable;

    private TableColumn<Client,String> surnameColumn;

    private TableColumn<Client,String> nameColumn;

    private TableColumn<Client,String> accountNumberColumn;



    static public CreditQuery currentSelectedCreditQuery;
    static public Client currentSelectedClient;

    @FXML
    public void initialize()throws IOException,ClassNotFoundException{
        validate();
        initCreditTable();
        initClientTable();
        readCreditQuery();
        readClientsList();

        personName.setText(Main.currentUser.name);
        personSurname.setText(Main.currentUser.surname);
        initCurrencyChoiceBox();
    }
    public void initCreditTable(){
        creditDateColumn = new TableColumn<>("Data");
        creditDateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        creditDateColumn.setPrefWidth(100);

        creditAccountNumberColumn = new TableColumn<>("Numer Konta");
        creditAccountNumberColumn.setCellValueFactory(new PropertyValueFactory<>("accountNumber"));
        creditAccountNumberColumn.setPrefWidth(400);

        creditAmount = new TableColumn<>("Kwota");
        creditAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        creditAmount.setPrefWidth(200);

        creditTable.getColumns().add(creditDateColumn);
        creditTable.getColumns().add(creditAccountNumberColumn);
        creditTable.getColumns().add(creditAmount);

        creditTable.setRowFactory(tv->{
            TableRow<CreditQuery> row = new TableRow<>();
            row.setOnMouseClicked(event->{
                if(event.getClickCount()==2 && (!row.isEmpty())){
                    showCreditDetails(row.getItem());
                }
            });
            return row;
        });
    }
    private void initClientTable(){
        surnameColumn = new TableColumn<>("Nazwisko");
        surnameColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));
        surnameColumn.setPrefWidth(150);

        nameColumn = new TableColumn<>("Imie");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameColumn.setPrefWidth(150);

        accountNumberColumn = new TableColumn<>("Numer konta");
        accountNumberColumn.setCellValueFactory(new PropertyValueFactory<>("accountNumber"));
        accountNumberColumn.setPrefWidth(300);


        clientsTable.getColumns().add(surnameColumn);
        clientsTable.getColumns().add(nameColumn);
        clientsTable.getColumns().add(accountNumberColumn);

        clientsTable.setRowFactory(tv->{
            TableRow<Client> row = new TableRow<>();
            row.setOnMouseClicked(event->{
                if(event.getClickCount()==2 && (!row.isEmpty())){
                    showClientDetails(row.getItem());
                }
            });
            return row;
        });

    }
    private void showClientDetails(Client client){
        currentSelectedClient= client;
        ClientDetailsDialogController.setCurrentClient(currentSelectedClient);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("clientDetails.fxml"));

        Dialog dialog = new Dialog<>();

        try {
            dialog.setDialogPane(loader.load());
        }catch (IOException e){
            e.printStackTrace();
        }
        ClientDetailsDialogController.setDialog(dialog);
        dialog.showAndWait();
    }

    private void showCreditDetails(CreditQuery creditQuery){
        currentSelectedCreditQuery= creditQuery;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("creditDetails.fxml"));

        Dialog dialog = new Dialog<>();

        try {
            dialog.setDialogPane(loader.load());
        }catch (IOException e){
            e.printStackTrace();
        }
        CreditDetailsDialogController.setDialog(dialog);
        dialog.showAndWait();
    }
    void readCreditQuery(){
        for(CreditQuery cQ:Main.creditData.getCreditDataContainer()) {
            creditTable.getItems().add(cQ);
        }
    }
    void readClientsList() throws ClassNotFoundException,IOException{
        for (String value : Main.userFileNameTab.accountNumberFile.values()) {
            clientsTable.getItems().add(SerializeFunctions.deSerializeObjectFromFile("src/main/resources/data/"+value+".data"));

        }
    }
    @FXML
    void addClient(ActionEvent event) throws IOException{
        if(LocalDate.now().getYear()-clientDateOfBirth.getValue().getYear()<10){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Błąd dodania użytkownika");
            alert.setContentText("Użytkownik jest zbyt młody.");
            alert.setHeaderText("Nie można dodać użytkownika poniżej 10 roku życia.");
            alert.showAndWait();
            return;
        }

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
        clearClientForm(new ActionEvent());
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
       clearEmployeeForm(new ActionEvent());
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
    void initCurrencyChoiceBox(){
        for(int i = 0;i<Main.ratesTable.getExchangeRatesTables().get(0).getRates().size();i++){
            clientCurrency.getItems().add(Main.ratesTable.getExchangeRatesTables().get(0).getRates().get(i).getCode());
        }
        clientCurrency.getItems().add("PLN");
        clientCurrency.setValue("PLN");
    }
}
