package com.example.tema2;

import atlantafx.base.theme.NordDark;
import atlantafx.base.theme.PrimerDark;
import atlantafx.base.theme.Theme;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.awt.desktop.AppForegroundListener;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //sets the Theme
        Theme theme = new NordDark();
        Application.setUserAgentStylesheet(theme.getUserAgentStylesheet());

        //Sets the language
        Locale locale = Locale.forLanguageTag("es");
        ResourceBundle bundle = ResourceBundle.getBundle("i18n.messages", locale);


        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("main-view.fxml"), bundle);
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Mi primer proyecto");
        stage.setScene(scene);
        stage.show();
        stage.requestFocus();

        //centrar en pantalla
        Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
        stage.setX((bounds.getWidth() - stage.getWidth()) / 2);
        stage.setX((bounds.getHeight() - stage.getHeight()) / 2);
    }

    public static void main(String[] args) {
        launch();
    }
}