package it.unisa.diem.swe.group07.rubrica.controllers;

import java.awt.*;
import java.io.File;
import java.net.URI;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import it.unisa.diem.swe.group07.rubrica.gestoreIO.Export;
import javafx.beans.binding.Bindings;
import javafx.scene.control.*;
import it.unisa.diem.swe.group07.rubrica.models.ContattoEsteso;
import it.unisa.diem.swe.group07.rubrica.models.Rubrica;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.collections.transformation.FilteredList;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
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

public class RubricaController extends AbstractController implements Initializable{

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
    /**
     * @brief Menu Item per aggiunta e rimozione dei contatti d'emergenza
     */
    @FXML
    private MenuItem emergenzaBtn;
    /**
     * @brief Menu Item per aggiunta e rimozione dei preferiti
     */
    @FXML
    private MenuItem preferitiBtn;
   
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
    /**
     * @brief label di aggiungi/rimuovi ai preferiti
     */
    @FXML
    private Label favoritesBtn;


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
    /**
     * @brief SplitPane
     */
    @FXML
    private SplitPane splitPane;

    /**
     * @brief pulsante preferiti
     */
    @FXML
    private Button preferitiFlag;

    /**
     * @brief pulsante emergenze
     */
    @FXML
    private Button emergenzaFlag;

    /**
     * @brief pulsante cancellazione contatto
     */
    @FXML
    private MenuItem del;

    /**
     * @brief pulsante che consente di mostrare la rubrica "Emergenze"
     */
    @FXML
    private MenuItem showEmergenza;

    /**
     * @brief pulsante per mostrare la rubrica
     */
    @FXML
    private MenuItem showRubrica;

    /**
     * @brief pulsante per modificare un contatto
     */
    @FXML
    private MenuItem editBtn;

    /**
     * @brief pulsante di aiuto
     */
    @FXML
    private MenuItem helpBtn;

     /**
     * @brief pulsante di export
     */
    @FXML
    private MenuItem exportBtn;
    
     /**
     * @brief pulsante di import
     */
    @FXML
    private MenuItem importBtn;

    // Attributi
    /**
     * @brief Contatto selelzionato nella Table View
     */
    private ContattoEsteso contattoSelezionato;
    /**
     * @brief Lista Filtrata di contatti per la ricerca
     */
    private FilteredList<ContattoEsteso> filteredContatti;
    /**
     * @brief Lista Filtrata di contatti per la sotto-rubrica:preferiti
     */
    private FilteredList<ContattoEsteso> contattiFiltratiPreferiti;
    /**
     * @brief Lista Filtrata di contatti per la otto-rubrica:contatti d'emergenza
     */
    private FilteredList<ContattoEsteso> contattiFiltratiEmergenza;
    
    /**
     * @brief Metodo di inizializzazione della vista e dei dati.
     *        Imposta la lista dei contatti, la configurazione delle colonne della TableView e i listener per le interazioni dell'utente.
     * @param url URL per il caricamento della vista.
     * @param rb ResourceBundle per il caricamento delle risorse.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb){
        this.getRubrica().aggiungiContattoEVerifica(new ContattoEsteso("Emanuele", "Tocci","+3933333333","+3933333333", "+3933333333", "prova@gmail.com", "prova@icloud.com", "prova@unisa.it", LocalDate.of(2020, 12, 12), "via Prova", "unisa.it", "informazioni aggiuntive" , false, false));
        this.getRubrica().aggiungiContattoEVerifica(new ContattoEsteso("Claudia", "Montefusco","+3933333333","+3933333333", "+3933333333", "prova@gmail.com", "prova@icloud.com", "prova@unisa.it", LocalDate.of(2020, 12, 12), "via Prova", "unisa.it", "informazioni aggiuntive", false, false));
        this.getRubrica().aggiungiContattoEVerifica(new ContattoEsteso("Alessio", "Leo","+3933333333","+3933333333", "+3933333333", "prova@gmail.com", "prova@icloud.com", "prova@unisa.it", LocalDate.of(2020, 12, 12), "via Prova", "unisa.it", "informazioni aggiuntive", false, false));
        this.getRubrica().aggiungiContattoEVerifica(new ContattoEsteso("Rossella", "Pale","+3933333333","+3933333333", "+3933333333", "prova@gmail.com", "prova@icloud.com", "prova@unisa.it", LocalDate.of(2020, 12, 12), "via Prova", "unisa.it", "informazioni aggiuntive", true, false));

        // Inserire qui funzione Import/autoImport e rimuovere le aggiunte manuali dei contatti presenti sopra

        // La lista osservabile é inizializzata a partire dagli elementi presenti nella rubrica
        this.getListaContatti().addAll(this.getRubrica().getContatti());

        // TEST - eliminare in seguito
        System.out.println("\n"+ getClass() + " - initialize ***\n");
        System.out.println("\n****RUBRICA***\n" + this.getRubrica().toString());
        System.out.println("\n***LISTA CONTATTI***\n" + this.getListaContatti().toString());
        // FINE TEST - eliminare in seguito

        nomeClm.setResizable(false);
        cognomeClm.setResizable(false);

        nomeClm.setCellValueFactory(s -> { return new SimpleStringProperty(s.getValue().getNome());  });
        cognomeClm.setCellValueFactory(s -> { return new SimpleStringProperty(s.getValue().getCognome());  });
        rubricaTable.setItems(this.getListaContatti());

        // Listener per la selezione di un contatto
        rubricaTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                mostraDettaglioContatti(newValue);
            }
        });

        setEditableAll(false);
        pulsanteSalva.setDisable(true);

        // Collegamento della lista filtrata alla TableView
        filteredContatti = new FilteredList<>(this.getListaContatti(), p -> true);
        rubricaTable.setItems(filteredContatti);
        // Listener sulla barra di ricerca
        pulsanteCerca.textProperty().addListener((observable, oldValue, newValue) -> {
            filtraContatti(newValue);
        });
    }

    /**
     * @brief Gestore delle'evento 'Nuovo Contatto'. Il metodo carica la vista alternativa che consente la creazione del contatto e passa il controllo al "CreaContattoController", il controller che consente la creazione del contatto
     * @param event L'evento generato dal click sul pulsante "Nuovo Contatto"
     */

