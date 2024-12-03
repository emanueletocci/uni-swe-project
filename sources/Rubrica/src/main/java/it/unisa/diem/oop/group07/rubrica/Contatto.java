package it.unisa.diem.oop.group07.rubrica;

public class Contatto {
    private String nome;
    private String cognome;
    private String[] emails;
    private int[] numeri;
    private Boolean emergenza;
    private Boolean preferiti;

    public Contatto(String nome, String cognome, String[] emails, int[] numeri, Boolean emergenza, Boolean preferiti) {
        this.nome = nome;
        this.cognome = cognome;
        this.emails = emails;
        this.numeri = numeri;
        this.emergenza = emergenza;
        this.preferiti = preferiti;
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

    public String[] getEmails() {
        return emails;
    }

    public void setEmails(String[] emails) {
        this.emails = emails;
    }

    public int[] getNumeri() {
        return numeri;
    }

    public void setNumeri(int[] numeri) {
        this.numeri = numeri;
    }

    public Boolean getEmergenza() {
        return emergenza;
    }

    public void setEmergenza(Boolean emergenza) {
        this.emergenza = emergenza;
    }

    public Boolean getPreferiti() {
        return preferiti;
    }

    public void setPreferiti(Boolean preferiti) {
        this.preferiti = preferiti;
    }
}
