/**
 * @file AbstractController.java
 * @brief Il file contiene l'implementazione di un controller astratto che contiene il riferimento alla rubrica e alla lista osservabile. Il controller predispone
 * alcuni metodi pubblici (mutator e 'mostraDialog'), direttamente accessibili dalle sottoclassi
 * @autor Gruppo07
 * @date Dicembre, 2024
 */

package it.unisa.diem.swe.group07.rubrica.controllers;
import it.unisa.diem.swe.group07.rubrica.models.ContattoEsteso;
import it.unisa.diem.swe.group07.rubrica.models.Rubrica;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

public abstract class AbstractController {

    /**
     * @brief istanza della rubrica (Map).
     */
    private Rubrica rubrica = new Rubrica();

    /**
     * @brief istanza della lista osservabile.
     */
    private ObservableList<ContattoEsteso> listaContatti = FXCollections.observableArrayList();

     /**
     * @brief metodo getter dell'attributo rubrica.
     * @return rubrica, Attributo rubrica.
     */
    public Rubrica getRubrica() {
        return rubrica;
    }

    /**
     * @brief metodo setter dell'attributo rubrica.
     * @param[in] rubrica, Attributo rubrica.
     */
    public void setRubrica(Rubrica rubrica) {
        this.rubrica = rubrica;
    }

     /**
     * @brief metodo getter della struttura (lista osservabile).
     * @return listaContatti, La lista osservabile contenente i contatti.
     */ 
    public ObservableList<ContattoEsteso> getListaContatti() {
        return listaContatti;
    }

    /**
     * @brief metodo setter della lista osservabile 
     * @param[in] listaContatti, La lista osservabile contenente i contatti
     */
    public void setListaContatti(ObservableList<ContattoEsteso> listaContatti) {
        this.listaContatti = listaContatti;
    }

    /**
     * @brief metodo che consenti di mostrare un generico dialog.
     * @param[in] type, Tipo di Alert.
     * @param[in] titolo, Titolo della finestra (dialog).
     * @param[in] messaggio, Messaggio da mostrare nella finestra.
     */
    public void mostraDialog(Alert.AlertType type, String titolo, String messaggio) {
        Alert alert = new Alert(type);
        alert.setTitle(titolo);
        alert.setContentText(messaggio);
        alert.showAndWait();
    }
    /**
     * @brief metodo verificare che almeno un TextField tra nome e cognome è stato sovrascritto.
     */
    protected Boolean controllaCampiObbligatori(String nome, String cognome) {
        // Verifica che almeno uno tra nome o cognome sia valido
        return (nome != null && !nome.trim().isEmpty()) || (cognome != null && !cognome.trim().isEmpty());    }

    /**
     * @brief metodo per la verifica del numero telefonico del contatto.
     * @param[in] telefono, Stringa contenente un numero telefonico.
     * @return "true" se il numero inserito é valido, "false" altrimenti.
     */
    protected Boolean controllaTelefono(String telefono){
        if(telefono.trim().matches("^\\+?[0-9]{6,15}$") || telefono.trim().isEmpty ())
            return true;
        return false;
        //regex: ^ inizio stringa, \\+ rappresenta il simbolo + (il primo backslash é per escape), ? indica che il simbolo precedente (+) é opzionale, [0-9]{6,15} si possono inserire da 6 a 15 cifre numeriche, $ fine della stringa
    }

    /**
     * @brief metodo per la verifica dell'indirizzo email del contatto. Il metodo verifica solamente la presenta della "@" all'interno dell´email inserita.
     * @param[in] email, Stringa contenente un indirizzo email.
     * @return "true" se l'email inserita é valida (contiene @), "false" altrimenti.
     */
    protected Boolean controllaEmail(String email) {
        /*
         * https://www.baeldung.com/java-email-validation-regex
         * regex: ^ inizio stringa, (.+) sequenza di uno o piú caratteri qualunque (tranne newLine) che precedono la "@", (\\S+) sequenza di caratteri qualsiasi escluso lo spazio, $ fine della stringa
         */
        if (email.matches ( "^(.+)@(\\S+)$" ) || email.isEmpty ())
            return true;
        return false;
    }
}