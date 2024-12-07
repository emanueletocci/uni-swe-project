package provapackage;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.util.List;
import java.util.Map;

public class ControllerCreazione {

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


    private List<Contatto> rubrica;


    @FXML
    public void Crea(ActionEvent event) {
        // Ottieni i valori dai TextField
        String nomeText = nome.getText();
        String cognomeText = cognome.getText();
        String telefonoText = telefono.getText();
        String emailText = email.getText();
        String compleannoText = compleanno.getText();
        String indirizzoText = indirizzo.getText();
        String sitoWebText = sito_web.getText();


        // Crea il nuovo contatto
        Contatto temp = new Contatto(nomeText, cognomeText, telefonoText, emailText, compleannoText, indirizzoText, sitoWebText);

        rubrica.add(temp.getId(),temp);
    }

    public void setRubrica(List<Contatto> rubrica) {
        this.rubrica = rubrica;
    }
}
