package com.bank.aplikacja_bankowa;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;

import java.util.HashMap;

public class ScreenController {
    private HashMap<String, Pane> screenMap = new HashMap<>();
    private Scene main;

    public ScreenController(Scene main){
        this.main = main;
    }

    private  void addScreen(String name, Pane pane){
        screenMap.put(name, pane);
    }

    private void removeScreen(String name){
        screenMap.remove(name);
    }
    private void activate(String name){
        main.setRoot(screenMap.get(name));
    }
}
