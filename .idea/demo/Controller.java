package provapackage;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable{

    private ObservableList<Contatto> rubrica;

    @FXML // fx:id="cellulareField"
    private TextField cellulareField; // Value injected by FXMLLoader

    @FXML // fx:id="cognomeClm"
    private TableColumn<Contatto, String> cognomeClm; // Value injected by FXMLLoader

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
    private TableColumn<Contatto, String> nomeClm; // Value injected by FXMLLoader

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
        try {
            // Carica il file FXML della nuova view
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewCreazioneContatto.fxml"));
            Parent root = loader.load();
            // Ottieni il controller della nuova view
            ControllerCreazione controllerCreazione = loader.getController();
            // Passa la rubrica al controller di creazione
            controllerCreazione.setRubrica(rubrica);
            // Crea un nuovo Stage per la nuova finestra
            Stage nuovoStage = new Stage();
            nuovoStage.setScene(new Scene(root));
            nuovoStage.setTitle("Crea Nuovo Contatto");
            nuovoStage.initModality(Modality.APPLICATION_MODAL);
            // Mostra la finestra e attende la chiusura
            nuovoStage.showAndWait();
            // Aggiorna la TableView con i nuovi dati
            rubricaTable.setItems(FXCollections.observableArrayList(rubrica));
            for(Contatto c:rubrica)
                System.out.println(c.getNome());
        } catch (Exception e) {
            e.printStackTrace();
        }
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

        rubrica = FXCollections.observableArrayList();
        nomeClm.setCellValueFactory(s -> { return new SimpleStringProperty(s.getValue().getNome());  });
        cognomeClm.setCellValueFactory(new PropertyValueFactory("cognome"));
        rubricaTable.setItems(rubrica);

        rubricaTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                // Aggiorna i campi con i dati del contatto selezionato
                nomeField.setText(newValue.getNome());
                cognomeField.setText(newValue.getCognome());
                // Aggiorna gli altri campi similmente
            }
        });
    }

}
