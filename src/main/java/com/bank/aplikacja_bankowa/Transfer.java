package com.bank.aplikacja_bankowa;

import javafx.beans.property.SimpleStringProperty;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;

public class Transfer implements Serializable {
    public static enum Type {OUTGOING,INCOMING,CREDIT,PAYOFF}

    private String date;
    private String type;
    private String title;
    private String amount;

    private String sourceAccountNumber;
    private String sourceAddress;
    private String sourceName;


    private String destinationAccountNumber;
    private String destinationAddress;
    private String destinationName;


    private String id;

    public Transfer(LocalDate date, Type type, String title, Double amount, String sourceAccountNumber, String sourceAddress,
                    String sourceName, String destinationAccountNumber, String destinationAddress,
                    String destinationName) {
        this.date = date.toString();
        if(type == Type.OUTGOING)
            this.type = "Przelew wychodzący";
        else if(type == Type.INCOMING)
            this.type = "Przelew przychodzący";
        else if(type == Type.CREDIT)
            this.type = "Kredyt";
        this.title = title;
        this.amount = amount.toString();
        this.sourceAccountNumber = sourceAccountNumber;
        this.sourceAddress = sourceAddress;
        this.sourceName = sourceName;

        this.destinationAccountNumber = destinationAccountNumber;
        this.destinationAddress = destinationAddress;
        this.destinationName = destinationName;
    }

    public String getDate() {
        return date;
    }

    public String getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public String getAmount() {
        return amount;
    }

    public String getSourceAccountNumber() {
        return sourceAccountNumber;
    }

    public String getSourceAddress() {
        return sourceAddress;
    }

    public String getSourceName() {
        return sourceName;
    }

    public String getDestinationAccountNumber() {
        return destinationAccountNumber;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public void createPDF() throws IOException {
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
        contentStream.showText("Numer konta:    "+sourceAccountNumber);
        contentStream.endText();

        contentStream.beginText();
        contentStream.setFont(font, 12);
        contentStream.newLineAtOffset(100, rect.getHeight() -  15*(++line));
        contentStream.showText("Zleceniodawca:  "+sourceName);
        contentStream.endText();

        contentStream.beginText();
        contentStream.setFont(font, 12);
        contentStream.newLineAtOffset(100, rect.getHeight() -  15*(++line));
        contentStream.showText("Adres zleceniodawcy:    "+sourceAddress);
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
        contentStream.showText("Numer konta:    "+destinationAccountNumber);
        contentStream.endText();

        contentStream.beginText();
        contentStream.setFont(font, 12);
        contentStream.newLineAtOffset(100, rect.getHeight() -  15*(++line));
        contentStream.showText("Zleceniodawca:  "+destinationName);
        contentStream.endText();

        contentStream.beginText();
        contentStream.setFont(font, 12);
        contentStream.newLineAtOffset(100, rect.getHeight() -  15*(++line));
        contentStream.showText("Adres zleceniodawcy:    "+destinationAddress);
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
        contentStream.showText("Typ operacji:   "+type);
        contentStream.endText();

        contentStream.beginText();
        contentStream.setFont(font, 12);
        contentStream.newLineAtOffset(100, rect.getHeight() -  15*(++line));
        contentStream.showText("Data:   "+date);
        contentStream.endText();

        contentStream.beginText();
        contentStream.setFont(font, 12);
        contentStream.newLineAtOffset(100, rect.getHeight() -  15*(++line));
        contentStream.showText("Kwota:  "+amount);
        contentStream.endText();

        contentStream.beginText();
        contentStream.setFont(font, 12);
        contentStream.newLineAtOffset(100, rect.getHeight() -  15*(++line));
        contentStream.showText("Tytul:  "+title);
        contentStream.endText();

        contentStream.close();

        document.save("src/c.pdf");
        document.close();

    }
}
