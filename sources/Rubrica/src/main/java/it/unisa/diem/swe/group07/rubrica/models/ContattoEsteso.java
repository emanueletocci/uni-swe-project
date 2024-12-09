/**
 * @file ContattoEsteso.java
 * @brief questo file aggiunge informazioni aggiuntive al Contatto: compeanno, indirizzo di residenza e socialLinks.
 * @autor Gruppo07
 * @date Dicembre, 2024
 * @version 1.0
 */

package it.unisa.diem.swe.group07.rubrica.models;
public class ContattoEsteso extends Contatto {
    /**
     * @brief indirizzi email del contatto
     */
    private String email1;

    /**
     * @brief indirizzi email del contatto
     */
    private String email2;

    /**
     * @brief indirizzi email del contatto
     */
    private String email3;

    /**
     * @brief data di compleanno del contatto esteso
     */
    private String compleanno;

    /**
     * @brief indirizzo di residenza del contatto esteso
     */
    private String indirizzoResidenza;

    /**
     * @brief link relativo al social del contatto esteso
     */
    private String sitoWeb;

    /**
     * @brief costruttore della classe Contatto Esteso
     */

    public ContattoEsteso(String nome, String cognome, String telefono1, String telefono2, String telefono3, String email1, String email2, String email3, String compleanno, String indirizzoResidenza, String website) {
        super(nome, cognome, telefono1, telefono2, telefono3);
        this.email1 = email1;
        this.email2 = email2;
        this.email3 = email3;
        this.compleanno = compleanno;
        this.indirizzoResidenza = indirizzoResidenza;
        this.sitoWeb = website;
    }

    /**
     * @return attributo compleanno
     * @brief metodo getter per l'attributo "compleanno"
     */
    public String getCompleanno(){
        return compleanno;
    }

    /**
     * @brief metodo setter per l'attributo "compleanno"
     */
    public void setCompleanno (String compleanno){
        this.compleanno = compleanno;
    }

    /**
     * @brief metodo getter per l'attributo "indirizzoResidenza"
     * @return attributo indirizzoResidenza
     */
    public String getIndirizzoResidenza () {
        return indirizzoResidenza;
    }

    /**
     * @brief metodo setter per l'attributo "indirizzoResidenza"
     */
    public void setIndirizzoResidenza (String indirizzoResidenza){
        this.indirizzoResidenza = indirizzoResidenza;
    }

    /**
     * @brief metodo getter per l'attributo "sitoWeb"
     * @return attributo sitoWeb
     */
    public String getSitoWeb() {
        return sitoWeb;
    }

    /**
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
     * @brief metodo setter per l'attributo "email1"
     */
    public void setEmail1(String email1) {
        this.email1 = email1;
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
                ", sitoWeb='" + sitoWeb;
    }
}