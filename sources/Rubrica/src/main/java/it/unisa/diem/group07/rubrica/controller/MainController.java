package it.unisa.diem.group07.rubrica.controller;

import it.unisa.diem.group07.rubrica.model.Contatto;
import it.unisa.diem.group07.rubrica.model.Rubrica;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
    private TextField cellulare;

    @FXML
    private TextField cognome;

    @FXML
    private TableColumn<String, String> cognomeClm;

    @FXML
    private TextField compleanno;

    @FXML
    private TextField email;

    @FXML
    private TextField emailIcloud;

    @FXML
    private TextField emailLavoro;

    @FXML
    private TextField fullname;

    @FXML
    private TextField id;

    @FXML
    private ImageView imgcontatto;

    @FXML
    private TextField indirizzo;

    @FXML
    private TableColumn<String, String> nomeClm;

    @FXML
    private TextField nomeId;

    @FXML
    private TextField note;

    @FXML
    private TextField numeroCasa;

    @FXML
    private TextField numeroUfficio;

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
    private TextField social;
     
    private ObservableMap<Integer, Contatto> rubrica;
      
      public MainController(Rubrica rubrica){
        this.rubrica=rubrica;
    }

    /// @brief metodo che permette la ricerca del Contatto inserito
    @FXML
    void CercaContatto(ActionEvent event) {
        

    }
    /// @brief metodo che permette di creare un nuovo Contatto
    @FXML
    void CreaContatto(ActionEvent event) {
        int[] numeri=new int[3];
        String numeri1=cellulare.getText();
        String numeri2=numeroCasa.getText();
        String numeri3=numeroUfficio.getText();
        numeri[0]=Integer.parseInt(numeri1);
        numeri[1]=Integer.parseInt(numeri2);
        numeri[2]=Integer.parseInt(numeri3);
        
        String[] emails=new String[3];
        emails[0]=email.getText();
        emails[1]=emailLavoro.getText();
        emails[2]=emailIcloud.getText();
        
        String idStringa=id.getText();
        int idvalue=Integer.parseInt(idStringa);
        String name=nomeId.getText();
        String username=cognome.getText();
        
        rubrica.add(new Contatto (idvalue, name, username,numeri , false, false, emails));

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
