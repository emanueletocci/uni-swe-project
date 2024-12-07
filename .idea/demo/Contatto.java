/**
 * @file Contatto.java
 * @brief questo file contiene l'implementazione del contatto da inserire all'interno della rubrica telefonica
 * @autor Gruppo07
 * @date Dicembre, 2024
 * @version 1.0
 */


public class Contatto {

    private static int id=0;

    private String nome;

    private String cognome;

    private int[] telefoni;

    private Boolean emergenza;

    private Boolean preferito;

    private String[] emails;

    public Contatto(String nome, String cognome, String[] emails, int[] telefoni, Boolean emergenza, Boolean preferito) {
        this.nome = nome != null ? nome : "";
        this.cognome = cognome != null ? cognome : "";
        this.telefoni = telefoni != null ? telefoni : new int[3]; // Inizializza se telefoni è null
        this.emails = emails != null ? emails : new String[3]; // Inizializza se emails è null
        this.emergenza = emergenza;
        this.preferito = preferito;
        this.id = id;
        id++; // Incrementa l'id statico per il prossimo contatto
    }
    public Contatto(String nome) {
        this.nome = nome;
    }

    public int getId(){
        return id;
    }

    public void setId(){
        this.id=id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public int[] getTelefoni() {
        return telefoni;
    }

    public void setTelefoni(int[] numeri) {
        this.telefoni = numeri;
    }

    public Boolean getEmergenza() {
        return emergenza;
    }

    public void setEmergenza(Boolean emergenza) {
        this.emergenza = emergenza;
    }

    public Boolean getPreferito() {
        return preferito;
    }

    public void setPreferito(Boolean preferito) {
        this.preferito = preferito;
    }


    public Boolean controllaTelefono(String telefono){
        return true;
    }





}