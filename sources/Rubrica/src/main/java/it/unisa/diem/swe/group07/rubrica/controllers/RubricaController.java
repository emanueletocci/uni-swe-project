/**
 * @file RubricaController.java
 * @brief questo file contiene l'implementazione del Controller principale per la gestione della rubrica telefonica.
 * @author Gruppo07
 * @date Dicembre, 2024
 */

package it.unisa.diem.swe.group07.rubrica.controllers;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import it.unisa.diem.swe.group07.rubrica.gestoreIO.Export;
import it.unisa.diem.swe.group07.rubrica.gestoreIO.Import;
import it.unisa.diem.swe.group07.rubrica.models.Contatto;
import it.unisa.diem.swe.group07.rubrica.models.Rubrica;
import javafx.beans.binding.Bindings;
import javafx.scene.control.*;
import it.unisa.diem.swe.group07.rubrica.models.ContattoEsteso;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.collections.transformation.FilteredList;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * @brief La classe rappresenta il controllore responsabile della gestione della vista principale.
 * @see Rubrica
 * @see CreaContattoController
 * @see GenericController
 */

public class RubricaController extends GenericController implements Initializable{
     /**
     * @brief Text Field per il nome del contatto nella Rubrica.
     */
    @FXML
    private TextField nomeField;
    /**
     * @brief Text Field per il cognome del contatto nella Rubrica.
     */
    @FXML
    private TextField cognomeField;
    /**
     * @brief Text Field per il telefono del contatto nella Rubrica.
     */
    @FXML
    private TextField telefono1Field;
    /**
     * @brief Text Field per il telefono2 del contatto nella Rubrica.
     */
    @FXML
    private TextField telefono2Field;
    /**
     * @brief Text Field per il telefono3 del contatto nella Rubrica.
     */
    @FXML
    private TextField telefono3Field;
    /**
     * @brief Text Field per l'email del contatto nella Rubrica.
     */
    @FXML
    private TextField email1Field;
    /**
     * @brief Text Field per l'email2 del contatto nella Rubrica.
     */
    @FXML
    private TextField email2Field;
    /**
     * @brief Text Field per l'email3 del contatto nella Rubrica.
     */
    @FXML
    private TextField email3Field;
    /**
     * @brief Text Field per il compleanno del contatto nella Rubrica.
     */
    @FXML
    private DatePicker compleannoField;
    /**
     * @brief Text Field per l'indirizzo del contatto nella Rubrica.
     */
    @FXML
    private TextField indirizzoField;
    /**
     * @brief Text Field per le note nella Rubrica.
     */
    @FXML
    private TextField noteField;
    /**
     * @brief Label "Contatti".
     */
    @FXML
    private Label contattiLabel;

     /**
     * @brief Barra di ricerca. Consente di cercare un contatto nella Rubrica.
     */
    @FXML
    private TextField barraRicerca;
    /**
     * @brief Pulsante che consente di salvare le modifiche apportate ad un contatto giá presente in rubrica.
     */
     @FXML
    private Button pulsanteSalva;
     /**
     * @brief Colonna per il cognome del contatto nella TableView.
     */
    @FXML
    private TableColumn<Contatto, String> cognomeClm;
     /**
     * @brief Label per visualizzare il nome completo del contatto.
     */
    @FXML
    private Label fullname;
    /**
     * @brief Colonna per il nome del contatto nella TableView.
     */
    @FXML
    private TableColumn<Contatto, String> nomeClm;
      /**
     * @brief TableView che mostra la lista dei contatti.
     */
    @FXML
    private TableView<Contatto> rubricaTable;
    /**
     * @brief Pulsante che consente di aggiungere e rimuovere un contatto dai "preferiti".
     */
    @FXML
    private Button preferitiFlag;
    /**
     * @brief Pulsante che consente di aggiungere e rimuovere un contatto dalle "emergenze".
     */
    @FXML
    private Button emergenzaFlag;
    /**
     * @brief Text Field per il sito web del contatto nella Rubrica.
     */
    @FXML
    private TextField linkField;

    /**
     * @brief Contatto selezionato nella Table View.
     */
    private Contatto contattoSelezionato;
    /**
     * @brief Lista Filtrata di contatti per la ricerca.
     */
    private FilteredList<Contatto> filteredContatti;
    /**
     * @brief Lista Filtrata di contatti per la sotto-rubrica:preferiti.
     */
    private FilteredList<Contatto> contattiFiltratiPreferiti;
    /**
     * @brief Lista Filtrata di contatti per la otto-rubrica:contatti d'emergenza.
     */
    private FilteredList<Contatto> contattiFiltratiEmergenza;

