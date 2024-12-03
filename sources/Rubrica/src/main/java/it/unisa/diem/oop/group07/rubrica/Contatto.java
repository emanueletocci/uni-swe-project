

/**
 * @file Contatto.java
 * @brief questo file contiene l'implementazione del contatto da inserire all'interno della rubrica telefonica
 * @autor Gruppo07
 * @date Dicembre, 2024
 * @version 1.0
 */

package it.unisa.diem.oop.group07.rubrica;

public class Contatto {

    /// @brief nome del contatto
    private String nome;
    /// @brief cognome del contatto
    private String cognome;
    /// @brief vettore contente gli indirizzi email associati al contatto 
    private String[] emails;
    /// @brief vettore contente i numeri telefonici associati al contatto
    private int[] numeri;
    /// @brief attributo booleano che indica se il contatto é un "contatto di emergenza" oppure no
    private Boolean emergenza;
    /// @brief attributo booleano che indica se il contatto é un "contatto preferito" oppure no
    private Boolean preferiti;

    /**
     * @brief costruttore della classe Contatto
     */

    public Contatto(String nome, String cognome, String[] emails, int[] numeri, Boolean emergenza, Boolean preferiti) {
        this.nome = nome;
        this.cognome = cognome;
        this.emails = emails;
        this.numeri = numeri;
        this.emergenza = emergenza;
        this.preferiti = preferiti;
    }

    /**
     * @brief metodo getter per l'attributo "nome"
     * @return attributo nome
     */

    public String getNome() {
        return nome;
    }

    /**
     * @brief metodo setter per l'attributo "nome"
     */

    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @brief metodo getter per l'attributo "cognome"
     * @return attributo cognome
     */

    public String getCognome() {
        return cognome;
    }

    /**
     * @brief metodo setter per l'attributo "cognome"
     */

    public void setCognome(String cognome) {
        this.cognome = cognome;
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

    /**
     * @brief metodo getter per l'attributo "numeri"
     * @return lista dei numeri telefonici in formato stringa
     */
    
    public int[] getNumeri() {
        return numeri;
    }

    /**
     * @brief metodo setter per l'attributo "numeri"
     */

    public void setNumeri(int[] numeri) {
        this.numeri = numeri;
    }

    /**
     * @brief metodo getter per l'attributo "emergenza"
     * @return attributo emergenza
     */

    public Boolean getEmergenza() {
        return emergenza;
    }

    /**
     * @brief metodo setter per l'attributo "emergenza"
     */

    public void setEmergenza(Boolean emergenza) {
        this.emergenza = emergenza;
    }

    /**
     * @brief metodo getter per l'attributo "preferiti"
     * @return attributo preferiti
     */
    
    public Boolean getPreferiti() {
        return preferiti;
    }

    /**
     * @brief metodo setter per l'attributo "preferiti"
     */

    public void setPreferiti(Boolean preferiti) {
        this.preferiti = preferiti;
    }
}
