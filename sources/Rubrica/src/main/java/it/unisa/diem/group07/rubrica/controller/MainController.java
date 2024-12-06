package it.unisa.diem.group07.rubrica.controller;

import it.unisa.diem.group07.rubrica.model.Contatto;
import it.unisa.diem.group07.rubrica.model.Rubrica;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

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
    private TextField cellulareField;

    @FXML
    private TableColumn<String, String> cognomeClm;

    @FXML
    private TextField cognomeField;

    @FXML
    private TextField compleannoField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField emailIcloudField;

    @FXML
    private TextField emailLavoroField;

    @FXML
    private TextField fullname;

    @FXML
    private TextField idField;

    @FXML
    private ImageView imgcontatto;

    @FXML
    private TextField indirizzoField;

    @FXML
    private TableColumn<String, String> nomeClm;

    @FXML
    private TextField nomeField;

    @FXML
    private TextField noteField;

    @FXML
    private TextField numeroCasaField;

    @FXML
    private TextField numeroUfficioField;

    @FXML
    private Button preferiti;

    @FXML
    private Button pulsanteCerca;

    @FXML
    private Button pulsanteCrea;

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
    private TextField socialField;

    private ObservableList<Contatto> rubrica;
    private Rubrica rubricamodel;
 
    @Override
    public void initialize(URL url, ResourceBundle rb){
        rubricamodel=new Rubrica();
        rubrica = FXCollections.observableArrayList(rubricamodel.getContatti());
        cognomeClm.setCellValueFactory(new PropertyValueFactory("cognome"));
        nomeClm.setCellValueFactory(new PropertyValueFactory("nome"));
        rubricaTable.setItems(rubrica);
}
 

    /// @brief metodo che permette la ricerca del Contatto inserito
    @FXML
    void CercaContatto(ActionEvent event) {
   
    }
    /// @brief metodo che permette di creare un nuovo Contatto
    ///crea contatto viene utilizzato quando nella CreazioneView viene cliccato il pulsante aggiungi
    
    @FXML
    void CreaContatto(ActionEvent event) {
       int[] numeri=new int[3];
        String numeri1=cellulareField.getText();
        String numeri2=numeroCasaField.getText();
        String numeri3=numeroUfficioField.getText();
        numeri[0]=Integer.parseInt(numeri1);
        numeri[1]=Integer.parseInt(numeri2);
        numeri[2]=Integer.parseInt(numeri3);

        
        String[] emails=new String[3];
        emails[0]=emailField.getText();
        emails[1]=emailLavoroField.getText();
        emails[2]=emailIcloudField.getText();
        
        String idStringa=idField.getText();
        int idValue=Integer.parseInt(idStringa);
        String name=nomeField.getText();
        String surname=cognomeField.getText();
        
       try{
           if(name.isEmpty() && surname.isEmpty()){
               throw new IllegalArgumentException("ERROR:IL CONTATTO DEVE AVERE O NOME O COGNOME ");
           }
           Contatto nuovoContatto= new Contatto(idValue, name, surname,false, false,emails, numeri);
           rubricamodel.aggiungiContatto(nuovoContatto);
           rubrica.add(nuovoContatto);
           nomeField.clear();
           cognomeField.clear();
           emailField.clear();
           emailLavoroField.clear();
           emailIcloudField.clear();
           cellulareField.clear();
           numeroCasaField.clear();
           numeroUfficioField.clear();
           idField.clear();
       }catch(IllegalArgumentException e){
           mostraErrore(e.getMessage());
       }
      
    }
    public void mostraErrore(String messaggio){
        Alert alert=new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Errore");
        alert.setHeaderText("Devi inserire un nome o un cognome per creare un contatto");
        alert.setContentText(messaggio);
        alert.showAndWait();
        
    }
/// @brief metodo per la eliminazione di un Contatto dalla rubrica
    @FXML
    void EliminaContatto(ActionEvent event) {

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
    void aggiungiId(ActionEvent event) {

    }

    @FXML
    void aggiornaNome(TableColumn.CellEditEvent<String,String> event) {
        Contatto s=rubricaTable.getSelectionModel().getSelectedItem();
        s.setNome(event.getNewValue());
        
        //handleall
    }    

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
