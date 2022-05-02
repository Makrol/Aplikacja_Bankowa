package com.bank.aplikacja_bankowa;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;

import java.io.IOException;
import java.time.LocalDate;

public class ClientMainPanelController {

    static public Transfer currentSelectedTransfer;
    @FXML
    private Label currency;

    @FXML
    private Button logoutButton;

    @FXML
    private Button copyAccountNumberButton;

    @FXML
    private Label money;

    @FXML
    private Text name;

    @FXML
    private TableView operationHistoryTable;//

    @FXML
    private Text surname;

    @FXML
    private Text accountNumber;

    @FXML
    private TextField recipientAccountNumber;

    @FXML
    private TextField transferAmount;

    @FXML
    private TextField transferTitle;

    @FXML
    private TextField recipientAddress;

    @FXML
    private TextField recipientName;

    @FXML
    private ChoiceBox<String> typeContract;

    @FXML
    private TextField creditAmount;

    @FXML
    private TextField installmentsQuantity;

    @FXML
    private TextField bruttoIncome;

    @FXML
    private TextField peopleSupported;

    @FXML
    private TextField averageExpenses;

    @FXML
    private TextField companyName;

    @FXML
    private TextField companyNIP;

    @FXML
    private TextField companyAddress;



    private TableColumn<Transfer,String> dateColumn;
    private TableColumn<Transfer,String> typeColumn;
    private TableColumn<Transfer,String> descriptionColumn;
    private TableColumn<Transfer,String> amountColumn;

    @FXML
    void logout(ActionEvent event)throws IOException {
        Main.changeScreen("loginWindow.fxml",600,277);
        Main.currentUser = null;
    }

    @FXML
    public void initialize(){

        name.setText(Main.currentUser.name);
        surname.setText(Main.currentUser.surname);
        accountNumber.setText(((Client) Main.currentUser).getAccountNumber());
        money.setText(((Client) Main.currentUser).getMoney().toString());
        initColumns();
        readUserTransfers();
        initChoiceBox();
    }
    @FXML
    void doTransfer(ActionEvent event) throws IOException,ClassNotFoundException {
        String accountNumber = recipientAccountNumber.getText();
        System.out.println("Wysyłam do: "+accountNumber);
        String recipientFileName=Main.userFileNameTab.findUserFileByAccountNumber(accountNumber);

        if(recipientFileName.equals("")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Błąd przelewu!");
            alert.setContentText("Żaden użytkownik nie posiada takiego numeru konta.");
            alert.setHeaderText("Nie można wykonać przelewu.");
            alert.showAndWait();

        }
        else{
            Client source = (Client)Main.currentUser;
            Client destination = (Client) SerializeFunctions.deSerializeObjectFromFile("src/main/resources/data/"+recipientFileName+".data");
            saveTransferData(Transfer.Type.OUTGOING,transferTitle.getText(),Double.parseDouble(transferAmount.getText()),
                    source.getAccountNumber(),
                    source.getStreet()+" "+source.getBuildingNumber()+"/"+source.getFlatNumber()+" "+source.getZipCode()+" "+source.getCity(),
                    source.getSurname()+" "+source.getName(),
                    destination.getAccountNumber(),
                    recipientAddress.getText(),
                    recipientName.getText());

            destination.getTransfers().add(new Transfer(LocalDate.now(), Transfer.Type.INCOMING,transferTitle.getText(),Double.parseDouble(transferAmount.getText()),
                        source.getAccountNumber(),
                        source.getStreet()+" "+source.getBuildingNumber()+"/"+source.getFlatNumber()+" "+source.getZipCode()+" "+source.getCity(),
                        source.getSurname()+" "+source.getName(),
                        destination.getAccountNumber(),
                        recipientAddress.getText(),
                        recipientName.getText()
                    ));

            destination.setMoney(destination.getMoney()+Double.parseDouble(transferAmount.getText()));
            SerializeFunctions.serializeObjectToFile(destination,"src/main/resources/data/"+recipientFileName+".data");

            ((Client)Main.currentUser).changeMoney(-Double.parseDouble(transferAmount.getText()));

            SerializeFunctions.serializeObjectToFile(Main.currentUser,"src/main/resources/data/"+Main.userFileNameTab.findUserFileByAccountNumber(((Client) Main.currentUser).getAccountNumber())+".data");



            money.setText(new String(String.valueOf((Double.parseDouble(money.getText())-Double.parseDouble(transferAmount.getText())))));

            ;
        }


    }
    @FXML
    void clearTrnasferForm(ActionEvent event) {

    }

    @FXML
    void copyAccountNumber(ActionEvent event){
        ClipboardContent content = new ClipboardContent();
        Clipboard clipboard = Clipboard.getSystemClipboard();
        content.putString(accountNumber.getText());
        clipboard.setContent(content);
    }
    void saveTransferData(Transfer.Type type, String description, Double amount,String sourceAccountNumber, String sourceAddress,
                          String sourceName, String destinationAccountNumber, String destinationAddress,
                          String destinationName){
        Transfer transfer = new Transfer(LocalDate.now(),type,description,amount,sourceAccountNumber,sourceAddress,sourceName,destinationAccountNumber,destinationAddress,destinationName);

        addTransferToHistoryTable(transfer);
        ((Client)Main.currentUser).getTransfers().add(transfer);
        operationHistoryTable.getItems().add(transfer);
    }
    void addTransferToHistoryTable(Transfer transfer){

    }
    @FXML
    void clearCreditForm(ActionEvent event){

    }
    @FXML
    void sendCreditQuery(ActionEvent event){
        //CreditQuery creditQuery = new CreditQuery();
    }
    void initColumns(){
        dateColumn = new TableColumn<>("Data");
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        dateColumn.setPrefWidth(100);

        typeColumn = new TableColumn<>("Typ");
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        typeColumn.setPrefWidth(150);

        descriptionColumn = new TableColumn<>("Tytuł");
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        descriptionColumn.setPrefWidth(550);

        amountColumn = new TableColumn<>("Kwota");
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        amountColumn.setPrefWidth(100);

        operationHistoryTable.getColumns().add(dateColumn);
        operationHistoryTable.getColumns().add(typeColumn);
        operationHistoryTable.getColumns().add(descriptionColumn);
        operationHistoryTable.getColumns().add(amountColumn);

        operationHistoryTable.setRowFactory(tv->{
            TableRow<Transfer> row = new TableRow<>();
            row.setOnMouseClicked(event->{
                if(event.getClickCount()==2 && (!row.isEmpty())){
                    showTransferDetails(row.getItem());
                }
            });
            return row;
        });
    }
    void readUserTransfers(){
       for(Transfer t:((Client)Main.currentUser).getTransfers()){
            operationHistoryTable.getItems().add(t);
        }
    }
    void initChoiceBox(){
        typeContract.getItems().add("Brak");
        typeContract.getItems().add("Na okres próbny");
        typeContract.getItems().add("Na czas określony");
        typeContract.getItems().add("Na czas nieokreślony");

        typeContract.setValue("Brak");



    }
    void showTransferDetails(Transfer transfer){
        currentSelectedTransfer = transfer;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("transferDetails.fxml"));

        Dialog dialog = new Dialog<>();


        try {
            dialog.setDialogPane(loader.load());
        }catch (IOException e){
            e.printStackTrace();
        }
        TransferDetailsDialogController.setDialog(dialog);
        dialog.showAndWait();


    }

}

