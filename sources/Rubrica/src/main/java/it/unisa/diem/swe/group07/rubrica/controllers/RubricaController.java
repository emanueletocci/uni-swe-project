package it.unisa.diem.swe.group07.rubrica.controllers;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.scene.control.*;
import it.unisa.diem.swe.group07.rubrica.models.ContattoEsteso;
import it.unisa.diem.swe.group07.rubrica.models.Rubrica;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.collections.transformation.FilteredList;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * @file MainController.java
 * @brief questo file contiene l'implementazione del Controller principale per la gestione della rubrica telefonica.
 *        questa classe gestisce l'interazione tra l'utente e il modello di dati della rubrica.
 * @autor Gruppo07
 * @date Dicembre, 2024
 * @version 1.0
 */

public class RubricaController implements Initializable{

    // TextFields
     /**
     * @brief Text Field per il nome del contatto nella Rubrica
     */
    @FXML // fx:id="nomeField"
    private TextField nomeField; // Value injected by FXMLLoader
    /**
     * @brief Text Field per il cognome del contatto nella Rubrica
     */
    @FXML // fx:id="cognomeField"
    private TextField cognomeField; // Value injected by FXMLLoader
        /**
     * @brief Text Field per il telefono del contatto nella Rubrica
     */
    @FXML // fx:id="telefono1Field"
    private TextField telefono1Field; // Value injected by FXMLLoader
        /**
     * @brief Text Field per il telefono2 del contatto nella Rubrica
     */
    @FXML // fx:id="telefono2Field"
    private TextField telefono2Field; // Value injected by FXMLLoader
        /**
     * @brief Text Field per il telefono3 del contatto nella Rubrica
     */
    @FXML // fx:id="telefono3Field"
    private TextField telefono3Field; // Value injected by FXMLLoader
        /**
     * @brief Text Field per l'email del contatto nella Rubrica
     */
    @FXML // fx:id="email1Field"
    private TextField email1Field; // Value injected by FXMLLoader
        /**
     * @brief Text Field per l'email2 del contatto nella Rubrica
     */
    @FXML // fx:id="email2Field"
    private TextField email2Field; // Value injected by FXMLLoader
        /**
     * @brief Text Field per l'email3 del contatto nella Rubrica
     */
    @FXML // fx:id="email3Field"
    private TextField email3Field; // Value injected by FXMLLoader
        /**
     * @brief Text Field per il compleanno del contatto nella Rubrica
     */
    @FXML // fx:id="compleannoField"
    private DatePicker compleannoField; // Value injected by FXMLLoader
        /**
     * @brief Text Field per l'indirizzo del contatto nella Rubrica
     */
    @FXML // fx:id="indirizzoField"
    private TextField indirizzoField; // Value injected by FXMLLoader
        /**
     * @brief Text Field per le note nella Rubrica
     */
    @FXML // fx:id="noteField"
    private TextField noteField; // Value injected by FXMLLoader
    
   
//    @FXML // fx:id="sitoWebField" Se si rimuove il commento non si avvia lol
//    private TextField sitoField; // Value injected by FXMLLoader

    // Buttons
    
     /**
     * @brief bottone per cercare un Contatto nella Rubrica
     */
    @FXML // fx:id="pulsanteCerca"
    private TextField pulsanteCerca; // Value injected by FXMLLoader
      /**
     * @brief bottone per creare un Contatto nella Rubrica
     */
    @FXML // fx:id="pulsanteCrea"
    private Button pulsanteCrea; // Value injected by FXMLLoader
     /**
     * @brief bottone per eliminare un Contatto nella Rubrica
     */
    @FXML // fx:id="pulsanteElimina"
    private Button pulsanteElimina; // Value injected by FXMLLoader
    /**
     * @brief bottone per modificare un Contatto nella Rubrica
     */
    @FXML // fx:id="pulsanteModifica"
    private Button pulsanteModifica; // Value injected by FXMLLoader
      /**
     * @brief bottone per salvare un Contatto nella Rubrica
     */
     @FXML
    private Button pulsanteSalva;


    // Altri componenti FXML
     /**
     * @brief Colonna per il cognome del contatto nella TableView.
     */
    @FXML // fx:id="cognomeClm"
    private TableColumn<ContattoEsteso, String> cognomeClm; // Value injected by FXMLLoader
     /**
     * @brief etichetta per visualizzare il nome completo del contatto
     */
    @FXML // fx:id="fullname"
    private Label fullname; // Value injected by FXMLLoader
      /**
     * @brief immagine per il contatto selezionato
     */
    @FXML // fx:id="imgcontatto"
    private ImageView imgcontatto; // Value injected by FXMLLoader
      /**
     * @brief colonna per il nome del contatto nella TableView
     */
    @FXML // fx:id="nomeClm"
    private TableColumn<ContattoEsteso, String> nomeClm; // Value injected by FXMLLoader
      /**
     * @brief Table View che mostra la lista dei contatti
     */
    @FXML // fx:id="rubricaTable"
    private TableView<ContattoEsteso> rubricaTable; // Value injected by FXMLLoader
    

