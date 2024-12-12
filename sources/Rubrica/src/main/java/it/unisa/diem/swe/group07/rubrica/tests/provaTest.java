package it.unisa.diem.swe.group07.rubrica.tests;

import it.unisa.diem.swe.group07.rubrica.gestoreIO.Export;
import it.unisa.diem.swe.group07.rubrica.models.ContattoEsteso;
import it.unisa.diem.swe.group07.rubrica.models.Rubrica;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;

public class provaTest {
    public static void main(String[] args) {
        Rubrica r = new Rubrica();
        ContattoEsteso emanuele = new ContattoEsteso("Emanuele", "Tocci", "+3933333333", "+3933333333", "+3933333333", "prova@gmail.com", "prova@icloud.com", "prova@unisa.it", LocalDate.of(2003, 6, 9), "via Prova", "unisa.it", "note", false, false);
        ContattoEsteso claudia = new ContattoEsteso("Claudia", "Montefusco", "+3933333333", "+3933333333", "+3933333333", "prova@gmail.com", "prova@icloud.com", "prova@unisa.it", LocalDate.of(2020, 12, 12), "via Prova", "unisa.it", "note", false, false);
        if(r.aggiungiContattoEVerifica(emanuele))
            System.out.println("\nemanuele aggiunto correttamente");
        else
            System.out.println("\nErrore nell'aggiunta del contatto!");
        r.aggiungiContattoEVerifica(new ContattoEsteso("Alessio", "Leo", "+3933333333", "+3933333333", "+3933333333", "prova@gmail.com", "prova@icloud.com", "prova@unisa.it", LocalDate.of(2020, 12, 12), "via Prova", "unisa.it", "note", false, false));
        r.aggiungiContattoEVerifica(new ContattoEsteso("Rossella", "Pale", "+3933333333", "+3933333333", "+3933333333", "prova@gmail.com", "prova@icloud.com", "prova@unisa.it", LocalDate.of(2020, 12, 12), "via Prova", "unisa.it", "note", true, true));
        r.aggiungiContattoEVerifica(new ContattoEsteso("Rossella", "Pale", "+3933333333", "+3933333333", "+3933333333", "prova@gmail.com", "prova@icloud.com", "prova@unisa.it", LocalDate.of(2020, 12, 12), "via Prova", "unisa.it", "note", true, true));

        r.aggiungiContattoEVerifica(claudia);    //duplicato
        r.aggiungiContattoEVerifica(new ContattoEsteso("Rossella", "Pale", "+3933333333", "+3933333333", "+3933333333", "prova@gmail.com", "prova@icloud.com", "prova@unisa.it",null,null,null,null,null,null));

        System.out.println("Rubrica: \n" + r.toString());
        System.out.println("\nEmanuele: " + emanuele.toString());
        System.out.println("\nRubrica Values \n: " + r.getContatti().toString());

        ObservableList listaContatti = FXCollections.observableArrayList(r.getContatti());
        System.out.println("\nContatti: " + listaContatti.toString());

        StringBuilder sb = new StringBuilder();
        sb.append("BEGIN:VCARD\n")
                .append("VERSION:3.0\n")
                .append("FN:Emanuele Tocci\n")
                .append("TEL;TYPE=cell:+3933333333\n")
                .append("TEL;TYPE=home:+3933333333\n")
                .append("TEL;TYPE=work:+3933333333\n")
                .append("EMAIL;TYPE=work:prova@gmail.com\n")
                .append("EMAIL;TYPE=home:prova@icloud.com\n")
                .append("EMAIL;TYPE=other:prova@unisa.it\n")
                .append("BDAY:2003-06-09\n")
                .append("ADR;TYPE=home:via Prova\n")
                .append("URL:unisa.it\n")
                .append("NOTE:note\n")
                .append("END:VCARD\n");
        System.out.println("\nVCARD MANUALE\n" + sb.toString());

        Export e = new Export();
        String vcard = e.getVcard(emanuele);
        System.out.println("\nVCARD\n" + vcard);

        if(vcard.equals(sb.toString()))
            System.out.println("\nLe stringhe sono uguali!");
        else
            System.out.println("Le stringhe sono diverse!");
    }

}
