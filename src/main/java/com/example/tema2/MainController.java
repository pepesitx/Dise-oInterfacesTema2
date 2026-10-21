package com.example.tema2;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.text.MessageFormat;
import java.util.ResourceBundle;


public class MainController implements Initializable {

    @FXML private TextField textFieldNumber1, textFieldNumber2;
    @FXML private ComboBox<Option> comboBoxOperation;
    @FXML private Button buttonCalculate;
    @FXML private Label labelTitle, labelResult;

    private ResourceBundle bundle;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.bundle = resourceBundle;

        Option optionAdd = new Option("Add",             bundle.getString("option.add"));
        Option optionSubstract = new Option("Substract", bundle.getString("option.subtract"));
        Option optionMultiply = new Option("Multiply",   bundle.getString("option.multiply"));
        Option optionDivide = new Option("Divide",       bundle.getString("option.divide"));
        labelTitle.requestFocus();
        comboBoxOperation.getItems().addAll(optionAdd, optionSubstract, optionMultiply, optionDivide);

        textFieldNumber1.textProperty().addListener(_ -> checkValues());
        textFieldNumber2.textProperty().addListener(_ -> checkValues());
        comboBoxOperation.valueProperty().addListener(_ -> checkValues());


        buttonCalculate.setOnAction(_ -> {
            int number1 = Integer.parseInt(textFieldNumber1.getText());
            int number2 = Integer.parseInt(textFieldNumber2.getText());
            String operation = comboBoxOperation.getValue().getKey();

            int resultado = switch (operation){
                case "Add"             -> number1 + number2;
                case "Substract"            -> number1 - number2;
                case "Multiply"       -> number1 * number2;
                case "Divide"           -> number1 / number2;
                default                  -> 0;
            } ;

            labelResult.setText(MessageFormat.format(bundle.getString("label.result"), resultado));
        });
    }
    private void checkValues(){
        boolean validCombo = comboBoxOperation.getValue() !=null;
        boolean validTextField = false;

        try {
            Integer.parseInt(textFieldNumber1.getText());
            Integer.parseInt(textFieldNumber2.getText());

            validTextField = true;
        } catch (Exception _){

        }
        buttonCalculate.setDisable(!(validCombo && validTextField));
    }

}