/**
 * @file Contatto.java
 * @brief questo file contiene l'implementazione del contatto da inserire all'interno della rubrica telefonica
 * @autor Gruppo07
 * @date Dicembre, 2024
 * @version 1.0
 */

package it.unisa.diem.swe.group07.rubrica.models;

import java.util.Objects;
import java.util.UUID;

public class Contatto {

    /**
     * @brief identificativo univoco (key) del contatto
     */
    private UUID id;

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
    private Boolean emergenza;

    /**
     * @brief attributo booleano che indica se il contatto é un "contatto preferito" oppure no
     */
    private Boolean preferito;

    /**
     * @brief costruttore della classe Contatto
     */
    public Contatto(String nome, String cognome, String telefono1, String telefono2, String telefono3, Boolean preferito, Boolean emergenza) {
        this.id = UUID.randomUUID();    //genera un id univoco (key) per l'oggetto istanziato
        this.nome = nome;
        this.cognome = cognome;
        this.telefono1 = telefono1;
        this.telefono2 = telefono2;
        this.telefono3 = telefono3;
        this.emergenza = emergenza;
        this.preferito = preferito;
    }

    /**
     * @brief metodo getter per l'attributo "id"
     * @return attributo id
     */
    public UUID getId(){
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
     * @brief metodo getter per l'attributo "telefono1"
     * @return attributo telefono1
     */
    public String getTelefono1() {
        return telefono1;
    }

    
    /**
     * @brief metodo setter per l'attributo "telefono1"
     */
    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    /**
     * @brief metodo getter per l'attributo "telefono2"
     * @return attributo telefono2
     */
    public String getTelefono2() {
        return telefono2;
    }
    
    /**
     * @brief metodo setter per l'attributo "telefono2"
     */
    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

     /**
     * @brief metodo getter per l'attributo "telefono3"
     * @return attributo telefono2
     */
    public String getTelefono3() {
        return telefono3;
    }
    
    /**
     * @brief metodo setter per l'attributo "telefono3"
     */
    public void setTelefono3(String telefono3) {
        this.telefono3 = telefono3;
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
        return telefono.matches("^\\+?[0-9]{6,15}$");
        //regex: ^ inizio stringa, \\+ rappresenta il simbolo + (il primo backslash é per escape), ? indica che il simbolo precedente (+) é opzionale, [0-9]{6,15} si possono inserire da 6 a 15 cifre numeriche, $ fine della stringa
    }

    /**
     * @brief metodo per la stampa degli attributi 
     * @return attributi nome, cognome, telefono1, telefono2, telefono3
     */
    @Override
    public String toString() {
        return "\nid=" + id +
                ", nome=" + nome  +
                ", cognome=" + cognome +
                ", telefono1=" + telefono1 +
                ", telefono2=" + telefono2 +
                ", telefono3=" + telefono3;
    }

    /**
     * @brief metodo che consente di confrontare 2 contatti
     * @return 'true' se i due contatti confrontati sono uguali, 'false' se sono diversi
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Contatto)) return false;
        Contatto contatto = (Contatto) o;
        return Objects.equals(id, contatto.id) && Objects.equals(nome, contatto.nome) && Objects.equals(cognome, contatto.cognome) && Objects.equals(telefono1, contatto.telefono1) && Objects.equals(telefono2, contatto.telefono2) && Objects.equals(telefono3, contatto.telefono3);
    }

    /**
     * @brief Calcola il valore hash per l'oggetto basandosi sui campi id, nome, cognome e telefoni
     * @return valore hash dell'oggetto
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, nome, cognome, telefono1, telefono2, telefono3);
    }


}