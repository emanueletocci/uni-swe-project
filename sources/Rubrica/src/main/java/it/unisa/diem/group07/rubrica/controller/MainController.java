package it.unisa.diem.group07.rubrica.controller;

import it.unisa.diem.group07.rubrica.model.Contatto;
import it.unisa.diem.group07.rubrica.model.Rubrica;
import it.unisa.diem.group07.rubrica.model.RubricaEmergenze;
import it.unisa.diem.group07.rubrica.model.RubricaPreferiti;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * @file MainController.java
 * @brief questo file contiene l'implementazione del Controller principale per la gestione della rubrica telefonica.
 *        questa classe gestisce l'interazione tra l'utente e il modello di dati della rubrica.
 *  @autor Gruppo07
 * @date Dicembre, 2024
 * @version 1.0
 */

public class MainController implements Initializable{
    @FXML
    private TextField cellulareFieldMain;

    @FXML
    private TableColumn<String, String> cognomeClm;

    @FXML
    private TextField cognomeFieldMain;

    @FXML
    private TextField compleannoFieldMain;

    @FXML
    private TextField emailFieldMain;

    @FXML
    private TextField emailIcloudFieldMain;

    @FXML
    private TextField emailLavoroFieldMain;

    @FXML
    private TextField fullname;

    @FXML
    private TextField idFieldMain;

    @FXML
    private ImageView imgcontatto;

    @FXML
    private TextField indirizzoFieldMain;

    @FXML
    private TableColumn<String, String> nomeClm;

    @FXML
    private TextField nomeFieldMain;

    @FXML
    private TextField noteFieldMain;

    @FXML
    private TextField numeroCasaFieldMain;

    @FXML
    private TextField numeroUfficioFieldMain;

    @FXML
    private Button preferiti;

    @FXML
    private Button pulsanteCerca;

    @FXML
    private Button pulsanteCreazioneView;

    @FXML
    private Button pulsanteElimina;

    @FXML
    private Button pulsanteEmergenza;

    @FXML
    private Button pulsanteExport;

    @FXML
    private Button pulsanteImport;

    @FXML
    private Button pulsanteModifica;

    @FXML
    private TableView<Contatto> rubricaTable;

    @FXML
    private TextField socialFieldMain;
    
    /////////////////////////////////
    
    
   //FXML PER LA CREAZIONEVIEW 
    
    
    
///////////////////////
    
    private ObservableList<Contatto> rubrica;
    private Rubrica rubricamodel;
    private RubricaPreferiti rPreferiti;
    private RubricaEmergenze rEmergenze;
 
    @Override
    public void initialize(URL url, ResourceBundle rb){
        rubricamodel=new Rubrica();
        rubrica = FXCollections.observableArrayList(rubricamodel.getContatti());
        cognomeClm.setCellValueFactory(new PropertyValueFactory("cognome"));
        nomeClm.setCellValueFactory(new PropertyValueFactory("nome"));
        rubricaTable.setItems(rubrica);
}
 

    ///BISOGNA AGGIUNGERE BARRA DI RICERCA E DARLE ID: barraRicerca
    /// @brief metodo che permette la ricerca del Contatto inserito
    @FXML
    void CercaContatto(ActionEvent event) {
        barraRicerca.textProperty().addListener((observable, oldValue, newValue)->cerca(newValue));
    }
    private void cerca(String contattoCercato){
        if(contattoCercato== null || contattoCercato.isEmpty()){
            rubricaTable.setItems(rubrica);
        }else{
            ObservableList<Contatto> ricercaLista=FXCollections.observableArrayList();
            for(Contatto c: rubrica){
                if(c.getNome().toLowerCase().contains(contattoCercato.toLowerCase()) || c.getCognome().toLowerCase().contains(contattoCercato.toLowerCase())){
                    ricercaLista.add(c);
                }
            }
            rubricaTable.setItems(ricercaLista);
        }
    }
    
    @FXML
    void apriCreazioneContatto (ActionEvent event) throws Exception{
    FXMLLoader caricamento= new FXMLLoader(getClass().getResource("../../../../../../../../resources/it/unisa/diem/group07/rubrica/view/CreazioneContattoView"));
Parent rootCreazione= caricamento.load();
Stage stage=new Stage();
stage.setTitle("Creazione contatto");
Scene scene=new Scene(rootCreazione);
stage.setScene(scene);
stage.show();
    }
    
    
    /// @brief metodo che permette di creare un nuovo Contatto
    ///crea contatto viene utilizzato quando nella CreazioneView viene cliccato il pulsante aggiungi 
    ////òe fxml id devono essere cambiati nella Creazioneview
    @FXML
    void CreaContatto(ActionEvent event) {
       int[] numeri=new int[3];
        String numeri1=cellulareFieldMain.getText();
        String numeri2=numeroCasaFieldMain.getText();
        String numeri3=numeroUfficioFieldMain.getText();
        numeri[0]=Integer.parseInt(numeri1);
        numeri[1]=Integer.parseInt(numeri2);
        numeri[2]=Integer.parseInt(numeri3);

        
        String[] emails=new String[3];
        emails[0]=emailFieldMain.getText();
        emails[1]=emailLavoroFieldMain.getText();
        emails[2]=emailIcloudFieldMain.getText();
        
        String idStringa=idFieldMain.getText();
        int idValue=Integer.parseInt(idStringa);
        String name=nomeFieldMain.getText();
        String surname=cognomeFieldMain.getText();
        
       try{
           if(name.isEmpty() && surname.isEmpty()){
               throw new IllegalArgumentException("IL CONTATTO DEVE AVERE O NOME O COGNOME ");
           }
           Contatto nuovoContatto= new Contatto(idValue, name, surname,false, false,emails, numeri);
           rubricamodel.aggiungiContatto(nuovoContatto);
           rubrica.add(nuovoContatto);
           nomeFieldMain.clear();
           cognomeFieldMain.clear();
           emailFieldMain.clear();
           emailLavoroFieldMain.clear();
           emailIcloudFieldMain.clear();
           cellulareFieldMain.clear();
           numeroCasaFieldMain.clear();
           numeroUfficioFieldMain.clear();
           idFieldMain.clear();
       }catch(IllegalArgumentException e){
           mostraErrore(e.getMessage());
       }
      
    }
    
 //da aggiungere nel diagramma delle classi    
    public void mostraErrore(String messaggio){
        Alert alert=new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Errore");
        alert.setHeaderText("Operazione non valida");
        alert.setContentText(messaggio);
        alert.showAndWait();
    }
    
    
/// @brief metodo per la eliminazione di un Contatto dalla rubrica
    @FXML
    void EliminaContatto(ActionEvent event) {
        Contatto c=rubricaTable.getSelectionModel().getSelectedItem();
        rubricamodel.rimuoviContatto(c);
}

/// @brief metodo per Export di Contatti della Rubrica
    @FXML
    void ExportRubrica(ActionEvent event) {
        

    }
/// @brief metodo per Import di Contatti nella Rubrica
    @FXML
    void ImportRubrica(ActionEvent event) {

    }
/// @brief metodo per modificare un Contatto della Rubrica
    @FXML
    void ModificaContatto(ActionEvent event) {

    }
@FXML
    void aggiungiPreferiti(ActionEvent event) {

    }
    @FXML
    void AggiungiEmergenza(ActionEvent event) {

    }


    @FXML
    void aggiornaNome(TableColumn.CellEditEvent<String,String> event) {
        Contatto s=rubricaTable.getSelectionModel().getSelectedItem();
        s.setNome(event.getNewValue());
        //handleall
    }   
    private void handle

}
