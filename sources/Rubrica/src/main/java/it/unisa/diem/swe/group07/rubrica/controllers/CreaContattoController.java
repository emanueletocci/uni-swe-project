/**
 * @file CreaContattoController.java
 * @brief questo file contiene l'implementazione del controller per la creazione di un contatto
 * @autor Gruppo07
 * @date Dicembre, 2024
 * @version 1.0
 */
package it.unisa.diem.swe.group07.rubrica.controllers;
import it.unisa.diem.swe.group07.rubrica.models.ContattoEsteso;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.image.Image;
import java.io.File;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

import java.time.LocalDate;


public class CreaContattoController extends AbstractController implements Initializable{
    /**
     * @brief bottone per aggiungere l'email
     */
    @FXML
    private Button aggiungiEmail;
    /**
     * @brief bottone per aggiungere il numero telefonico
     */
    @FXML
    private Button aggiungiTelefono;
       /**
     * @brief bottone per effettuare la creazione di un contatto
     */
    @FXML
    private Button pulsanteCrea;
       /**
     * @brief bottone per inserire l'immagine
     */
    @FXML
    private Button bottone_imm;
    /**
     * @brief  Text Field per il cognome del contatto
     */
    @FXML
    private TextField cognome;
    /**
     * @brief  Text Field per il compleanno del contatto
     */
    @FXML
    private DatePicker compleanno;
       /**
     * @brief  Text Field per l'email del contatto
     */
    @FXML
    private TextField email;
    /**
     * @brief  Text Field per l'email del contatto
     */
    @FXML
    private TextField email2;
    /**
     * @brief  Text Field per l'email del contatto
     */
    @FXML
    private TextField email3;
    /**
     * @brief immagine da inserire
     */
    @FXML
    private ImageView immagine;
    /**
     * @brief Text Field per l'indirizzo del contatto
     */
    @FXML
    private TextField indirizzo;
    /**
     * @brief Text Field per il nome del contatto
     */
    @FXML
    private TextField nome;
    /**
     * @brief Text Field per il sito web del contatto
     */
    @FXML
    private TextField sitoWeb;
    /**
     * @brief Text Field per il numero telefonico del contatto
     */
    @FXML
    private TextField telefono;
    /**
     * @brief Text Field per il numero telefonico del contatto
     */
    @FXML
    private TextField telefono2;
    /**
     * @brief Text Field per il numero telefonico del contatto
     */
    @FXML
    private TextField telefono3;

    /**
     * @brief Text Field per le note
     */
    @FXML
    private TextField note;
    /**
     * @brief fileChooser
     */
    private FileChooser fileChooser = new FileChooser();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        immagine.setImage(null);
        fileChooser.setInitialDirectory(new File("C:\\Users\\hp\\Desktop\\")); //aggiustare path
    }

    /**
     * @brief metodo che permette di inserire un immagine di profile nella bottone_imm
     * @param event evento generato dal click sul pulsante pulsanteImmagine
     */
    @FXML
    void handleAggiungiImmagine(ActionEvent event) {
        mostraMessaggioErrore("Oh no!", "Questa funzione non é stata ancora implementata!");
        fileChooser.setTitle("Scegli immagine di profilo:");
        fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
        File img = fileChooser.showOpenDialog(new Stage());
        if (img != null) {
            Image immagineScelta=new Image(img.toURI().toString());
            immagine.setImage(immagineScelta);
        }
    }
    /**
     * @brief metodo che preleva il valore dai Text Field creando il contatto ed aggiungendolo alla Lista+
     * @param event evento generato dal click sul pulsante Crea
     */
    @FXML
    public void handleAggiungiContatto(ActionEvent event) {
        // Verifico che i campi obbligatori siano stati sovrascritti
        if (!validaCampiObbligatori()) {
            mostraMessaggioErrore("Errore di validazione", "Devi inserire almeno un nome o un cognome.");
            return; // Interrompe l'esecuzione in caso di errore
        }

        // Ottieni i valori dai TextField
        String nomeText = nome.getText();
        String cognomeText = cognome.getText();
        String telefonoText = telefono.getText();
        String telefono2Text = telefono2.getText();
        String telefono3Text = telefono3.getText();
        String emailText = email.getText();
        String email2Text = email2.getText();
        String email3Text = email3.getText();
        LocalDate compleannoText = compleanno.getValue();
        String indirizzoText = indirizzo.getText();
        String sitoWebText = sitoWeb.getText();
        String noteText = note.getText();

        // Crea il nuovo contatto
        ContattoEsteso temp = new ContattoEsteso(nomeText, cognomeText, telefonoText, telefono2Text, telefono3Text, emailText, email2Text, email3Text, compleannoText, indirizzoText, sitoWebText, noteText, false, false);

        // Se il contatto puó essere aggiunto alla mappa, allora aggiungilo anche alla lista
        if(this.getRubrica().aggiungiContattoEVerifica(temp))
            this.getListaContatti().add(temp);
        else
            mostraMessaggioErrore("Contatto Duplicato!", "Il contatto che si sta cercando di aggiungere é giá presente in rubrica!");
        // Modificare aggiungendo una logica ciclica che consente di non chiudere immediatamente la finestra bensí modificare i valori immessi dall'utente al fine di aggiungere un contatto valido

        System.out.println("\n"+ getClass() + " - handleAggiungiContatto ***\n");
        System.out.println("tempID = " + temp.getId());
        System.out.println("\n****RUBRICA***\n" + this.getRubrica().toString());
        System.out.println("\n***LISTA CONTATTI***\n" + this.getListaContatti().toString());

        // Chiudi la finestra
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
    
    /**
     * @brief metodo per mostrare messaggio di errore
     */
    private void mostraMessaggioErrore(String titolo, String messaggio) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titolo);
        alert.setContentText(messaggio);
        alert.showAndWait();
    }

    /**
     * @brief metodo verificare che almeno un TextField tra nome e cognome è stato sovrascritto
     */
    private boolean validaCampiObbligatori() {
        // Un contatto deve avere necessariamente almeno nome o cognome (tutti gli altri campi possono essere vuoti)
        return (nome.getText() != null && !nome.getText().trim().isEmpty()) || (cognome.getText() != null && !cognome.getText().trim().isEmpty());
    }

}