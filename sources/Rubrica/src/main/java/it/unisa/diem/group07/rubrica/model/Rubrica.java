
package it.unisa.diem.group07.rubrica.model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;

public class Rubrica {

    /**
     *  @brief struttura dati della rubrica
     */

    ObservableMap<Integer, Contatto> rubrica;

    /**
     *  @brief costruttore della rubrica
     */

    public Rubrica(){
        rubrica = FXCollections.observableHashMap();
    }

    /**
     * @brief metodo per l'aggiunta di un contatto alla rubrica
     */
    public void aggiungiContatto(Contatto c){
        rubrica.put(c.getId(), c);
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

    public Contatto ricercaContatto(Contatto c){
        return rubrica.get(c.getId());
    }

}