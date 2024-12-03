package it.unisa.diem.oop.group07.rubrica;

public class ContattoEsteso extends Contatto{
    private LocalDate compleanno;
    private String indirizzoResidenza;
    private String socialLinks;

    public ContattoEsteso(String nome, String cognome, String[] emails, int[] numeri, Boolean emergenza, Boolean preferiti, LocalDate compleanno, String indirizzoResidenza, String socialLinks) {
        super(nome, cognome, emails, numeri, emergenza, preferiti);
        this.compleanno = compleanno;
        this.indirizzoResidenza = indirizzoResidenza;
        this.socialLinks = socialLinks;
    }

    public LocalDate getCompleanno() {
        return compleanno;
    }

    public void setCompleanno(LocalDate compleanno) {
        this.compleanno = compleanno;
    }

    public String getIndirizzoResidenza() {
        return indirizzoResidenza;
    }

    public void setIndirizzoResidenza(String indirizzoResidenza) {
        this.indirizzoResidenza = indirizzoResidenza;
    }

    public String getSocialLinks() {
        return socialLinks;
    }

    public void setSocialLinks(String socialLinks) {
        this.socialLinks = socialLinks;
    }
}
