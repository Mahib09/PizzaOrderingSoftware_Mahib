package com.example.pizzaorderingsoftware_mahib;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("PizzaOrder-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 860, 560);
        stage.setTitle("Slice Haven Pizzeria Orders");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}