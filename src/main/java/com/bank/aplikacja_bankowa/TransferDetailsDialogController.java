package com.bank.aplikacja_bankowa;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDTrueTypeFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.io.File;
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
        Transfer transfer = ClientMainPanelController.currentSelectedTransfer;
        date.setText(transfer.getTitle());
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
        PDDocument document = new PDDocument();
        PDPage firstPage = new PDPage();
        document.addPage(firstPage);
        PDRectangle rect = firstPage.getMediaBox();
        PDPageContentStream contentStream = new PDPageContentStream(document, firstPage);

        PDType0Font font = PDType0Font.load(document, new File("src/main/resources/font/AbhayaLibre-Regular.ttf"));
        PDType0Font fontBold = PDType0Font.load(document, new File("src/main/resources/font/AbhayaLibre-Bold.ttf"));

        int line = 0;
        PDImageXObject pdfImage = PDImageXObject.createFromFile("src/main/resources/img/logo.png", document);
        contentStream.drawImage(pdfImage, 0,  rect.getHeight()- 100*(++line), 100,100);



        contentStream.beginText();
        contentStream.setFont(fontBold, 40);
        contentStream.newLineAtOffset((float) (rect.getWidth()*0.25), rect.getHeight() -  25*(++line));
        contentStream.showText("Potwierdzenie przelewu");
        contentStream.endText();

        line+=6;
        contentStream.beginText();
        contentStream.setFont(fontBold, 20);
        contentStream.newLineAtOffset((float) (rect.getWidth()*0.5), rect.getHeight() -  15*(++line));
        contentStream.showText("Nadawca");
        contentStream.endText();

        line+=2;
        contentStream.beginText();
        contentStream.setFont(font, 12);
        contentStream.newLineAtOffset( 100, rect.getHeight() -  15*(++line));
        contentStream.showText("Numer konta:    "+ClientMainPanelController.currentSelectedTransfer.getSourceAccountNumber());
        contentStream.endText();

        contentStream.beginText();
        contentStream.setFont(font, 12);
        contentStream.newLineAtOffset(100, rect.getHeight() -  15*(++line));
        contentStream.showText("Zleceniodawca:  "+ClientMainPanelController.currentSelectedTransfer.getSourceName());
        contentStream.endText();

        contentStream.beginText();
        contentStream.setFont(font, 12);
        contentStream.newLineAtOffset(100, rect.getHeight() -  15*(++line));
        contentStream.showText("Adres zleceniodawcy:    "+ClientMainPanelController.currentSelectedTransfer.getSourceAddress());
        contentStream.endText();

        line+=3;
        contentStream.beginText();
        contentStream.setFont(fontBold, 20);
        contentStream.newLineAtOffset((float) (rect.getWidth()*0.5), rect.getHeight() -  15*(++line));
        contentStream.showText("Odbiorca");
        contentStream.endText();

        line+=2;
        contentStream.beginText();
        contentStream.setFont(font, 12);
        contentStream.newLineAtOffset(100, rect.getHeight() -  15*(++line));
        contentStream.showText("Numer konta:    "+ClientMainPanelController.currentSelectedTransfer.getDestinationAccountNumber());
        contentStream.endText();

        contentStream.beginText();
        contentStream.setFont(font, 12);
        contentStream.newLineAtOffset(100, rect.getHeight() -  15*(++line));
        contentStream.showText("Zleceniodawca:  "+ClientMainPanelController.currentSelectedTransfer.getDestinationName());
        contentStream.endText();

        contentStream.beginText();
        contentStream.setFont(font, 12);
        contentStream.newLineAtOffset(100, rect.getHeight() -  15*(++line));
        contentStream.showText("Adres zleceniodawcy:    "+ClientMainPanelController.currentSelectedTransfer.getDestinationAddress());
        contentStream.endText();

        line+=3;
        contentStream.beginText();
        contentStream.setFont(fontBold, 20);
        contentStream.newLineAtOffset((float) (rect.getWidth()*0.5)-100, rect.getHeight() -  15*(++line));
        contentStream.showText("Informacje o przelewie");
        contentStream.endText();

        line+=2;
        contentStream.beginText();
        contentStream.setFont(font, 12);
        contentStream.newLineAtOffset(100, rect.getHeight() -  15*(++line));
        contentStream.showText("Typ operacji:   "+ClientMainPanelController.currentSelectedTransfer.getType());
        contentStream.endText();

        contentStream.beginText();
        contentStream.setFont(font, 12);
        contentStream.newLineAtOffset(100, rect.getHeight() -  15*(++line));
        contentStream.showText("Data:   "+ClientMainPanelController.currentSelectedTransfer.getDate());
        contentStream.endText();

        contentStream.beginText();
        contentStream.setFont(font, 12);
        contentStream.newLineAtOffset(100, rect.getHeight() -  15*(++line));
        contentStream.showText("Kwota:  "+ClientMainPanelController.currentSelectedTransfer.getAmount());
        contentStream.endText();

        contentStream.beginText();
        contentStream.setFont(font, 12);
        contentStream.newLineAtOffset(100, rect.getHeight() -  15*(++line));
        contentStream.showText("Tytul:  "+ClientMainPanelController.currentSelectedTransfer.getTitle());
        contentStream.endText();

        contentStream.close();

        document.save("src/c.pdf");
        document.close();


    }
}
