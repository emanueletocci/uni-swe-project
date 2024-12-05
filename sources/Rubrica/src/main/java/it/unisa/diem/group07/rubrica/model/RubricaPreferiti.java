/**
 * @file Preferiti.java
 * @brief questo file contiene l'implementazione della classe Preferiti utilizzata per aggiungere uno specifico contatto nella sezione "Preferiti"
 * @autor Gruppo07
 * @date Dicembre, 2024
 * @version 1.0
 */
package it.unisa.diem.group07.rubrica.model;
import it.unisa.diem.group07.rubrica.model.Contatto;
import it.unisa.diem.group07.rubrica.model.Rubrica;
import javafx.collections.ObservableMap;

import java.util.Map;

public class RubricaPreferiti extends Rubrica {

    /**
     *  @brief struttura implementata per inserire i Contatti all'interno della sotto-rubrica "Preferiti"
     */
    private ObservableMap<Integer, Contatto> emergenze;
}