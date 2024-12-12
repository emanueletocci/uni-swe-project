/**
 * @file AbstractController.java
 * @brief Il file contiene l'implementazione di un controller astratto che contiene il riferimento alla rubrica e alla lista osservabile. Il controller predispone
 * alcuni metodi pubblici (mutator e 'mostraDialog'), direttamente accessibili dalle sottoclassi
 * @autor Gruppo07
 * @date Dicembre, 2024
 */

package it.unisa.diem.swe.group07.rubrica.controllers;
import it.unisa.diem.swe.group07.rubrica.models.ContattoEsteso;
import it.unisa.diem.swe.group07.rubrica.models.Rubrica;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

public abstract class AbstractController {

    /**
     * @brief istanza della rubrica (Map)
     */
    private Rubrica rubrica = new Rubrica();

    /**
     * @brief istanza della lista osservabile
     */
    private ObservableList<ContattoEsteso> listaContatti = FXCollections.observableArrayList();

     /**
     * @brief metodo getter dell'attributo rubrica
     * @return rubrica, Attributo rubrica
     */
    public Rubrica getRubrica() {
        return rubrica;
    }

    /**
     * @brief metodo setter dell'attributo rubrica
     * @param[in] rubrica, Attributo rubrica
     */
    public void setRubrica(Rubrica rubrica) {
        this.rubrica = rubrica;
    }

     /**
     * @brief metodo getter della struttura (lista osservabile)
     * @return listaContatti, La lista osservabile contenente i contatti
     */ 
    public ObservableList<ContattoEsteso> getListaContatti() {
        return listaContatti;
    }

    /**
     * @brief metodo setter della lista osservabile 
     * @param[in] listaContatti, La lista osservabile contenente i contatti
     */
    public void setListaContatti(ObservableList<ContattoEsteso> listaContatti) {
        this.listaContatti = listaContatti;
    }

    /**
     * @brief metodo che consenti di mostrare un generico dialog.
     * @param[in] tyoe, Tipo di Alert.
     * @param[in] titolo, Titolo della finestra (dialog).
     * @param[in] messaggio, Messaggio da mostrare nella finestra.
     */
    public void mostraDialog(Alert.AlertType type, String titolo, String messaggio) {
        Alert alert = new Alert(type);
        alert.setTitle(titolo);
        alert.setContentText(messaggio);
        alert.showAndWait();
    }
}