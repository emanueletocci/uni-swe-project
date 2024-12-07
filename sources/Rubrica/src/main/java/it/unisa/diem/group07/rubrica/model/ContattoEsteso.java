/**
 * @file ContattoEsteso.java
 * @brief questo file aggiunge informazioni aggiuntive al Contatto: compeanno, indirizzo di residenza e socialLinks.
 * @autor Gruppo07
 * @date Dicembre, 2024
 * @version 1.0
 */

package it.unisa.diem.group07.rubrica.model;
import it.unisa.diem.group07.rubrica.model.Contatto;
import javafx.scene.control.Hyperlink;
import java.time.LocalDate;

public class ContattoEsteso extends Contatto {
    /// @brief indirizzi email del contatto
    private String[] emails;
    /// @brief data di compleanno del contatto esteso
    private LocalDate compleanno;
    /// @brief indirizzo di residenza del contatto esteso
    private String indirizzoResidenza;
    /// @brief vettore contente i numeri telefonici associati al contatto
    /// @brief link relativo al social del contatto esteso
    private Hyperlink socialLinks;


    /**
     * @brief costruttore della classe Contatto Esteso
     */

    public ContattoEsteso(int id, String nome, String cognome, int[] telefoni, String [] emails, Boolean emergenza, Boolean preferito, LocalDate compleanno, String indirizzoResidenza, String socialLinks) {
        super(id, nome, cognome, telefoni, emails, emergenza, preferito);
        this.compleanno = compleanno;
        this.indirizzoResidenza = indirizzoResidenza;
        this.socialLinks = socialLinks;
    }


    /**
     * @return attributo compleanno
     * @brief metodo getter per l'attributo "compleanno"
     */

    public LocalDate getCompleanno() {
        return compleanno;
    }
        /**
         * @brief metodo setter per l'attributo "compleanno"
         */

        public void setCompleanno (LocalDate compleanno){
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
         * @brief metodo getter per l'attributo "socialLinks"
         * @return attributo indirizzoResidenza
         */
        public String getSocialLinks () {
            return socialLinks;
        }
        /**
         * @brief metodo setter per l'attributo "socialLinks"
         */
        public void setSocialLinks (String socialLinks){
            this.socialLinks = socialLinks;
        }
        /**
         * @brief metodo getter per l'attributo "emails"
         * @return lista degli indirizzi email in formato stringa
         */

        public String[] getEmails() {
            return emails;
        }

        /**
         * @brief metodo setter per l'attributo "emails"
         */

        public void setEmails(String[] emails) {
            this.emails = emails;
        }
    
}