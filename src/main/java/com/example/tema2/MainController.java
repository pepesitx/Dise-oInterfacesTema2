package com.example.tema2;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;


public class MainController implements Initializable {

    @FXML private TextField textFieldNumber1, getTextFieldNumber2;
    @FXML private ComboBox<String> comboBoxOperation;
    @FXML private Button buttonCalculate;
    @FXML private Label labelTitle;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        labelTitle.requestFocus();

        comboBoxOperation.getItems().addAll("Sumar" , "Restar", "Multiplicar", "Dividir");
    }
}