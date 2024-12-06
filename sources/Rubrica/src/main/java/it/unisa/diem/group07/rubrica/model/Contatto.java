/**
 * @file Contatto.java
 * @brief questo file contiene l'implementazione del contatto da inserire all'interno della rubrica telefonica
 * @autor Gruppo07
 * @date Dicembre, 2024
 * @version 1.0
 */

package it.unisa.diem.group07.rubrica.model;

import java.util.Comparator;

public class Contatto {

    /**
     * @brief identificativo univoco (key) del contatto
     */

    private static int id=0;

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
    private int[] telefoni;

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
    public Contatto(int id, String nome, String cognome, int[] telefoni, Boolean emergenza, Boolean preferito) {
        this.id = id;
        this.nome = nome !=null? nome :"" ;
        this.cognome = cognome!=null? nome :"";
        this.telefoni = telefoni;
        this.emergenza = emergenza;
        this.preferito = preferito;
        id++;
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
    public int[] getTelefoni() {
        return telefoni;
    }

    /**
     * @brief metodo setter per l'attributo "numeri"
     */
    public void setTelefoni(int[] numeri) {
        this.telefoni = numeri;
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
    
    
    
    /*public static Comparator<Contatto> ordinaAlfabetico(){
        return new Comparator<Contatto>(){
        @Override
        public int compare(Contatto c1, Contatto c2){
         int risultato=c1.getNome().compareToIgnoreCase(c2.getNome());
         if(risultato!=0){
             return risultato;
         }
         return c1.getCognome().compareToIgnoreCase(c2.getCognome());
        }
    };*/
        
    }
}