    @FXML
    public void handleNuovoContatto(ActionEvent event) {
        try {
            // Carica il file FXML della nuova view
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CreazioneContattoView.fxml"));
            Parent root = loader.load();
            // Ottieni il controller della nuova view
            CreaContattoController controllerCreazione = loader.getController();
            controllerCreazione.setListaContatti(this.getListaContatti());
            controllerCreazione.setRubrica(this.getRubrica());

            // Solite robe per lo stage/scene
            Stage nuovoStage = new Stage();
            nuovoStage.setScene(new Scene(root));
            nuovoStage.setTitle("Nuovo Contatto");
            nuovoStage.initModality(Modality.APPLICATION_MODAL);
            nuovoStage.setResizable(false);
            // Mostra la finestra e attende
            nuovoStage.showAndWait();
            // Aggiorna tableView con i nuovi dati
            rubricaTable.setItems(this.getListaContatti());
            System.out.println("\n"+ getClass() + " - handleCreaConttato ***\n");
            System.out.println("\n****RUBRICA***\n" + this.getRubrica().toString());
            System.out.println("\n***LISTA CONTATTI***\n" + this.getListaContatti().toString());
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
         if((c != null) || (c.trim().isEmpty())){
            String lowerCaseQuery = c.toLowerCase(); // Converte la query in minuscolo per rendere la ricerca case-insensitive

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
        noteField.setText(contatto.getNote());

        preferitiFlag.opacityProperty().bind(Bindings.when(contattoSelezionato.isPreferito())
                .then(1.0) // Opacità al 100% quando isPreferiti è true
                .otherwise(0.5)); // Opacità al 50% quando isPreferiti è false
        emergenzaFlag.opacityProperty().bind(Bindings.when(contattoSelezionato.isEmergenza())
                .then(1.0) // Opacità al 100% quando isPreferiti è true
                .otherwise(0.5)); // Opacità al 50% quando isPreferiti è false
        //imgcontatto.setImage(contatto.getImmagineProfilo());



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
        compleannoField.setEditable(isEditable);
        
}
    /**
     * @brief Elimina un contatto selezionato dalla rubrica.
     * @param event L'evento generato dal click sul pulsante di eliminazione.
     */
    @FXML
    public void handleEliminaContatto(ActionEvent event) {
    ContattoEsteso c = rubricaTable.getSelectionModel().getSelectedItem();  //seleziona il contatto dalla TableView
        if (c!=null){
            // Se il contatto puó essere rimosso dalla rubrica allora rifletti le modifiche sulla lista
            if(this.getRubrica().rimuoviContatto(c) != null){
                this.getListaContatti().remove(c);
                mostraDialog ( Alert.AlertType.INFORMATION, "Rimozione Contatto", "Contatto rimosso correttamente" );
            } else mostraDialog ( Alert.AlertType.ERROR, "Errore Rimozione Contatto", "Si é verificato un errore durante la rimozione del contatto!" );
            // Aggiorna la TableView (opzionale, perché ObservableList lo fa automaticamente)
            rubricaTable.refresh();

            // TEST - rimuovere in seguito
            System.out.println("\n"+ getClass() + " - handleEliminaContatto ***\n");
            System.out.println("\n****RUBRICA***\n" + this.getRubrica().toString());
            System.out.println("\n***LISTA CONTATTI***\n" + this.getListaContatti().toString());
            // FINE TEST - rimuovere in seguito
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
    public void handleModificaContatto(ActionEvent event) {
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
    private void gestioneSalvaModifiche(ActionEvent e){
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
            //contattoSelezionato.setSitoWeb(.getText());
            contattoSelezionato.setNote(noteField.getText());

            //TEST - rimuovere in seguito
            System.out.println("\n"+ getClass() + " - gestioneSalvaModifiche ***\n");
            System.out.println("\n****RUBRICA***\n" + this.getRubrica().toString());
            System.out.println("\n***LISTA CONTATTI***\n" + this.getListaContatti().toString());
            // FINE TEST

            // Se il contatto selezionato puó essere aggiornato dalla rubrica (Map), allora aggiorna la TableView
            if(this.getRubrica().aggiornaContatto(contattoSelezionato)) {
                // Aggiorna la TableView e disabilita i TextField
                rubricaTable.refresh(); //la tableView si aggiorna automaticamente!
                mostraDialog (Alert.AlertType.INFORMATION, "Salvataggio Modifiche", "Il contatto selezionato é stato correttamente aggiornato" );
                pulsanteSalva.setDisable(true);
                setEditableAll(false);
            } else mostraDialog ( Alert.AlertType.ERROR, "Errore salvataggio modifiche", "Si é verificato un errore durante la modifica del contatto" );
    }

    /**
     * @brief metodo per collegare a rubrica table la vista di tutta la rubrica
     */
    @FXML
    private void showRubrica(){
        rubricaTable.setItems(this.getListaContatti());
    }
    /**
     * @brief metodo per collegare a rubrica table la vista della sotto-rubrica: preferiti
     */
    @FXML
    private void showPreferiti(){
        contattiFiltratiPreferiti = new FilteredList<>(this.getListaContatti(), contatto -> contatto.getPreferito());
        rubricaTable.setItems(contattiFiltratiPreferiti);
    }
    /**
     * @brief metodo per collegare a rubrica table la vista della sotto-rubrica: contatti d'emergenza
     */
    @FXML
    private void showEmergenza(){
        contattiFiltratiEmergenza = new FilteredList<>(this.getListaContatti(), contatto -> contatto.getEmergenza());
        rubricaTable.setItems(contattiFiltratiEmergenza);
    }
    /**
     * @brief metodo per aggiungere e rimuovere alla sotto-rubrica preferiti il contatto selezionato
     */
    @FXML
    private void toggleEmergenza(){
        ContattoEsteso c = rubricaTable.getSelectionModel().getSelectedItem();
        if (c != null) {
            c.setEmergenza(!c.getEmergenza());
            rubricaTable.refresh();
        }
    }
    /**
     * @brief metodo per rimuovere dalla sotto-rubrica preferiti il contatto selezionato
     */
    @FXML
    private void togglePreferiti() {
        ContattoEsteso c = rubricaTable.getSelectionModel().getSelectedItem();
        if (c != null) {
            c.setPreferito(!c.getPreferito());
            rubricaTable.refresh();
        }
    }
    /**
     * @brief metodo per aprire la web page utilizzando l'URL specificato
     * @param urlString url della web page da aprire
     */
    private static void openWebpage(String urlString) {
        try {
            Desktop desktop = Desktop.getDesktop();
            desktop.browse(new URL(urlString).toURI());
        } catch (Exception e) {
            System.err.println("Errore durante l'apertura del link.");
            e.printStackTrace();
        }
    }
    /**
     * @brief metodo per aprire la repository Git del progetto in una pagina web
     */
    @FXML
    private void openGit(){
        openWebpage("https://github.com/emanueletocci/uni-swe-project");
    }
    
    /**
     * @brief metodo per l'export della Rubrica in un file .vcf
     */
    @FXML
    private void exportRubrica(){
        Export e=new Export();
        e.esportaRubrica(this.getRubrica());
        mostraDialog( Alert.AlertType.INFORMATION,
                "Export completato",
                "La rubrica è stata esportato con successo\n\noutput: "
                        + System.getProperty("user.dir")
                        + File.separator
                        + "RubricaExport"
                        + ".vcf");
    }
    
    /**
     * @brief metodo per l'export del contatto selezionato in un file .vcf
     */
    @FXML
    public void exportContatto(){
        Export e=new Export();
        ContattoEsteso c=rubricaTable.getSelectionModel().getSelectedItem();
        e.esportaContatto(c);
        mostraDialog(Alert.AlertType.INFORMATION,
                "Export completato",
                "Il contatto è stato esportato con successo\noutput: "
                        + System.getProperty("user.dir")
                        + File.separator
                        + c.getNome()
                        + ".vcf");
    }

    /*
    @FXML
    public void importRubrica() {
        
    }*/
}
