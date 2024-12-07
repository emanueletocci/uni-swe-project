/**
 * @file Emergenza.java
 * @brief questo file contiene l'implementazione della classe Emergenza utilizzata per aggiungere uno specifico contatto nella sezione "Emergenza"
 * @autor Gruppo07
 * @date Dicembre, 2024
 * @version 1.0
 */

package it.unisa.diem.group07.rubrica.model;
import it.unisa.diem.group07.rubrica.model.Rubrica;
import java.util.HashMap;
import javafx.beans.Observable;
import javafx.collections.ObservableMap;

import java.util.Map;

public class RubricaEmergenze extends Rubrica {

    /**
     *  @brief struttura implementata per inserire i Contatti all'interno della sotto-rubrica "Emergenze"
     */
    private Map<Integer, Contatto> emergenze;
    

    public RubricaEmergenze() {
        this.emergenze = new HashMap<>();
    }
}