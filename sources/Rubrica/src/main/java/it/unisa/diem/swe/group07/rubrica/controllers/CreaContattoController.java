/**
 * @file CreaContattoController.java
 * @brief Il file contiene l'implementazione del controller per la creazione di un nuovo contatto e l'aggiunta alla rubrica.
 * @autor Gruppo07
 * @date Dicembre, 2024
 */
package it.unisa.diem.swe.group07.rubrica.controllers;
import it.unisa.diem.swe.group07.rubrica.models.ContattoEsteso;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import java.time.LocalDate;

public class CreaContattoController extends AbstractController{
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
     * @brief Il metodo preleva i valori dai Text Field, crea un contatto temporaneo e, se i valori inseriti dall'utente sono validi, lo aggiunge alla rubrica (e alla lista osservabile,
     * di conseguenza aggiorna la TableView).
     * @param[in] event evento generato dal click sul pulsante "Crea Contatto".
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
        ContattoEsteso temp = new ContattoEsteso(nomeText, cognomeText, telefonoText, telefono2Text, telefono3Text, emailText, email2Text, email3Text, compleannoText, indirizzoText, sitoWebText, noteText, false, false);

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
