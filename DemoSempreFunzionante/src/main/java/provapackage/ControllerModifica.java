
package provapackage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.List;

public class ControllerModifica {

    @FXML
    private HBox HBox1;

    @FXML
    private HBox HBox2;

    @FXML
    private Button aggiungi_email;

    @FXML
    private Button aggiungi_telefono;

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
    private TextField linkInsta;

    @FXML
    private Button modificaBtn;

    @FXML
    private TextField nome;

    @FXML
    private TextField noteFld;

    @FXML
    private TextField telefono;

    private List<Contatto> rubrica; // Riferimento alla rubrica condivisa
    private Contatto contatto;

    @FXML
    void Modifica(ActionEvent event) {
        // Ottieni i valori dai TextField
        String nomeText = nome.getText();
        String cognomeText = cognome.getText();
        String telefonoText = telefono.getText();
        String emailText = email.getText();
        String compleannoText = compleanno.getText();
        String indirizzoText = indirizzo.getText();
        String sitoWebText = linkInsta.getText();
        // Crea il nuovo contatto
        Contatto temp = new Contatto(nomeText, cognomeText, telefonoText, emailText, compleannoText, indirizzoText, sitoWebText);
        rubrica.remove(contatto);
        rubrica.add(temp);
        // Metodo close() al crea, trovato su github
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    public void setRubrica(List<Contatto> rubrica, Contatto contatto) {
        this.rubrica = rubrica; //copia la struttura dati della precedente view (la main view)
        this.contatto=contatto;
    }

    /*@Override
    public void initialize(URL url, ResourceBundle rb) {
        // Codice basato sulla spiegazione di Greco
        nome.setText(contatto.getNome());
    }*/

}
