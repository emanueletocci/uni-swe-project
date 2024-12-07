/**
 * @file Contatto.java
 * @brief questo file contiene l'implementazione del contatto da inserire all'interno della rubrica telefonica
 * @autor Gruppo07
 * @date Dicembre, 2024
 * @version 1.0
 */

package it.unisa.diem.group07.rubrica.model;

public class Contatto {

    /**
     * @brief identificativo univoco (key) del contatto
     */
    private int id;

    /**
     * @brief nome del contatto
     */
    private String nome;

    /**
     * @brief cognome del contatto
     */
    private String cognome;

    /**
     * @brief numeri telefonici del contatto
     */
    private int[] numeri;

    /**
     * @brief attributo booleano che indica se il contatto é un "contatto di emergenza" oppure no
     */
    private Boolean emergenza;

    /**
     * @brief attributo booleano che indica se il contatto é un "contatto preferito" oppure no
     */
    private Boolean preferito;

    /**
     * @brief costruttore della classe Contatto
     */
    public Contatto(int id, String nome, String cognome, int[] numeri, Boolean emergenza, Boolean preferito) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.numeri = numeri;
        this.emergenza = emergenza;
        this.preferito = preferito;
    }

    /**
     * @brief metodo getter per l'attributo "id"
     * @return attributo id
     */
    public int getId(){
        return id;
    }

    /**
     * @brief metodo setter per l'attributo "id"
     */
    public void setId(){
        this.id=id;
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
     * @brief metodo getter per l'attributo "preferito"
     * @return attributo preferito
     */
    public Boolean getPreferito() {
        return preferito;
    }

    /**
     * @brief metodo setter per l'attributo "preferito"
     */
    public void setPreferito(Boolean preferito) {
        this.preferito = preferito;
    }

    /**
     * @brief metodo per la verifica del numero telefonico del contatto
     * @return "true" se il numero inserito é valido, "false" altrimenti
     */
    public Boolean controllaTelefono(String telefono){
        return true;
    }
}