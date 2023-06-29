package ru.rutmiit.lsm;


import ru.rutmiit.lsm.repositories.DatabaseHandler;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        // Loading the FXML file of login
        Parent root = FXMLLoader.load(getClass().getResource("/ru/rutmiit/lsm/views/login.fxml"));
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.setTitle("Library Management System");
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image("https://static.thenounproject.com/png/3314579-200.png"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        // A thread so it makes opening the windows faster
        new Thread(DatabaseHandler::getInstance).start();
    }

    public static void main(String[] args) {
        launch();
    }
}