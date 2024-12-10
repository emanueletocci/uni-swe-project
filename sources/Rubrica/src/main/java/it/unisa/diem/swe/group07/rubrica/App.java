package it.unisa.diem.swe.group07.rubrica;

import javafx.fxml.FXMLLoader;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
//versione 9dic

/**
 * @file App.java
 * @brief Application loader.
 * 
 * This file loads up the application and all its core components (stage,
 * scene, view loaders and controllers) and keeps the application layout
 * responsive as window gets resized by user. 
 */
public class App extends Application {
    private Parent root;
    private Scene scene;

    @Override
    public void start(Stage stage) throws Exception {
            root = FXMLLoader.load ( getClass ().getResource ( "/fxml/RubricaView.fxml" ) );
            scene = new Scene ( root );
            // Imposta la scena sullo stage
            stage.setScene ( scene );
            // Opzionalmente, imposta un titolo per la finestra
            stage.setTitle ( "Rubrica Telefonica" );
            // Mostra lo stage
            stage.show ();
    }

    public static void main(String[] args) {
        launch(args);
    }

}