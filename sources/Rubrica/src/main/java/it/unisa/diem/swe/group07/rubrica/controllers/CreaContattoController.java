package it.unisa.diem.swe.group07.rubrica.controllers;
import it.unisa.diem.swe.group07.rubrica.models.Contatto;
import it.unisa.diem.swe.group07.rubrica.models.ContattoEsteso; 
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.util.List;

public class CreaContattoController {
    @FXML
    private HBox HBox1;
    @FXML
    private HBox HBox2;
    @FXML
    private Button aggiungi_email;
    @FXML
    private Button aggiungi_telefono;
    @FXML
    private Button bottone_creazione;
    @FXML
    private Button bottone_imm;
    @FXML
    private TextField cognome;
    @FXML
    private TextField compleanno;
    @FXML
    private TextField email;
    @FXML
    private ImageView immagine;
    @FXML
    private TextField indirizzo;
    @FXML
    private TextField nome;
    @FXML
    private TextField sito_web;
    @FXML
    private TextField telefono;

    private List<ContattoEsteso> listaContatti; // Riferimento alla rubrica condivisa

    @FXML
    public void Crea(ActionEvent event) {   //metodo da rinominare (ambiguo)
        // Ottieni i valori dai TextField
        String nomeText = nome.getText();
        String cognomeText = cognome.getText();
        String telefonoText = telefono.getText();
        String emailText = email.getText();
        String compleannoText = compleanno.getText();
        String indirizzoText = indirizzo.getText();
        String sitoWebText = sito_web.getText();

        // Crea il nuovo contatto
        ContattoEsteso temp = new ContattoEsteso(nomeText, cognomeText, telefonoText, telefonoText, telefonoText, emailText, emailText, emailText, compleannoText, indirizzoText, sitoWebText);
        listaContatti.add(temp);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();

    }
    public void setListaContatti(List<ContattoEsteso> listaContatti) {
        this.listaContatti = listaContatti;
    }
}
