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
        this.rubrica = new HashMap<>();
    }

    /**
     * @brief metodo per l'aggiunta di un contatto alla rubrica
     * @param c: il contatto da aggiungere
     */
    public ContattoEsteso aggiungiContatto(ContattoEsteso c) {
        return rubrica.putIfAbsent(c.getId(), c);
    }

    /**
     * @brief il metodo aggiunge un contatto alla rubrica e verifica se l'aggiunta é andata a buon fine.
     * @param[in] c: il contatto da aggiungere
     * @return 'true' se l'aggiunta del contatto nella rubrica va a buon fine, 'false' altrimenti
     */
    public Boolean aggiungiContattoEVerifica(ContattoEsteso c){
        if (rubrica.putIfAbsent(c.getId(), c) == null)
            return true;
        return false;
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

    /**
     *  @brief il metodo consente di aggiornare un contatto esistente nella rubrica.
     *  @param[in] contattoAggiornato
     *  @return 'true' se il contatto viene correttamente aggiornato, 'false' altrimenti
     */
    public Boolean aggiornaContatto(ContattoEsteso contattoAggiornato) {
        // Trova il contatto nella rubrica e sostituiscilo
        if (rubrica.containsKey(contattoAggiornato.getId())) {
            aggiungiContattoEVerifica(contattoAggiornato);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "\nRubrica\n" + rubrica.values();
    }

    public String getVcard(ContattoEsteso c){
        StringBuffer sb=new StringBuffer();
        sb.append("VERSION:3.0");
        sb.append("\n");
        sb.append("FN:");
        sb.append(c.getNome()+" "+c.getCognome());
        sb.append("\n");
        sb.append("BDAY:");
        sb.append(c.getCompleanno());
        sb.append("\n");
        sb.append("GENDER:");
        sb.append("\n");
        sb.append("EMAIL;TYPE=work:");
        sb.append(c.getEmail1());
        sb.append("\n");
        return sb.toString();
    }

}