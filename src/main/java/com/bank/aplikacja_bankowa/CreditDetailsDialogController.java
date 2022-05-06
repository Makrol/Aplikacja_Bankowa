package com.bank.aplikacja_bankowa;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;

import java.io.IOException;

public class CreditDetailsDialogController {

    static private Dialog CreditDetailsDialog;
    @FXML
    private Label name;
    @FXML
    private Label surname;
    @FXML
    private Label PESEL;
    @FXML
    private Label creditAmount;
    @FXML
    private Label installmentsQuantity;
    @FXML
    private Label bruttoIncome;
    @FXML
    private Label averageExpenses;
    @FXML
    private Label peopleSupported;
    @FXML
    private Label typeContract;
    @FXML
    private Label companyName;
    @FXML
    private Label companyAddress;
    @FXML
    private Label companyNIP;
    @FXML
    private Label accountNumber;
    @FXML
    private Label creditStanding;

    private CreditQuery creditQuery;
    @FXML
    private void initialize()throws ClassNotFoundException,IOException{
        setCreditData();
    }

    public void setCreditData()throws ClassNotFoundException,IOException {
        creditQuery = AdminMainPanelController.currentSelectedCreditQuery;

        Client client = (Client) SerializeFunctions.deSerializeObjectFromFile("src/main/resources/data/"+Main.userFileNameTab.findUserFileByAccountNumber(creditQuery.getAccountNumber())+".data");
        name.setText(client.getName());
        surname.setText(client.getSurname());
        PESEL.setText(client.getPesel());

        creditAmount.setText(creditQuery.getAmount().toString());
        installmentsQuantity.setText(creditQuery.getInstallmentsQuantity().toString());
        bruttoIncome.setText(creditQuery.getBruttoIncome().toString());
        averageExpenses.setText(creditQuery.getAverageExpenses().toString());
        peopleSupported.setText(creditQuery.getPeopleSupported().toString());
        typeContract.setText(creditQuery.getContractType());
        companyName.setText(creditQuery.getCompanyName());
        companyAddress.setText(creditQuery.getCompanyAddress());
        companyNIP.setText(creditQuery.getCompanyNIP());
        accountNumber.setText(creditQuery.getAccountNumber());
        creditStanding.setText(creditQuery.getCreditWorthiness().toString());
    }


    @FXML
    void closeDialog(ActionEvent event) {
        CreditDetailsDialog.setResult(true);
        CreditDetailsDialog.close();
    }

    static public void setDialog(Dialog dialog) {
        CreditDetailsDialog = dialog;

    }

    @FXML
    void acceptCreditQuery(ActionEvent event)throws IOException, ClassNotFoundException{
        creditQuery.setStatus("Zaakceptowany");
        String fileName = Main.userFileNameTab.findUserFileByAccountNumber(creditQuery.getAccountNumber());

        Client client = (Client) SerializeFunctions.deSerializeObjectFromFile("src/main/resources/data/"+fileName+".data");
        client.getTransfers().add(new Transfer(LocalDate.now(),Transfer.Type.CREDIT,"Przyznano kredyt", creditQuery.getAmount(),
                "435649900000000000000000","GGG-City ul. GGG-teamu 71/213, 71-213","Go-Get-Gold Bank SA",
                creditQuery.getAccountNumber(), client.getCity() +" "+client.getStreet()+ " " +client.getBuildingNumber()+ " " +client.getFlatNumber()+ ", " +client.getZipCode(),
                client.getName()+" "+client.getSurname()));
        client.setMoney(client.getMoney()+Bank.convertCurrency("PLN",client.getClientCurrency(),creditQuery.getAmount()));
        SerializeFunctions.serializeObjectToFile(client,"src/main/resources/data/"+fileName+".data");

    }
    @FXML
    void rejectCreditQuery(ActionEvent event){
        creditQuery.setStatus("Odrzucony");
    }
}
