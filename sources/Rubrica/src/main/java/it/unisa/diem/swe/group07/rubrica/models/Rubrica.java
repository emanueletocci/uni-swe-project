/**
 * @file Rubrica.java
 * @brief in questo file è presente l'implementazione della classe Rubrica con i suoi metodi e attributi.
 * @author Gruppo07
 * @date Dicembre, 2024
 */
package it.unisa.diem.swe.group07.rubrica.models;

import java.util.Map;
import java.util.HashMap;
import java.util.Collection;

/**
 * @brief Classe che rappresenta una rubrica di contatti.
 *
 * La classe Rubrica gestisce una collezione di contatti, permettendo operazioni
 * come l'aggiunta, la rimozione, la ricerca e l'aggiornamento dei contatti.
 *
 * @see Contatto
 * @see ContattoEsteso
 */
public class Rubrica {

    /**
     *  @brief struttura dati della rubrica
     */
    private Map<Integer, Contatto> rubrica;

    /**
     *  @brief costruttore della rubrica
     */
    public Rubrica(){
        this.rubrica = new HashMap<>();
    }

    /**
     * @brief il metodo aggiunge un contatto alla rubrica e verifica se l'aggiunta é andata a buon fine.
     * @param[in] c Il contatto da aggiungere
     * @return 'true' se l'aggiunta del contatto nella rubrica va a buon fine, 'false' altrimenti
     */
    public Boolean aggiungiContatto(Contatto c) {
        if (rubrica.putIfAbsent(c.getId(), c) == null)
            return true;
        return false;
    }

    /**
     * @brief metodo per la rimozione di un contatto dalla rubrica
     * @param[in] c Il contatto da aggiungere
     * @return Il contatto rimosso
     */
    public Contatto rimuoviContatto(Contatto c){
        return rubrica.remove(c.getId());
    }

    /**
     *  @brief metodo ricerca di un contatto in rubrica
     *  @pre il contatto deve essere presente in rubrica
     *  @return Il contatto trovato
     */
    public Contatto ricercaContatto(Contatto c){
        return rubrica.get(c.getId());
    }
    /**
     *  @brief metodo restituisce tutti i contatti come una Collection
     *  @return Collection<Contatto>: una lista dei contatti della rubrica
     */
    public Collection<Contatto> getContatti(){
        return rubrica.values();
    }

    /**
     *  @brief il metodo consente di aggiornare un contatto esistente nella rubrica.
     *  @param[in] contattoAggiornato Il contatto con i dati nuovi
     *  @return 'true' se il contatto viene correttamente aggiornato, 'false' altrimenti
     */
    public Boolean aggiornaContatto(Contatto contattoAggiornato) {
        // Trova il contatto nella rubrica e sostituiscilo
        if (rubrica.containsKey(contattoAggiornato.getId())) {
            aggiungiContatto(contattoAggiornato);
            return true;
        }
        return false;
    }

    /**
     * @brief metodo toStirng()
     * @return una rappresentazione in formato stringa della rubrica
     */
    @Override
    public String toString() {
        return "\nRubrica\n" + getContatti();
    }
}