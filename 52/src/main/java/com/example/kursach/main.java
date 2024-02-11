package com.example.kursach;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class    main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("view_authorization.fxml"));
        stage.setScene(new Scene(root, 300, 400));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
