/**
 * @file Contatto.java
 * @brief questo file contiene l'implementazione del contatto da inserire all'interno della rubrica telefonica
 * @autor Gruppo07
 * @date Dicembre, 2024
 * @version 1.0
 */


package provapackage;

public class Contatto {
    private int id=0;
    private int idContatto;
    private String nome;
    private String cognome;
    private String telefono;
    private String email;
    private String indirizzo;
    private String compleanno;
    private String sitoWeb;

    public Contatto(String nome, String cognome, String telefono, String email, String compleanno, String indirizzo, String sitoWeb) {
        this.nome = nome;
        this.cognome = cognome;
        this.telefono = telefono;
        this.email = email;
        this.compleanno = compleanno;
        this.indirizzo = indirizzo;
        this.sitoWeb = sitoWeb;
        this.idContatto=id;
        id++;
    }

    // Getters e Setters
    public int getId() { return idContatto; }
    public String getNome() { return nome; }
    public String getCognome() { return cognome; }
    public String getTelefono() { return telefono; }
    public String getEmail() { return email; }
    public String getIndirizzo() { return indirizzo; }
    public String getCompleanno() { return compleanno; }
    public String getSitoWeb() { return sitoWeb; }

    public void setId(int id) { this.id = id; }
    public void setNome(String nome) { this.nome = nome; }
    public void setCognome(String cognome) { this.cognome = cognome; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public void setEmail(String email) { this.email = email; }
    public void setIndirizzo(String indirizzo) { this.indirizzo = indirizzo; }
    public void setCompleanno(String compleanno) { this.compleanno = compleanno; }
    public void setSitoWeb(String sitoWeb) { this.sitoWeb = sitoWeb; }
}