    /**
     * @brief Metodo di inizializzazione della vista e dei dati.
     *        Imposta la lista dei contatti, la configurazione delle colonne della TableView e i listener per le interazioni dell'utente.
     * @param[in] url, URL per il caricamento della vista.
     * @param[in] rb, ResourceBundle per il caricamento delle risorse.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb){

        // TEST
        System.out.println("\n"+ getClass() + " - initialize ***\n");
        System.out.println("\n****RUBRICA***\n" + this.getRubrica().toString());
        System.out.println("\n***LISTA CONTATTI***\n" + this.getListaContatti().toString());
        // FINE TEST

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

        // Listener sulla barra di ricerca
        barraRicerca.textProperty().addListener((observable, oldValue, newValue) -> {
            filtraContatti(newValue);
        });
    }

    /**
     * @brief Gestore delle'evento 'Nuovo Contatto'. Il metodo carica la vista alternativa che consente la creazione del contatto e passa il controllo al "CreaContattoController", il controller che consente la creazione del contatto.
     */
    @FXML
    public void handleNuovoContatto() {
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
     * @param[in] c, Stringa di ricerca.
     */
    //metodo per la ricerca del contatto
     private void filtraContatti(String c) {
         // Collegamento della lista filtrata alla TableView
         filteredContatti = new FilteredList<>(this.getListaContatti(), p -> true);
         rubricaTable.setItems(filteredContatti);
         if((c != null) || (c.trim().isEmpty())){
            String lowerCaseQuery = c.toLowerCase(); // Converte la query in minuscolo per rendere la ricerca case-insensitive

             // Filtra i contatti per nome o cognome
            filteredContatti.setPredicate(contatto -> {
                String nome="";
                String cognome="";
                if(contatto.getNome()!=null){
                    nome=contatto.getNome();
                }
                if(contatto.getCognome()!=null){
                    cognome=contatto.getCognome();
                }
                
                String nomecognome= nome + " "+cognome;
                boolean matchesNomecognome=nomecognome.toLowerCase().startsWith(lowerCaseQuery);
                String cognomenome= cognome+" "+nome;
                boolean matchesCognomenome=cognomenome.toLowerCase().startsWith(lowerCaseQuery);
                return matchesNomecognome||matchesCognomenome;
            });
        }
    }

     /**
     * @brief Metodo per mostrare i dettagli di un contatto selezionato nella rubrica.
     * @param[in] contatto, Il contatto selezionato da visualizzare.
     */ 
    private void mostraDettaglioContatti(Contatto contatto){
        this.contattoSelezionato=contatto;
        ContattoEsteso c = (ContattoEsteso) contatto;
        fullname.setText(c.getNome() + " " + contatto.getCognome());
        nomeField.setText(c.getNome());
        cognomeField.setText(c.getCognome());
        email1Field.setText(c.getEmail1());
        email2Field.setText(c.getEmail2());
        email3Field.setText(c.getEmail3());
        telefono1Field.setText(c.getTelefono1());
        telefono2Field.setText(c.getTelefono2());
        telefono3Field.setText(c.getTelefono3());
        linkField.setText(c.getSitoWeb());
        indirizzoField.setText(c.getIndirizzoResidenza());
        compleannoField.setValue(c.getCompleanno());
        noteField.setText(c.getNote());

        preferitiFlag.opacityProperty().bind(Bindings.when(contattoSelezionato.isPreferito())
                .then(1.0) // Opacità al 100% quando isPreferiti è true
                .otherwise(0.5)); // Opacità al 50% quando isPreferiti è false
        emergenzaFlag.opacityProperty().bind(Bindings.when(contattoSelezionato.isEmergenza())
                .then(1.0)
                .otherwise(0.5));
}
     /**
     * @brief Imposta se tutti i campi di testo sono editabili o meno.
     * @param[in] isEditable, Se 'true', i campi di testo sono resi editabili; se 'false', sono resi non editabili.
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
            linkField.setEditable(isEditable);
    }
    /**
     * @brief Gestore dell'evento relativo al click del pulsante "Elimina Contatto". Il metodo elimina un contatto dalla rubrica ed aggiorna
     * la TableView.
     */
    @FXML
    public void handleEliminaContatto() {
    Contatto c = rubricaTable.getSelectionModel().getSelectedItem();  //seleziona il contatto dalla TableView
        if (c!=null){
            // Se il contatto puó essere rimosso dalla rubrica allora rifletti le modifiche sulla lista
            if(this.getRubrica().rimuoviContatto(c) != null){
                this.getListaContatti().remove(c);
            } else mostraDialog ( Alert.AlertType.ERROR, "Errore Rimozione Contatto", "Si é verificato un errore durante la rimozione del contatto!" );
            // Aggiorna la TableView (opzionale, perché ObservableList lo fa automaticamente)
            rubricaTable.refresh();

            // TEST
            System.out.println("\n"+ getClass() + " - handleEliminaContatto ***\n");
            System.out.println("\n****RUBRICA***\n" + this.getRubrica().toString());
            System.out.println("\n***LISTA CONTATTI***\n" + this.getListaContatti().toString());
            // FINE TEST
        }
    }

    /**
     * @brief Gestore dell'evento relativo al click sul pulsante "Modifica". Abilita i campi di testo per la modifica di un contatto selezionato.
     */
    @FXML
    public void handleModificaContatto() {
        if (contattoSelezionato != null) {
            setEditableAll(true);
            //pulsanteCrea.setDisable(false);
            pulsanteSalva.setDisable(false);//AGGIUNGI PULSANTE SALVA
        }
    }

    /**
     * @brief Gestisce il salvataggio delle modifiche apportate a un contatto esistente, effettuando i controlli sui campi obbligatori (nome e cognome),
     * indirizzi email e numeri telefonici. Nel caso in cui uno dei controlli dovesse fallire, il metodo mostra un dialog di errore e non consente il
     * salvataggio del contatto modificato.
     *
     */
        @FXML
    private void gestioneSalvaModifiche(){
            ContattoEsteso c = (ContattoEsteso) contattoSelezionato;
            // Controlli sui campi inseriti dall'utente nella fase di creazione
            if (!controllaCampiObbligatori (nomeField.getText(),cognomeField.getText())){
                mostraDialog ( Alert.AlertType.ERROR,"Errore di validazione", "Devi inserire almeno un nome o un cognome.");
                return; // Interrompe l'esecuzione in caso di errore
            }
            if(!controllaTelefono(telefono1Field.getText())){
                mostraDialog ( Alert.AlertType.ERROR, "Telefono non valido!", "Il numero di telefono 1 inserito non é valido!" );
                return;
            } else if (!controllaTelefono (telefono2Field.getText() )){
                mostraDialog ( Alert.AlertType.ERROR, "Telefono non valido!", "Il numero di telefono 2 inserito non é valido!" );
                return;
            } else if (!controllaTelefono ( telefono3Field.getText() )){
                mostraDialog ( Alert.AlertType.ERROR, "Telefono non valido!", "Il numero di telefono 3 inserito non é valido!" );
                return;
            }
            if(!controllaEmail(email1Field.getText())){
                mostraDialog ( Alert.AlertType.ERROR, "Email non valida!", "L'indirizzo email 1 inserito non é valido!" );
                return;
            } else if(!controllaEmail(email2Field.getText())) {
                mostraDialog ( Alert.AlertType.ERROR, "Email non valida!", "L'indirizzo email 2 inserito non é valido!" );
                return;
            } else if(!controllaEmail(email3Field.getText())) {
                mostraDialog ( Alert.AlertType.ERROR, "Email non valida!", "L'indirizzo email 3 inserito non é valido!" );
                return;
            } else {
                // Aggiorna i dati del contatto selezionato
                c.setNome(nomeField.getText());
                c.setCognome(cognomeField.getText());
                c.setEmail1(email1Field.getText());
                c.setEmail2(email2Field.getText());
                c.setTelefono3(telefono1Field.getText());
                c.setTelefono1(telefono2Field.getText());
                c.setTelefono2(telefono2Field.getText());
                c.setCompleanno(compleannoField.getValue());
                c.setIndirizzoResidenza(indirizzoField.getText());
                c.setNote(noteField.getText());
                c.setSitoWeb(linkField.getText());
                c.setNote(noteField.getText());
            }

            //TEST
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
     * @brief gestore dell'evento relativo al click del pulsante "Finestra -> Rubrica Standard". Il metodo consente di
     * aggiornare la TableView mostrando la "Rubrica Standard" ossia tutti i contatti presenti in rubrica.
     */
    @FXML
    private void showRubrica(){
        rubricaTable.setItems(this.getListaContatti());
        contattiLabel.setText("Contatti");
    }
    /**
     * @brief gestore dell'evento relativo al click del pulsante "Finestra -> Contatti Preferiti". Il metodo consente di
     * aggiornare la TableView mostrando solamente i contatti preferiti presenti in rubrica.
     */
    @FXML
    private void showPreferiti(){
        contattiFiltratiPreferiti = new FilteredList<>(this.getListaContatti(), contatto -> contatto.getPreferito());
        rubricaTable.setItems(contattiFiltratiPreferiti);
        contattiLabel.setText("Preferiti");
    }
    /**
     * @brief gestore dell'evento relativo al click del pulsante "Finestra -> Contatti Emergenza". Il metodo consente di
     * aggiornare la TableView mostrando solamente i contatti di emergenza presenti in rubrica.
     */
    @FXML
    private void showEmergenza(){
        contattiFiltratiEmergenza = new FilteredList<>(this.getListaContatti(), contatto -> contatto.getEmergenza());
        rubricaTable.setItems(contattiFiltratiEmergenza);
        contattiLabel.setText("Emergenze");
    }
    /**
     * @brief Gestore dell'evento relativo al click sul pulsante "Emergenza". Il metodo consente di inserire e rimuovere
     * un contatto dai contatti di emergenza. Se il contatto selezionato é giá un contatto di emergenza, allora
     * il metodo lo rimuove. Se il contatto selezionato non fa parte delle emergenze, il metodo lo inserisce.
     */
    @FXML
    private void toggleEmergenza(){
        Contatto c = rubricaTable.getSelectionModel().getSelectedItem();
        if (c != null) {
            c.setEmergenza(!c.getEmergenza());
            rubricaTable.refresh();
            if(c.getEmergenza())
                mostraDialog(Alert.AlertType.INFORMATION, "Aggiunta Emergenze", "Il contatto é stato aggiunto tra le emergenze");
            else mostraDialog(Alert.AlertType.WARNING, "Rimozione Emergenze", "Il contatto é stato rimosso dalle emergenze");
        }
    }
    /**
     * @brief Gestore dell'evento relativo al click sul pulsante "Preferito". Il metodo consente di inserire e rimuovere
     * un contatto dai contatti preferiti. Se il contatto selezionato é giá un contatto preferito, allora
     * il metodo lo rimuove. Se il contatto selezionato non fa parte delle emergenze, il metodo lo inserisce.
     */
    @FXML
    private void togglePreferiti() {
        Contatto c = rubricaTable.getSelectionModel().getSelectedItem();
        if (c != null) {
            c.setPreferito(!c.getPreferito());
            if(c.getPreferito())
                mostraDialog(Alert.AlertType.INFORMATION, "Aggiunta Preferiti", "Il contatto é stato aggiunto tra i preferiti");
            else mostraDialog(Alert.AlertType.WARNING, "Rimozione Preferiti", "Il contatto é stato rimosso dai preferiti");
            rubricaTable.refresh();
        }
    }
    /**
     * @brief Gestore dell'evento relativo al click sul pulsante "? -> Github". Il metodo apre la webpage utilizzando l'URL specificato.
     * @param[in] urlString, URL della pagina web da aprire.
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
     * @brief metodo per aprire la repository Git del progetto in una pagina web.
     */
    @FXML
    private void openGit(){
        openWebpage("https://github.com/emanueletocci/uni-swe-project");
    }
    
    /**
     * @brief Gestore dell'evento relativo al click del pulsante "Esporta Rubrica". Il metodo apre una finestra che consente all'utente di selezionare
     * percorso in cui salvare il file e chiama il metodo responsabile dell'export della rubrica in formato .vcf.
     */
    @FXML
    public void handleExportRubrica(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("VCF", "*.vcf"));
        fileChooser.setTitle("Esporta Rubrica");
        File file = fileChooser.showSaveDialog(new Stage());

        Export e = new Export();
        e.esportaRubrica(this.getRubrica(), file.getAbsolutePath());

        mostraDialog( Alert.AlertType.INFORMATION,
                "Export completato",
                "La rubrica è stata esportato con successo\noutput: " + file.getAbsolutePath()+".vcf");
    }
    
    /**
     * @brief Gestore dell'evento "Esporta Contatto". Il metodo apre una finestra che consente all'utente di selezionare un percorso in un cui salvare
     * il file e chiama il metodo responsabile dell'export in formato .vcf.
     */
    @FXML
    public void handleExportContatto(){
        Contatto c=rubricaTable.getSelectionModel().getSelectedItem();
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("VCF", "*.vcf"));
        fileChooser.setTitle("Esporta Contatto");
        File file = fileChooser.showSaveDialog(new Stage());

        Export e = new Export();
        e.esportaContatto(c, file.getAbsolutePath());
        mostraDialog(Alert.AlertType.INFORMATION,
                "Export completato",
                "Il contatto è stato esportato con successo\noutput: " + file.getAbsolutePath() + ".vcf");
    }
    /**
     * @brief Gestore dell'evento "Importa Rubrica/Contatto". Il metodo apre una finestra che consente all'utente di selezionare un file da importare
     * e chiama il metodo responsabile dell'import.
     * @throws IOException
     */
    @FXML
    public void handleImportRubrica() throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("VCF", "*.vcf"));
        fileChooser.setTitle("Selezionare file .vcf");
        File file = fileChooser.showOpenDialog(new Stage());

        Import i=new Import();
        i.importVcard(this.getRubrica(),this.getListaContatti(), file.getAbsolutePath());
        System.out.println(this.getRubrica().getContatti());
        rubricaTable.refresh();
    }
}
