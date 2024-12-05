
package it.unisa.diem.group07.rubrica.model;
import it.unisa.diem.group07.rubrica.model.Contatto;
import javafx.beans.Observable;
import javafx.collections.ObservableMap;

import java.util.Map;

import java.util.Map.Entry;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.LinkedHashMap;
import java.util.Collection;
import java.util.Set;
import java.util.Iterator;

public class Rubrica {

    /**
     *  @brief struttura dati della rubrica
     */

    ObservableMap<Integer, Contatto> rubrica;

    /**
     *  @brief costruttore della rubrica
     */

    public Rubrica(){
        rubrica = new ObservableMap<Integer, Contatto>();
    }

    /**
     * @brief metodo per l'aggiunta di un contatto alla rubrica
     */
    public void aggiungiContatto(Contatto c){
        rubrica.put(c.getId, c);
    }

    /**
     * @brief metodo per la rimozione di un contatto dalla rubrica
     * @reuturn contatto rimosso
     */

    public Contatto rimuoviContatto(Contatto c){
        return rubrica.remove(c.getId());
    }

    /**
     *  @brief metodo ricerca di un contatto in rubrica
     *  @pre il contatto deve essere presente in rubrica
     *  @return contatto trovato
     */

    public Contatto ricercaContatto(Contatto c){}

}