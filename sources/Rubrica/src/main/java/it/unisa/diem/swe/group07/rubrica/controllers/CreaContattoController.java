/**
 * @file CreaContattoController.java
 * @brief Il file contiene l'implementazione del controller che gestisce la creazione di un nuovo contatto.
 * @author Gruppo07
 * @date Dicembre, 2024
 */
package it.unisa.diem.swe.group07.rubrica.controllers;
import it.unisa.diem.swe.group07.rubrica.models.ContattoEsteso;
import it.unisa.diem.swe.group07.rubrica.models.Rubrica;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import java.time.LocalDate;
import javafx.scene.image.Image;
import javafx.fxml.Initializable;
import java.io.File;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import java.net.URL;
import java.util.ResourceBundle;


public class CreaContattoController extends AbstractController implements Initializable{

    /**
     * @brief La classe rappresenta il controllore responsabile della gestione della vista secondaria e della creazione di un nuovo contatto.
     * @see Rubrica
     * @see AbstractController
     * @see RubricaController
     */

    /**
    * @brief TextField per il nome del contatto.
    */
    @FXML
    private TextField nome;
    /**
     * @brief  Text Field per il cognome del contatto.
     */
    @FXML
    private TextField cognome;
    /**
     * @brief TextField per il numero telefonico 1 del contatto.
     */
    @FXML
    private TextField telefono;
    /**
     * @brief TextField per il numero telefonico 2 del contatto.
     */
    @FXML
    private TextField telefono2;
    /**
     * @brief TextField per il numero telefonico 3 del contatto
     */
    @FXML
    private TextField telefono3;
    /**
     * @brief  TextField per l'email 1 del contatto.
     */
    @FXML
    private TextField email;
    /**
     * @brief  TextField per l'email 2 del contatto.
     */
    @FXML
    private TextField email2;
    /**
     * @brief  TextField per l'email 3 del contatto.
     */
    @FXML
    private TextField email3;
    /**
     * @brief  TextField per il compleanno del contatto.
     */
    @FXML
    private DatePicker compleanno;
    /**
     * @brief TextField per l'indirizzo di residenza del contatto.
     */
    @FXML
    private TextField indirizzo;
    /**
     * @brief TextField per il sito web del contatto.
     */
    @FXML
    private TextField sitoWeb;
    /**
     * @brief TextField per le note aggiuntive.
     */
    @FXML
    private TextField note;
         /**
     * @brief immagine di profilo del contatto
     */
    @FXML
    private ImageView immagine;
    /**
     * @brief pulsante per inserire immagine
     */
    @FXML
    private Button pulsanteimg;
   
    /**
     * @brief fileChooser
     */
    private FileChooser fileChooser = new FileChooser();
    
     @Override
    public void initialize(URL location, ResourceBundle resources) {
        fileChooser.setInitialDirectory(new File("C:\\")); 
    }
/**
     * @brief metodo permette di scegliere un file con estensione del tipo "*.png", "*.jpg", "*.gif" 
     * tramite un FileChooser e di settarlo nel nel ImageView "immagine" se non è null
     * @param[in] event evento generato dal click sul pulsante pulsanteImmagine
     */
    @FXML
    void gestioneImmagine(ActionEvent event) {
        fileChooser.setTitle("Scegli immagine di profilo:");
        fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
        File img = fileChooser.showOpenDialog(new Stage());
        if (img != null) {
            Image immagineScelta=new Image(img.toURI().toString());
            immagine.setImage(immagineScelta);
        }
    }

    /**
     * @brief Il metodo preleva i valori dai Text Field, crea un contatto temporaneo e, se i valori inseriti dall'utente sono validi, lo aggiunge alla rubrica (e alla lista osservabile,
     * di conseguenza aggiorna la TableView).
     * @param[in] event Evento generato dal click sul pulsante "Crea Contatto".
     */
    @FXML
    public void handleAggiungiContatto(ActionEvent event) {

        // Ottieni i valori dai TextField e se sono presenti degli spazi, rimuovili
        String nomeText = nome.getText().trim();
        String cognomeText = cognome.getText().trim();
        String telefonoText = telefono.getText().trim();
        String telefono2Text = telefono2.getText().trim();
        String telefono3Text = telefono3.getText().trim();
        String emailText = email.getText().trim();
        String email2Text = email2.getText().trim();
        String email3Text = email3.getText().trim();
        LocalDate compleannoText = compleanno.getValue();
        String indirizzoText = indirizzo.getText().trim();
        String sitoWebText = sitoWeb.getText().trim();
        String noteText = note.getText().trim();
        Image img= immagine.getImage();

        // Controlli sui campi inseriti dall'utente nella fase di creazione
        if (!controllaCampiObbligatori (nomeText,cognomeText)){
            mostraDialog ( Alert.AlertType.ERROR,"Errore di validazione", "Devi inserire almeno un nome o un cognome.");
            return; // Interrompe l'esecuzione in caso di errore
        }
        if(!controllaTelefono(telefonoText)){
            mostraDialog ( Alert.AlertType.ERROR, "Telefono non valido!", "Il numero di telefono 1 inserito non é valido!" );
            return;
        } else if (!controllaTelefono (telefono2Text )){
            mostraDialog ( Alert.AlertType.ERROR, "Telefono non valido!", "Il numero di telefono 2 inserito non é valido!" );
            return;
        } else if (!controllaTelefono ( telefono3Text )){
            mostraDialog ( Alert.AlertType.ERROR, "Telefono non valido!", "Il numero di telefono 3 inserito non é valido!" );
            return;
        }
        if(!controllaEmail(emailText)){
            mostraDialog ( Alert.AlertType.ERROR, "Email non valida!", "L'indirizzo email 1 inserito non é valido!" );
            return;
        } else if(!controllaEmail(email2Text)) {
            mostraDialog ( Alert.AlertType.ERROR, "Email non valida!", "L'indirizzo email 2 inserito non é valido!" );
            return;
        } else if(!controllaEmail(email3Text)) {
            mostraDialog ( Alert.AlertType.ERROR, "Email non valida!", "L'indirizzo email 3 inserito non é valido!" );
            return;
        }
        
    
        // Crea il nuovo contatto
        ContattoEsteso temp = new ContattoEsteso(nomeText, cognomeText, telefonoText, telefono2Text, telefono3Text, emailText, email2Text, email3Text, compleannoText, indirizzoText, sitoWebText, noteText, false, false, img);

        // Se il contatto puó essere aggiunto alla mappa, allora aggiungilo anche alla lista
        if(this.getRubrica().aggiungiContattoEVerifica(temp))
            this.getListaContatti().add(temp);
        else
            mostraDialog( Alert.AlertType.ERROR,"Contatto Duplicato!", "Il contatto che si sta cercando di aggiungere é giá presente in rubrica!");

        System.out.println("\n"+ getClass() + " - handleAggiungiContatto ***\n");
        System.out.println("tempID = " + temp.getId());
        System.out.println("\n****RUBRICA***\n" + this.getRubrica().toString());
        System.out.println("\n***LISTA CONTATTI***\n" + this.getListaContatti().toString());

        // Chiudi la finestra
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

}
