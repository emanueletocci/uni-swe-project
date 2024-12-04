

/**
 * @file ContattoEsteso.java
 * @brief questo file aggiunge informazioni aggiuntive al Contatto: compeanno, indirizzo di residenza e socialLinks.
 * @autor Gruppo07
 * @date Dicembre, 2024
 * @version 1.0
 */
package it.unisa.diem.oop.group07.rubrica;
public class ContattoEsteso extends Contatto{
    ///@brief data di compleanno del contatto esteso
    private LocalDate compleanno;
     ///@brief indirizzo di residenza del contatto esteso
    private String indirizzoResidenza;
     ///@brief link relativo al social del contatto esteso
    private String socialLinks;


    /**
     * @brief costruttore della classe Contatto Esteso
     */

    public ContattoEsteso(String nome, String cognome, String[] emails, int[] numeri, Boolean emergenza, Boolean preferiti, LocalDate compleanno, String indirizzoResidenza, String socialLinks) {
        super(nome, cognome, emails, numeri, emergenza, preferiti);
        this.compleanno = compleanno;
        this.indirizzoResidenza = indirizzoResidenza;
        this.socialLinks = socialLinks;
    }


     /**
     * @brief metodo getter per l'attributo "compleanno"
     * @return attributo compleanno
     */

    public LocalDate getCompleanno() {
        return compleanno;
    /**
     * @brief metodo setter per l'attributo "compleanno"
     */


    public void setCompleanno(LocalDate compleanno) {
        this.compleanno = compleanno;
    }
    /**
     * @brief metodo getter per l'attributo "indirizzoResidenza"
     * @return attributo indirizzoResidenza
     */
    public String getIndirizzoResidenza() {
        return indirizzoResidenza;
    }
    /**
     * @brief metodo setter per l'attributo "indirizzoResidenza"
     */
    public void setIndirizzoResidenza(String indirizzoResidenza) {
        this.indirizzoResidenza = indirizzoResidenza;
    }
    /**
     * @brief metodo getter per l'attributo "socialLinks"
     * @return attributo indirizzoResidenza
     */
    public String getSocialLinks() {
        return socialLinks;
    }
        /**
     * @brief metodo setter per l'attributo "socialLinks"
     */
    public void setSocialLinks(String socialLinks) {
        this.socialLinks = socialLinks;
    }
}
