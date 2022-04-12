package com.bank.aplikacja_bankowa;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    private static Stage mainStage;
    public static UserFileNameTab userFileNameTab;// = new UserFileNameTab();
    public static Person currentUser;
    @Override
    public void start(Stage stage) throws IOException,ClassNotFoundException {
        userFileNameTab = (UserFileNameTab) SerializeFunctions.deSerializeObjectFromFile("src/main/resources/data/loginData.data");
        mainStage = stage;
        stage.setResizable(false);
        changeScreen("loginWindow.fxml",600,400);
        stage.setTitle("Aplikacja Bankowa!");
        stage.show();
    }public static void main(String[] args) {
        launch();
    }
    public static void changeScreen(String name, float width, float height) throws  IOException{
        mainStage.setScene(new Scene(new FXMLLoader(Main.class.getResource(name)).load(),width,height));
    }
}