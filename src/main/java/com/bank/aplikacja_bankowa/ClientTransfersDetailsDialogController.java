package com.bank.aplikacja_bankowa;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;

public class ClientTransfersDetailsDialogController {

    public static Transfer currentTransfer;
    private static Client currentClient;
    static private Dialog clientTransfersDetailsDialog;
    private TableColumn<Transfer,String> dateColumn;
    private TableColumn<Transfer,String> typeColumn;
    private TableColumn<Transfer,String> descriptionColumn;
    private TableColumn<Transfer,String> amountColumn;



    @FXML
    private TableView clientTransferTable;

    @FXML
    private Button closeButton;

    @FXML
    private void initialize(){
        initTable();
        readClientTransfers();
    }
    private void initTable(){
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

        clientTransferTable.getColumns().add(dateColumn);
        clientTransferTable.getColumns().add(typeColumn);
        clientTransferTable.getColumns().add(descriptionColumn);
        clientTransferTable.getColumns().add(amountColumn);

        clientTransferTable.setRowFactory(tv->{
            TableRow<Transfer> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if(event.getClickCount()==2&&(!row.isEmpty())){
                    showTransferDetails(row.getItem());
                }
            });
            return row;
        });
    }
    @FXML
    void closeDialog(ActionEvent event) {
        clientTransfersDetailsDialog.setResult(true);
        clientTransfersDetailsDialog.close();
    }
    static public void setDialog(Dialog dialog){
        clientTransfersDetailsDialog = dialog;
    }
    static public void setCurrentClient(Client client){
        currentClient = client;
    }
    private void readClientTransfers(){
        for (Transfer t: currentClient.getTransfers()){
            clientTransferTable.getItems().add(t);
        }
    }

    private void showTransferDetails(Transfer transfer){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("transferDetails.fxml"));
        currentTransfer = transfer;
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
