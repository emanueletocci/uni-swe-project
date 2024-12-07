

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    private ObservableMap<Integer, Contatto> rubrica;

    @FXML // fx:id="cellulareField"
    private TextField cellulareField; // Value injected by FXMLLoader

    @FXML // fx:id="cognomeClm"
    private TableColumn<?, ?> cognomeClm; // Value injected by FXMLLoader

    @FXML // fx:id="cognomeField"
    private TextField cognomeField; // Value injected by FXMLLoader

    @FXML // fx:id="compleannoField"
    private TextField compleannoField; // Value injected by FXMLLoader

    @FXML // fx:id="emailField"
    private TextField emailField; // Value injected by FXMLLoader

    @FXML // fx:id="emailIcloudField"
    private TextField emailIcloudField; // Value injected by FXMLLoader

    @FXML // fx:id="emailLavoroField"
    private TextField emailLavoroField; // Value injected by FXMLLoader

    @FXML // fx:id="fullname"
    private TextField fullname; // Value injected by FXMLLoader

    @FXML // fx:id="idField"
    private TextField idField; // Value injected by FXMLLoader

    @FXML // fx:id="imgcontatto"
    private ImageView imgcontatto; // Value injected by FXMLLoader

    @FXML // fx:id="indirizzoField"
    private TextField indirizzoField; // Value injected by FXMLLoader

    @FXML // fx:id="nomeClm"
    private TableColumn<?, ?> nomeClm; // Value injected by FXMLLoader

    @FXML // fx:id="nomeField"
    private TextField nomeField; // Value injected by FXMLLoader

    @FXML // fx:id="noteField"
    private TextField noteField; // Value injected by FXMLLoader

    @FXML // fx:id="numeroCasaField"
    private TextField numeroCasaField; // Value injected by FXMLLoader

    @FXML // fx:id="numeroUfficioField"
    private TextField numeroUfficioField; // Value injected by FXMLLoader

    @FXML // fx:id="pulsanteCerca"
    private Button pulsanteCerca; // Value injected by FXMLLoader

    @FXML // fx:id="pulsanteCrea"
    private Button pulsanteCrea; // Value injected by FXMLLoader

    @FXML // fx:id="pulsanteElimina"
    private Button pulsanteElimina; // Value injected by FXMLLoader

    @FXML // fx:id="pulsanteModifica"
    private Button pulsanteModifica; // Value injected by FXMLLoader

    @FXML // fx:id="rubricaTable"
    private TableView<Contatto> rubricaTable; // Value injected by FXMLLoader

    @FXML // fx:id="socialField"
    private TextField socialField; // Value injected by FXMLLoader

    @FXML
    void CercaContatto(ActionEvent event) {

    }

    @FXML
    void CreaContatto(ActionEvent event) {
        Contatto temp=new Contatto(nomeField.getText());
        rubrica.put(Integer.valueOf(idField.getText()), temp);
    }

    @FXML
    void EliminaContatto(MouseEvent event) {

    }

    @FXML
    void ModificaContatto(MouseEvent event) {

    }

    @FXML
    void aggiornaNome(ActionEvent event) {

    }

    @FXML
    void aggiungiId(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Inizializza la rubrica come una mappa osservabile
        rubrica = FXCollections.observableHashMap();

        // Imposta la colonna "Nome" per visualizzare il nome dell'oggetto
        //nomeClm.setCellValueFactory(s -> new SimpleStringProperty(s.getValue().getName()));

        // Imposta la colonna "Cognome" per visualizzare il cognome dell'oggetto
        cognomeClm.setCellValueFactory(new PropertyValueFactory<>("surname"));

        // Collega la rubrica alla TableView
        rubricaTable.setItems(FXCollections.observableArrayList(rubrica.values()));
    }
}
