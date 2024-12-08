/**
 * @file Contatto.java
 * @brief questo file contiene l'implementazione del contatto da inserire all'interno della rubrica telefonica
 * @autor Gruppo07
 * @date Dicembre, 2024
 * @version 1.0
 */

package it.unisa.diem.swe.group07.rubrica.models;
public class Contatto {

    /**
     * @brief identificativo univoco (key) del contatto
     */
    private int id;

    /**
     * @brief variabile temporanea per il conteggio degli elementi istanziati
     */
    private static int counter = 0;

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
    private String telefono1;

    /**
     * @brief numeri telefonici del contatto
     */
    private String telefono2;

    /**
     * @brief numeri telefonici del contatto
     */
    private String telefono3;

    /**
     * @brief attributo booleano che indica se il contatto é un "contatto di emergenza" oppure no
     */
    //private Boolean emergenza;

    /**
     * @brief attributo booleano che indica se il contatto é un "contatto preferito" oppure no
     */
    //private Boolean preferito;

    /**
     * @brief costruttore della classe Contatto
     */
    public Contatto(String nome, String cognome, String telefono1, String telefono2, String telefono3) {
        counter++;
        id = counter;
        this.nome = nome;
        this.cognome = cognome;
        this.telefono1 = telefono1;
        this.telefono2 = telefono2;
        this.telefono3 = telefono3;
        //this.emergenza = emergenza;
        //this.preferito = preferito;
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

    public String getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    public String getTelefono3() {
        return telefono3;
    }

    public void setTelefono3(String telefono3) {
        this.telefono3 = telefono3;
    }

    /**
     * @brief metodo getter per l'attributo "emergenza"
     * @return attributo emergenza
     */
//    public Boolean getEmergenza() {
//        return emergenza;
//    }

    /**
     * @brief metodo setter per l'attributo "emergenza"
     */
//    public void setEmergenza(Boolean emergenza) {
//        this.emergenza = emergenza;
//    }

    /**
     * @brief metodo getter per l'attributo "preferito"
     * @return attributo preferito
     */
//    public Boolean getPreferito() {
//        return preferito;
//    }

    /**
     * @brief metodo setter per l'attributo "preferito"
     */
//    public void setPreferito(Boolean preferito) {
//        this.preferito = preferito;
//    }

    /**
     * @brief metodo per la verifica del numero telefonico del contatto
     * @return "true" se il numero inserito é valido, "false" altrimenti
     */
    public Boolean controllaTelefono(String telefono){
        return true;
    }

    @Override
    public String toString() {
        return "\nnome=" + nome  +
                ", cognome=" + cognome +
                ", telefono1=" + telefono1 +
                ", telefono2=" + telefono2 +
                ", telefono3=" + telefono3;
    }
}