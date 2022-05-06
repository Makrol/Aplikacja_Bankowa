package com.bank.aplikacja_bankowa;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;

public class PayOffInstallmentDialogController {

    static private Dialog payOffInstallmentDialog;
    @FXML
    private Label installmentCounter;

    @FXML
    private void initialize(){
        installmentCounter.setText(ClientMainPanelController.currentCredit.getInstallmentsQuantityToBePaid().toString());

    }
    @FXML
    private void closeDialog(ActionEvent event){
        payOffInstallmentDialog.setResult(true);
        payOffInstallmentDialog.close();
    }
    @FXML
    static public void setDialog(Dialog dialog){
        payOffInstallmentDialog = dialog;
    }

    @FXML
    private void payOffInstallment(ActionEvent event) {
        ClientMainPanelController.currentCredit.setInstallmentsQuantityToBePaid(ClientMainPanelController.currentCredit.getInstallmentsQuantityToBePaid()-1);
        installmentCounter.setText(ClientMainPanelController.currentCredit.getInstallmentsQuantityToBePaid().toString());
        ClientMainPanelController.currentCredit.setCreditToBePaid(
                ClientMainPanelController.currentCredit.getCreditToBePaid()-(
                        ClientMainPanelController.currentCredit.getAmount()/ClientMainPanelController.currentCredit.getInstallmentsQuantity()));
        ((Client)Main.currentUser).setMoney(((Client)Main.currentUser).getMoney()-(
                ClientMainPanelController.currentCredit.getAmount()/ClientMainPanelController.currentCredit.getInstallmentsQuantity()));
    }




}
