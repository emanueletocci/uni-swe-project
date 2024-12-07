
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

    private Map<Integer, Contatto> rubrica;

    /**
     *  @brief costruttore della rubrica
     */

    public Rubrica(){
        this.rubrica = new HashMap<Integer, Contatto>();
    }

    /**
     * @brief metodo per l'aggiunta di un contatto alla rubrica
     * @param c: il contatto da aggiungere
     */
    public void aggiungiContatto(Contatto c){
        rubrica.put(c.getId(), c);
    }

    /**
     * @brief metodo per la rimozione di un contatto dalla rubrica
     * @return contatto rimosso
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
    /**
     *  @brief metodo restituisce tutti i contatti come una Collection
     *  @return Collectio<Contatto>: una lista dei contatti della rubrica
     */
    public Collection<Contatto> getContatti(){
        return rubrica.values();
    }

}
