package it.unisa.diem.swe.group07.rubrica.controllers;
import it.unisa.diem.swe.group07.rubrica.models.ContattoEsteso;
import it.unisa.diem.swe.group07.rubrica.models.Rubrica;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;
/**
 * @file AbstractController.java
 * @brief questo file contiene l'implementazione del Controller astratto che contiene il riferimento alla rubrica e alla lista
 * @autor Gruppo07
 * @date Dicembre, 2024
 * @version 1.0
 */

public abstract class AbstractController {
    /**
     * @brief attributo Rubrica
     */
    private Rubrica rubrica = new Rubrica();
    /**
     * @brief struttura che contiene la lista dei contatti
     */
    private ObservableList<ContattoEsteso> listaContatti = FXCollections.observableArrayList();
     /**
     * @brief metodo getter dell'attributo rubrica
     * @return attributo rubrica
     */
    public Rubrica getRubrica() {
        return rubrica;
    }
    /**
     * @brief metodo setter dell'attributo rubrica
     * @param rubrica 
     */
    public void setRubrica(Rubrica rubrica) {
        this.rubrica = rubrica;
    }
     /**
     * @brief metodo getter della struttura (lista osservabile)
     * @return lista osservabile listaContatti
     */ 
    public ObservableList<ContattoEsteso> getListaContatti() {
        return listaContatti;
    }
    /**
     * @brief metodo setter della lista osservabile 
     * @param listaContatti 
     */
    public void setListaContatti(ObservableList<ContattoEsteso> listaContatti) {
        this.listaContatti = listaContatti;
    }
}