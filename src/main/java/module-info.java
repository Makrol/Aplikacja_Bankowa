module com.bank.aplikacja_bankowa {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.apache.pdfbox;

    opens com.bank.aplikacja_bankowa to javafx.fxml;
    exports com.bank.aplikacja_bankowa;
}