    // Attributi
        /**
     * @brief Lista osservabile dei contatti da visualizzare nella TableView.
     */
    private ObservableList<ContattoEsteso> listaContatti;
        /**
     * @brief oggetto Rubrica
     */
    private Rubrica rubrica;
        /**
     * @brief Contatto selelzionato nella Table View
     */
    private ContattoEsteso contattoSelezionato;
        /**
     * @brief Lista Filtrata di contatti per la ricerca
     */
    private FilteredList<ContattoEsteso> filteredContatti;
    
    /**
     * @brief Metodo di inizializzazione della vista e dei dati.
     *        Imposta la lista dei contatti, la configurazione delle colonne della TableView e i listener per le interazioni dell'utente.
     * @param url URL per il caricamento della vista.
     * @param rb ResourceBundle per il caricamento delle risorse.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb){
        rubrica = new Rubrica();
        rubrica.aggiungiContatto(new ContattoEsteso("Emanuele", "Tocci","+3933333333","+3933333333", "+3933333333", "prova@gmail.com", "prova@icloud.com", "prova@unisa.it", LocalDate.of(2020, 12, 12), "via Prova", "unisa.it", "informazioni aggiuntive"));
        rubrica.aggiungiContatto(new ContattoEsteso("Claudia", "Montefusco","+3933333333","+3933333333", "+3933333333", "prova@gmail.com", "prova@icloud.com", "prova@unisa.it", LocalDate.of(2020, 12, 12), "via Prova", "unisa.it", "informazioni aggiuntive"));
        rubrica.aggiungiContatto(new ContattoEsteso("Alessio", "Leo","+3933333333","+3933333333", "+3933333333", "prova@gmail.com", "prova@icloud.com", "prova@unisa.it", LocalDate.of(2020, 12, 12), "via Prova", "unisa.it", "informazioni aggiuntive"));
        rubrica.aggiungiContatto(new ContattoEsteso("Rossella", "Pale","+3933333333","+3933333333", "+3933333333", "prova@gmail.com", "prova@icloud.com", "prova@unisa.it", LocalDate.of(2020, 12, 12), "via Prova", "unisa.it", "informazioni aggiuntive"));
        
        // Inserire qui funzione Import/autoImport e rimuovere le aggiunte manuali dei contatti presenti sopra

        // La lista osservabile é inizializzata a partire dagli elementi presenti nella rubrica
        listaContatti = FXCollections.observableArrayList(rubrica.getContatti());

        nomeClm.setCellValueFactory(s -> { return new SimpleStringProperty(s.getValue().getNome());  });
        cognomeClm.setCellValueFactory(s -> { return new SimpleStringProperty(s.getValue().getCognome());  });
        rubricaTable.setItems(listaContatti);

        // Listener per la selezione di un contatto
        rubricaTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                mostraDettaglioContatti(newValue);
            }
        });
        
      setEditableAll(false);
      pulsanteSalva.setDisable(true);
      
      // Collegamento della lista filtrata alla TableView
        filteredContatti = new FilteredList<>(listaContatti, p -> true);
        rubricaTable.setItems(filteredContatti);
        // Listener sulla barra di ricerca
        pulsanteCerca.textProperty().addListener((observable, oldValue, newValue) -> { 
            filtraContatti(newValue);
        });
    }

    /**
     * @brief Crea un nuovo contatto e aggiorna la TableView con i nuovi contatti.
     * @param event L'evento generato dal click sul pulsante di creazione.
     */

