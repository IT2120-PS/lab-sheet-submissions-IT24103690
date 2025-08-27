package com.example.lab4javafx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick(javafx.event.ActionEvent event) {
        try{
            FXMLLoader loader =  new FXMLLoader(getClass().getResource("/com/example/lab4javafx/insert.fxml"));
            Parent newRoot = loader.load();

            Stage stage=(Stage) ((Node) event.getSource()).getScene().getWindow();

            stage.setScene(new Scene(newRoot));
            stage.setTitle(("Student"));

        }catch (IOException e){
            e.printStackTrace();
        }

    }


}