package com.bank.aplikacja_bankowa;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

public class Main extends Application {
    private static Stage mainStage;
    private static HashMap<String, Scene> screenMap = new HashMap<>();
    @Override
    public void start(Stage stage) throws IOException {
        mainStage = stage;
        stage.setResizable(false);
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("loginWindow.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }public static void main(String[] args) {
        launch();
    }
    public static void addAndActiveScreen(String name) throws  IOException{
        addScreen(name);
        activeScreen(name);
    }
    public static void addScreen(String name) throws  IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(name));
        Scene scene = new Scene(fxmlLoader.load(),904.0,634.0);
        screenMap.put(name, scene);
    }
    public static void removeScreen(String name){
        screenMap.remove(name);
    }
    public static void activeScreen(String name){
        mainStage.setScene(screenMap.get(name));
    }
}