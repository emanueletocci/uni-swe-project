package it.unisa.diem.swe.group07.rubrica.tests;

import it.unisa.diem.swe.group07.rubrica.models.ContattoEsteso;
import it.unisa.diem.swe.group07.rubrica.models.Rubrica;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class provaTest {
    public static void main(String[] args) {
        Rubrica r = new Rubrica();
        ContattoEsteso emanuele = new ContattoEsteso("Emanuele", "Tocci", "+3933333333", "+3933333333", "+3933333333", "prova@gmail.com", "prova@icloud.com", "prova@unisa.it", "09 Giugno", "via Prova", "unisa.it");
        ContattoEsteso claudia = new ContattoEsteso("Claudia", "Montefusco", "+3933333333", "+3933333333", "+3933333333", "prova@gmail.com", "prova@icloud.com", "prova@unisa.it", "09 Giugno", "via Prova", "unisa.it");
        r.aggiungiContatto(emanuele);
        r.aggiungiContatto(new ContattoEsteso("Alessio", "Leo", "+3933333333", "+3933333333", "+3933333333", "prova@gmail.com", "prova@icloud.com", "prova@unisa.it", "09 Giugno", "via Prova", "unisa.it"));
        r.aggiungiContatto(new ContattoEsteso("Rossella", "Pale", "+3933333333", "+3933333333", "+3933333333", "prova@gmail.com", "prova@icloud.com", "prova@unisa.it", "09 Giugno", "via Prova", "unisa.it"));
        r.aggiungiContatto(claudia);

        System.out.println("Rubrica: \n" + r.toString());
        System.out.println("\nEmanuele: " + emanuele.toString());
        System.out.println("\nRubrica Values \n: " + r.getContatti().toString());

        ObservableList listaContatti = FXCollections.observableArrayList(r.getContatti());
        System.out.println("\nContatti: " + listaContatti.toString());

    }

}
