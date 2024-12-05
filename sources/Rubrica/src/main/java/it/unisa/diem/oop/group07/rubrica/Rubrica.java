
package it.unisa.diem.oop.group07.rubrica;
import java.util.Map;


import java.util.Map.Entry;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.LinkedHashMap;
import java.util.Collection;
import java.util.Set;
import java.util.Iterator;

public class Rubrica {
    ///@brief struttura dati della rubrica
    Map<Integer, Contatto> rubrica;

    ///@brief costruttore della rubrica
    public Rubrica(){
        rubrica=new  HashMap<>();
    }

    /**
     * @brief metodo per l'aggiunta di un contatto alla rubrica
     */
    public void aggiungiContatto(Contatto c){
        rubrica.put(c.getId, c);
    }

    /**
     * @brief metodo per la rimozione di un contatto dalla rubrica
     */
    public Contatto rimuoviContatto(Contatto c){
        rubrica.remove(c.getId());
    }
    ///@brief metodo ricerca di un contatto in rubrica
    public Contatto ricercaContatto(Contatto c){}
    ///@brief metodo per export della rubrica
    public void esportaRubrica(){}
    ///@brief metodo per la lettura in un file
    public void importaRubrica(){}
}
