/**
 * @file App.java
 * @brief Classe principale per il caricamento dell'applicazione.
 *
 * Questa classe estende la classe Application di JavaFX e si occupa di caricare
 * l'interfaccia grafica dell'applicazione, inizializzando la scena e lo stage.
 */
package it.unisa.diem.swe.group07.rubrica;

import javafx.fxml.FXMLLoader;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @brief Classe principale dell'applicazione Rubrica Telefonica.
 *
 * Questa classe è responsabile del caricamento dell'interfaccia grafica
 * dell'applicazione, inizializzando la scena e lo stage. Gestisce inoltre
 * il layout dell'applicazione, rendendolo responsive al ridimensionamento
 * della finestra da parte dell'utente.
 */
public class App extends Application {
    private Parent root;
    private Scene scene;

    /**
     * @brief Metodo principale per l'avvio dell'applicazione.
     *
     * Questo metodo viene chiamato automaticamente quando l'applicazione viene
     * avviata. Carica il file FXML che definisce l'interfaccia utente, inizializza
     * la scena e lo stage, e mostra la finestra dell'applicazione.
     *
     * @param[in] stage Lo stage principale dell'applicazione.
     * @throws Exception Se si verifica un errore durante il caricamento del file FXML.
     */
    @Override
    public void start(Stage stage) throws Exception {
        root = FXMLLoader.load ( getClass ().getResource ( "/fxml/RubricaView.fxml" ) );
        scene = new Scene ( root );
        // Imposta la scena sullo stage
        stage.setScene ( scene );
        // Opzionalmente, imposta un titolo per la finestra
        stage.setTitle ( "Rubrica Telefonica" );
        // Disabilita il ridimensionamento dello stage
        stage.setResizable( false );
        // Mostra lo stage
        stage.show ();
    }

    public static void main(String[] args) {
        launch(args);
    }

}