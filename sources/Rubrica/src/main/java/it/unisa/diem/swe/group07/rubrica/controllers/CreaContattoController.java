/**
 * @file CreaContattoController.java
 * @brief questo file contiene l'implementazione del controller per la creazione di un contatto
 * @autor Gruppo07
 * @date Dicembre, 2024
 * @version 1.0
 */
package it.unisa.diem.swe.group07.rubrica.controllers;
import it.unisa.diem.swe.group07.rubrica.models.ContattoEsteso;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.List;

public class CreaContattoController {
        /**
     * @brief HBox1 layout container per aggiungere i nodi orizzontalmente
     */
    @FXML
    private HBox HBox1;
       /**
     * @brief HBox2 layout container per aggiungere i nodi orizzontalmente
     */
    @FXML
    private HBox HBox2;
       /**
     * @brief bottone per aggiungere l'email
     */
    @FXML
    private Button aggiungi_email;
       /**
     * @brief bottone per aggiungere il numero telefonico
     */
    @FXML
    private Button aggiungi_telefono;
       /**
     * @brief bottone per effettuare la creazione di un contatto
     */
    @FXML
    private Button bottone_creazione;
       /**
     * @brief bottone per inserire l'immagine
     */
    @FXML
    private Button bottone_imm;
       /**
     * @brief  Text Field per il cognome del contatto
     */
    @FXML
    private TextField cognome;
       /**
     * @brief  Text Field per il compleanno del contatto
     */
    @FXML
    private DatePicker compleanno;
       /**
     * @brief  Text Field per l'email del contatto
     */
    @FXML
    private TextField email;
       /**
     * @brief immagine da inserire
     */
    @FXML
    private ImageView immagine;
       /**
     * @brief Text Field per l'indirizzo del contatto
     */
    @FXML
    private TextField indirizzo;
       /**
     * @brief Text Field per il nome del contatto
     */
    @FXML
    private TextField nome;
      /**
     * @brief Text Field per il sito web del contatto
     */
    @FXML
    private TextField sito_web;
        /**
     * @brief Text Field per il numero telefonico del contatto
     */
    @FXML
    private TextField telefono;

    /**
     * @brief struttura per gestire una Lista di Contatti
     */
    private List<ContattoEsteso> listaContatti; // Riferimento alla rubrica condivisa

        /**
     * @brief metodo che preleva il valore dai Text Field creando il contatto ed aggiungendolo alla Lista+
     * @param event evento generato dal click sul pulsante Crea
     */
    @FXML
    public void Crea(ActionEvent event) {
        // Ottieni i valori dai TextField
        String nomeText = nome.getText();
        String cognomeText = cognome.getText();
        String telefonoText = telefono.getText();
        String emailText = email.getText();
        LocalDate compleannoText = compleanno.getValue();
        String indirizzoText = indirizzo.getText();
        String sitoWebText = sito_web.getText();
        

        // Crea il nuovo contatto
        ContattoEsteso temp = new ContattoEsteso(nomeText, cognomeText, telefonoText, telefonoText, telefonoText, emailText, emailText, emailText, compleannoText , indirizzoText, sitoWebText, "note");
        listaContatti.add(temp);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();

    }
        /**
     * @brief metodo setter per listaContatti
     */
    public void setListaContatti(List<ContattoEsteso> listaContatti) {
        this.listaContatti = listaContatti;
    }

}