    @FXML
    public void creaContatto(ActionEvent event) {
        try {
            // Carica il file FXML della nuova view
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CreazioneContattoView.fxml"));
            Parent root = loader.load();
            // Ottieni il controller della nuova view
            CreaContattoController controllerCreazione = loader.getController();
            controllerCreazione.setListaContatti(listaContatti);
            // Solite robe per lo stage/scene
            Stage nuovoStage = new Stage();
            nuovoStage.setScene(new Scene(root));
            nuovoStage.setTitle("Crea Nuovo Contatto");
            nuovoStage.initModality(Modality.APPLICATION_MODAL);
            // Mostra la finestra e attende
            nuovoStage.showAndWait();
            // Aggiorna tableView con i nuovi dati
            rubricaTable.setItems(FXCollections.observableArrayList(listaContatti));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @brief Metodo per filtrare i contatti in base al nome o al cognome.
     * @param c Stringa di ricerca.
     */

    //metodo per la ricerca del contatto
     private void filtraContatti(String c) {
        if (c == null || c.trim().isEmpty()) {
            // Se la query è vuota, mostra tutti i contatti
            filteredContatti.setPredicate(p -> true);
        } else {
            // Converti la query in minuscolo per rendere la ricerca case-insensitive
            String lowerCaseQuery = c.toLowerCase();

            // Filtra i contatti per nome o cognome
            filteredContatti.setPredicate(contatto -> {
                boolean matchesNome = contatto.getNome() != null && contatto.getNome().toLowerCase().contains(lowerCaseQuery);
                boolean matchesCognome = contatto.getCognome() != null && contatto.getCognome().toLowerCase().contains(lowerCaseQuery);
                return matchesNome || matchesCognome;
            });
        }
    }
     /**
     * @brief Metodo per mostrare i dettagli di un contatto selezionato nella rubrica.
     * @param contatto Il contatto selezionato da visualizzare.
     */ 
    private void mostraDettaglioContatti(ContattoEsteso contatto){
        this.contattoSelezionato=contatto;
        nomeField.setText(contatto.getNome());
        cognomeField.setText(contatto.getCognome());
        email1Field.setText(contatto.getEmail1());
        email2Field.setText(contatto.getEmail2());
        email3Field.setText(contatto.getEmail3());
        telefono1Field.setText(contatto.getTelefono1());
        telefono2Field.setText(contatto.getTelefono2());
        telefono3Field.setText(contatto.getTelefono3());
        indirizzoField.setText(contatto.getIndirizzoResidenza());
        compleannoField.setValue(contatto.getCompleanno());
        noteField.setText(contatto.getNote());//setText(contatto.getCompleanno());

}
     /**
     * @brief Imposta se tutti i campi di testo sono editabili o meno.
     * @param isEditable Se true, i campi di testo sono resi editabili; se false, sono resi non editabili.
     */   
private void setEditableAll(boolean isEditable) {
        nomeField.setEditable(isEditable);
        cognomeField.setEditable(isEditable);
        email1Field.setEditable(isEditable);
        email2Field.setEditable(isEditable);
        email3Field.setEditable(isEditable);
        telefono1Field.setEditable(isEditable);
        telefono2Field.setEditable(isEditable);
        telefono3Field.setEditable(isEditable);
        indirizzoField.setEditable(isEditable);
        compleannoField.setEditable(isEditable);
        noteField.setEditable(isEditable);
}
    /**
     * @brief Elimina un contatto selezionato dalla rubrica.
     * @param event L'evento generato dal click sul pulsante di eliminazione.
     */
    @FXML
    public void eliminaContatto(ActionEvent event) {
    ContattoEsteso c = rubricaTable.getSelectionModel().getSelectedItem();
        if (c!=null){
            rubrica.rimuoviContatto(c);
             // Rimuovi il contatto dalla lista osservabile
            listaContatti.remove(c);;
             // Aggiorna la TableView (opzionale, perché ObservableList lo fa automaticamente)
            rubricaTable.refresh();
        }
    }

    /**
     * @brief Abilita i campi di testo per la modifica di un contatto selezionato.
     * @param event L'evento generato dal click sul pulsante di modifica.
     */
    //quando clicco sul pulsante modifica devo far in modo che i campi
    //siano modificabili
    //e che il pulsante crea debba funzionare
    @FXML
    public void modificaContatto(ActionEvent event) {
            if (contattoSelezionato != null) {
            setEditableAll(true);
            //pulsanteCrea.setDisable(false);
            pulsanteSalva.setDisable(false);//AGGIUNGI PULSANTE SALVA

        }
            
    }

        /**
     * @brief Gestisce il salvataggio delle modifiche apportate a un contatto esistente.
     * @param e L'evento generato dal click sul pulsante di salvataggio.
     */
        @FXML
    private void GestioneSalvaModifiche(ActionEvent e){
            // Aggiorna i dati del contatto selezionato
            contattoSelezionato.setNome(nomeField.getText());
            contattoSelezionato.setCognome(cognomeField.getText());
            contattoSelezionato.setEmail1(email1Field.getText());
            contattoSelezionato.setEmail2(email2Field.getText());
            contattoSelezionato.setTelefono3(telefono1Field.getText());
            contattoSelezionato.setTelefono1(telefono2Field.getText());
            contattoSelezionato.setTelefono2(telefono2Field.getText());
            contattoSelezionato.setCompleanno(compleannoField.getValue());
            contattoSelezionato.setIndirizzoResidenza(indirizzoField.getText());
            contattoSelezionato.setNote(noteField.getText());
            //contattoSelezionato.setSitoWeb(socialField.getText());
            contattoSelezionato.setNote(noteField.getText());
            rubrica.aggiornaContatto(contattoSelezionato);
            // Aggiorna la TableView e disabilita i TextField
            rubricaTable.refresh();

            pulsanteSalva.setDisable(true);
            setEditableAll(false);
    }
}
