/**
 * @file ContattoEsteso.java
 * @brief questo file aggiunge informazioni aggiuntive al Contatto: compeanno, indirizzo di residenza e socialLinks; E i suoi metodi
 * @author Gruppo07
 * @date Dicembre, 2024
 */

package it.unisa.diem.swe.group07.rubrica.models;
import java.time.LocalDate;
import java.util.Objects;

/**
 * @brief La classe é un'estensione della classe 'Contatto'. Un 'ContattoEsteso' definisce piú parametri rispetto ad un classico 'Contatto'.
 * @see Rubrica
 * @see Contatto
 */
public class ContattoEsteso extends Contatto {
    /**
     * @brief indirizzo email del contatto.
     */
    private String email1;

    /**
     * @brief indirizzo email 2 del contatto.
     */
    private String email2;

    /**
     * @brief indirizzo email 3 del contatto.
     */
    private String email3;

    /**
     * @brief data di compleanno del contatto esteso.
     */
    private LocalDate compleanno;

    /**
     * @brief indirizzo di residenza del contatto esteso.
     */
    private String indirizzoResidenza;

    /**
     * @brief link relativo al sito web del contatto esteso.
     */
    private String sitoWeb;
    
    /**
     * @brief note contenente informazioni aggiuntive riguardo al contatto.
     */
    private String note;

    /**
     * @brief costruttore della classe Contatto Esteso
     */
    public ContattoEsteso(String nome, String cognome, String telefono1, String telefono2, String telefono3, String email1, String email2, String email3, LocalDate compleanno, String indirizzoResidenza, String website, String note, Boolean preferito, Boolean emergenza) {
        super(nome, cognome, telefono1, telefono2, telefono3, preferito, emergenza);
        this.email1 = email1;
        this.email2 = email2;
        this.email3 = email3;
        this.compleanno = compleanno;
        this.indirizzoResidenza = indirizzoResidenza;
        this.sitoWeb = website;
        this.note=note;
        this.setId(generaId()); //sovrascrive il campo id presente in "Contatto"
    }

    /**
     * @brief costruttore della classe Contatto Esteso senza ingressi, serve per agevolare l'import
     * @post Il 'ContattoEsteso' istanziato é vuoto.
     */
    public ContattoEsteso(){
        super();
    }

    /**
     * @brief costruttore della classe Contatto Esteso senza ingressi, serve per agevolare l'import
     * @post Il 'ContattoEsteso' istanziato é vuoto.
     */
    public ContattoEsteso(String nome, String cognome, String telefono1, String telefono2, String telefono3, Boolean preferito, Boolean emergenza){
        super(nome, cognome, telefono1, telefono2, telefono3, preferito, emergenza);
        this.setId(generaId()); //sovrascrive il campo id presente in "Contatto"
    }

    /**
     * @brief metodo getter per l'attributo "compleanno"
     * @return compleanno, Attributo compleanno.
     */
    public LocalDate getCompleanno(){
        return compleanno;
    }

    /**
     * @param[in] compleanno, l'attributo da impostare nel relativo campo di contatto
     * @brief metodo setter per l'attributo "compleanno".
     */
    public void setCompleanno (LocalDate compleanno){
        this.compleanno = compleanno;
    }

    /**
     * @brief metodo getter per l'attributo "indirizzoResidenza"
     * @return attributo indirizzoResidenza.
     */
    public String getIndirizzoResidenza () {
        return indirizzoResidenza;
    }

    /**
     * @param[in] indirizzoResidenza, l'attributo da impostare nel relativo campo di contatto.
     * @brief metodo setter per l'attributo "indirizzoResidenza".
     */
    public void setIndirizzoResidenza (String indirizzoResidenza){
        this.indirizzoResidenza = indirizzoResidenza;
    }

    /**
     * @brief metodo getter per l'attributo "sitoWeb"
     * @return attributo sitoWeb.
     */
    public String getSitoWeb() {
        return sitoWeb;
    }

    /**
     * @param[in] webSite, l'attributo da impostare nel relativo campo di contatto
     * @brief metodo setter per l'attributo "sitoWeb"
     */
    public void setSitoWeb (String website){
        this.sitoWeb = website;
    }

    /**
     * @brief metodo getter per l'attributo "email3"
     * @return attributo email3
     */
    public String getEmail3() {
        return email3;
    }

    /**
     * param[in] email3, l'attributo da impostare nel relativo campo di contatto
     * @brief metodo setter per l'attributo "email3"
     */
    public void setEmail3(String email3) {
        this.email3 = email3;
    }

    /**
     * @brief metodo getter per l'attributo "email2"
     * @return attributo email2
     */
    public String getEmail2() {
        return email2;
    }

    /**
     * param[in] email2, l'attributo da impostare nel relativo campo di contatto
     * @brief metodo setter per l'attributo "email2"
     */
    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    /**
     * @brief metodo getter per l'attributo "email1"
     * @return attributo email1
     */
    public String getEmail1() {
        return email1;
    }

    /**
     * param[in] email1, l'attributo da impostare nel relativo campo di contatto
     * @brief metodo setter per l'attributo "email1"
     */
    public void setEmail1(String email1) {
        this.email1 = email1;
    }
    
    /**
     * @brief metodo getter per l'attributo "note"
     * @return attributo note
     */
    public String getNote() {
        return note;
    }

    /**
     * param[in] note, l'attributo da impostare nel relativo campo di contatto
     * @brief metodo setter per l'attributo "note"
     */
    public void setNote(String note) {
        this.note = note;
    }


    /**
     * @brief metodo per la stampa degli attributi 
     * @return attributi email1, email2, email3, compleanno, indirizzoResidenza e sitoWeb.
     */

    @Override
    public String toString() {
        return super.toString() +
                ", email1='" + email1 +
                ", email2='" + email2 +
                ", email3='" + email3 +
                ", compleanno='" + compleanno +
                ", indirizzoResidenza='" + indirizzoResidenza +
                ", sitoWeb='" + sitoWeb+
                ", note='" + note;
    }


    /**
     * @brief verifica l'uguaglianza tra due oggetti di tipo "ContattoEsteso".
     * @param[in] o, l'oggetto da confrontare.
     * @return 'true' se gli oggetti sono uguali, 'false' altrimenti.
     */

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ContattoEsteso)) return false;
        if (!super.equals(o)) return false;
        ContattoEsteso that = (ContattoEsteso) o;
        return Objects.equals(email1, that.email1) && Objects.equals(email2, that.email2) && Objects.equals(email3, that.email3) && Objects.equals(compleanno, that.compleanno) && Objects.equals(indirizzoResidenza, that.indirizzoResidenza) && Objects.equals(sitoWeb, that.sitoWeb);
    }

    /**
     * Calcola il valore hash per l'oggetto basandosi sui campi id, nome, cognome e compleanno.
     * @return il valore hash dell'oggetto.
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), compleanno);
    }

    /**
     * Calcola un ID numerico univoco utilizzando hashCode().
     * @return il valore hash dell'oggetto
     */
    @Override
    public Integer generaId(){
        String query = this.getNome() + this.getCognome() + compleanno;
        return query.hashCode();
    }
}