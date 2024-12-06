package it.unisa.diem.group07.rubrica.controller;
/**
 * @file RubricaController.java
 * @brief questo file contiene l'implementazione della classe RubricaController per la gestione generale della Rubrica.
 * @autor Gruppo07
 * @date Dicembre, 2024
 * @version 1.0
 */
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class RubricaController extends MainController{
   

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

    @FXML
    void CercaContatto(ActionEvent event) {

    }

    @FXML
    void CreaContatto(ActionEvent event) {

    }

    @FXML
    void EliminaContatto(MouseEvent event) {

    }

    @FXML
    void ExportRubrica(ActionEvent event) {

    }

    @FXML
    void ImportRubrica(ActionEvent event) {

    }

    @FXML
    void ModificaContatto(MouseEvent event) {

    }


}
