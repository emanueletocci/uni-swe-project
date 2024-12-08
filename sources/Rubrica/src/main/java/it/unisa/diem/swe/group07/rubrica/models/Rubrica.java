
package it.unisa.diem.swe.group07.rubrica.models;
import java.util.Map;

import java.util.HashMap;
import java.util.Collection;

public class Rubrica {

    /**
     *  @brief struttura dati della rubrica
     */

    private Map<Integer, ContattoEsteso> rubrica;

    /**
     *  @brief costruttore della rubrica
     */

    public Rubrica(){
        this.rubrica = new HashMap<Integer, ContattoEsteso>();
    }

    /**
     * @brief metodo per l'aggiunta di un contatto alla rubrica
     * @param c: il contatto da aggiungere
     */
    public void aggiungiContatto(ContattoEsteso c){
        rubrica.put(c.getId(), c);
    }

    /**
     * @brief metodo per la rimozione di un contatto dalla rubrica
     * @return contatto rimosso
     */

    public ContattoEsteso rimuoviContatto(ContattoEsteso c){
        return rubrica.remove(c.getId());
    }

    /**
     *  @brief metodo ricerca di un contatto in rubrica
     *  @pre il contatto deve essere presente in rubrica
     *  @return contatto trovato
     */

    public ContattoEsteso ricercaContatto(ContattoEsteso c){
        return rubrica.get(c.getId());
    }
    /**
     *  @brief metodo restituisce tutti i contatti come una Collection
     *  @return Collection<ContattoEsteso>: una lista dei contatti della rubrica
     */
    public Collection<ContattoEsteso> getContatti(){
        return rubrica.values();
    }

}