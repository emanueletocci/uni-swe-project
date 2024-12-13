/**
 * @file Contatto.java
 * @brief questo file contiene l'implementazione del contatto, da inserire all'interno della rubrica telefonica, e i suoi metodi.
 * @author Gruppo07
 * @date Dicembre, 2024
 * @version 1.0
 */
package it.unisa.diem.swe.group07.rubrica.models;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import java.util.Objects;

/**
 * @brief La classe rappresenta generico Contatto aggiungibile nella rubrica.
 * @see Rubrica
 * @see ContattoEsteso
 */
public class Contatto {

    /**
     * @brief identificativo univoco (key) del contatto.
     */
    private Integer id;

    /**
     * @brief nome del contatto.
     */
    private String nome;

    /**
     * @brief cognome del contatto.
     */
    private String cognome;

    /**
     *
     * @brief numero telefonico 1 del contatto.
     */
    private String telefono1;

    /**
     * @brief numero telefonico 2 del contatto.
     */
    private String telefono2;

    /**
     * @brief numero telefonico 3 del contatto.
     */
    private String telefono3;

    /**
     * @brief attributo booleano che indica se il contatto é un "contatto di emergenza" oppure no.
     */
    private Boolean emergenza;

    /**
     * @brief attributo booleano che indica se il contatto é un "contatto preferito" oppure no.
     */
    private Boolean preferito;

    /**
     * @brief costruttore della classe Contatto.
     */
    public Contatto(String nome, String cognome, String telefono1, String telefono2, String telefono3, Boolean preferito, Boolean emergenza) {
        this.nome = nome;
        this.cognome = cognome;
        this.telefono1 = telefono1;
        this.telefono2 = telefono2;
        this.telefono3 = telefono3;
        this.emergenza = emergenza;
        this.preferito = preferito;
        id = generaId();
    }
    /**
     * @brief costruttore della classe Contatto senza ingressi
     * @post Il contatto istanziato é vuoto.
     */
    public Contatto(){};

    /**
     * @brief metodo getter per l'attributo "id".
     * @return id Attributo id.
     */
    public Integer getId(){
        return id;
    }

    /**
     * @param[in] id L'attributo da impostare nel relativo campo di contatto.
     * @brief metodo setter per l'attributo "id".
     */
    public void setId(Integer id){
        this.id=id;
    }

    /**
     * @brief metodo getter per l'attributo "nome".
     * @return nome Attributo nome.
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param[in] nome L'attributo da impostare nel relativo campo di contatto.
     * @brief metodo setter per l'attributo "nome".
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
     * @param[in] cognome L'attributo da impostare nel relativo campo di contatto.
     * @brief metodo setter per l'attributo "cognome".
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
     /**
     * @brief metodo getter per l'attributo "telefono1".
     * @return attributo telefono1.
     */
    public String getTelefono1() {
        return telefono1;
    }

    
    /**
     * @param[in] telefono1, l'attributo da impostare nel relativo campo di contatto.
     * @brief metodo setter per l'attributo "telefono1".
     */
    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    /**
     * @brief metodo getter per l'attributo "telefono2".
     * @return attributo telefono2.
     */
    public String getTelefono2() {
        return telefono2;
    }
    
    /**
     * @param[in] telefono2, l'attributo da impostare nel relativo campo di contatto.
     * @brief metodo setter per l'attributo "telefono2".
     */
    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

     /**
     * @param[in] telefono3 L'attributo da impostare nel relativo campo di contatto.
     * @brief metodo getter per l'attributo "telefono3".
     * @return attributo telefono2.
     */
    public String getTelefono3() {
        return telefono3;
    }
    
    /**
     * @brief metodo setter per l'attributo "telefono3".
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
     * @param[in] emergenza, l'attributoda impostare nella relativa flag di contatto
     * @brief metodo setter per l'attributo "emergenza"
     */
    public void setEmergenza(Boolean emergenza) {
        this.emergenza = emergenza;
    }

    /**
     * @brief metodo getter per l'attributo "preferito".
     * @return attributo preferito.
     */
    public Boolean getPreferito() {
        return preferito;
    }

    /**
     * @param[in] preferito, l'attributoda impostare nella relativa flag di contatto.
     * @brief metodo setter per l'attributo "preferito".
     */
    public void setPreferito(Boolean preferito) {
        this.preferito = preferito;
    }


    /**
     * @brief metodo per la stampa degli attributi .
     * @param[out] id, nome, cognome, telefono1, telefono2, telefono3, preferito, emergenza.
     * @return Rappresentazione in forma di stringa del contatto.
     */
    @Override
    public String toString() {
        return "\nid=" + id +
                ", nome=" + nome  +
                ", cognome=" + cognome +
                ", telefono1=" + telefono1 +
                ", telefono2=" + telefono2 +
                ", telefono3=" + telefono3 +
                ", preferito=" + preferito +
                ", emergenza=" + emergenza;
     }

    /**
     * @brief metodo che consente di confrontare 2 contatti
     * @return 'true' se i due contatti confrontati sono uguali, 'false' se sono diversi
     * @param[in] o Oggetto generico.
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Contatto)) return false;
        Contatto contatto = (Contatto) o;
        return Objects.equals(id, contatto.id) && Objects.equals(nome, contatto.nome) && Objects.equals(cognome, contatto.cognome) && Objects.equals(telefono1, contatto.telefono1) && Objects.equals(telefono2, contatto.telefono2) && Objects.equals(telefono3, contatto.telefono3);
    }

    /**
     * @brief controlla se un contatto è preferito.
     * @return Restituisce la proprietà che indica se il contatto è preferito.
     */
    public BooleanProperty isPreferito() {
        return new SimpleBooleanProperty(getPreferito());
    }
    /**
     * @brief controlla se un contatto è d'emergenza
     * @return Restituisce la proprietà che indica se il contatto è d'emergenza.
     */
    public BooleanProperty isEmergenza(){
        return new SimpleBooleanProperty(getEmergenza());
    }
    /**
     * @brief Calcola il valore hash per l'oggetto basandosi sui campi id, nome, cognome.
     * @return valore hash dell'oggetto.
     */
    @Override
    public int hashCode() {
        return Objects.hash(nome, cognome);
    }

    /**
     * Calcola un ID numerico univoco utilizzando hashCode().
     * @return il valore hash dell'oggetto.
     */
    protected Integer generaId(){
        String query = this.getNome() + this.getCognome();
        return query.hashCode();
    }
}