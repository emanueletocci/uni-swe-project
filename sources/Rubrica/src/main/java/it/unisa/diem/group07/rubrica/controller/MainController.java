package it.unisa.diem.group07.rubrica.controller;

import it.unisa.diem.group07.rubrica.model.Contatto;
import it.unisa.diem.group07.rubrica.model.Rubrica;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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

public class MainController {
    @FXML
    private TextField cellulare;

    @FXML
    private TextField cognome;

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
    private ImageView imgcontatto;

    @FXML
    private TextField indirizzo;

    @FXML
    private TextField nomeId;

    @FXML
    private TextField note;

    @FXML
    private TextField numeroCasa;

    @FXML
    private TextField numeroUfficio;

    @FXML
    private Button pulsanteCerca;

    @FXML
    private Button pulsanteCrea;

    @FXML
    private Button pulsanteElimina;

    @FXML
    private Button pulsanteExport;

    @FXML
    private Button pulsanteImport;

    @FXML
    private Button pulsanteModifica;

    @FXML
    private TextField social;
    
      ObservableMap<Integer, Contatto> rubrica;
      
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
        rubrica.addListener(new Contatto (nomeId.getText(), cognome.getText(),numeri , )));

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


}
