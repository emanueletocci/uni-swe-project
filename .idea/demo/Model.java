/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package provapackage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author lucagreco
 */
public class Model extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // Carica il file FXML chiamato View.fxml
        Parent root = FXMLLoader.load(getClass().getResource("View.fxml"));

        // Crea una scena con il contenuto caricato
        Scene scene = new Scene(root);

        // Imposta la scena sullo stage
        stage.setScene(scene);

        // Opzionalmente, imposta un titolo per la finestra
        stage.setTitle("Progetto Rubrica Gruppo 07");

        // Mostra lo stage
        stage.show();
    }

    /**
     * Il metodo main avvia l'applicazione.
     */
    public static void main(String[] args) {
        launch(args);
    }
}