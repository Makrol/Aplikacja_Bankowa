package com.bank.aplikacja_bankowa;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;

import java.io.IOException;


public class TransferDetailsDialogController {

    static private Dialog transferDetailsDialog;
    @FXML
     private Label date;

    @FXML
    private Label type;

    @FXML
    private Label amount;

    @FXML
    private Label title;

    @FXML
    private Label sourceAccountNumber;

    @FXML
    private Label sourceName;

    @FXML
    private Label sourceAddress;

    @FXML
    private void initialize(){
        setTransferData();
    }
    public void setTransferData(){
        Transfer transfer;
        if(ClientMainPanelController.currentSelectedTransfer==null){
            transfer = ClientTransfersDetailsDialogController.currentTransfer;
        }
        else {
            transfer = ClientMainPanelController.currentSelectedTransfer;
        }
        date.setText(transfer.getDate());
        type.setText(transfer.getType());
        amount.setText(transfer.getAmount());
        title.setText(transfer.getTitle());
        sourceAccountNumber.setText(transfer.getSourceAccountNumber());
        sourceName.setText(transfer.getSourceName());
        sourceAddress.setText(transfer.getSourceAddress());
    }
    @FXML
    void closeDialog(ActionEvent event) {
        transferDetailsDialog.setResult(true);
        transferDetailsDialog.close();
    }

    static public void setDialog(Dialog dialog) {
        transferDetailsDialog = dialog;

    }
    @FXML
    void printTransfer(ActionEvent event)throws IOException {
        if(ClientMainPanelController.currentSelectedTransfer!=null)
            ClientMainPanelController.currentSelectedTransfer.createPDF();
        else
            ClientTransfersDetailsDialogController.currentTransfer.createPDF();

    }
}
