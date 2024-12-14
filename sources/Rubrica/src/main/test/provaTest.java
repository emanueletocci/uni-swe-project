import it.unisa.diem.swe.group07.rubrica.gestoreIO.Export;
import it.unisa.diem.swe.group07.rubrica.models.Contatto;
import it.unisa.diem.swe.group07.rubrica.models.ContattoEsteso;
import it.unisa.diem.swe.group07.rubrica.models.Rubrica;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;

public class provaTest {
    public static void main(String[] args) {
        Rubrica r = new Rubrica();
        ContattoEsteso emanuele = new ContattoEsteso("Emanuele", "Tocci", "+3933333333", "+3933333333", "+3933333333", "prova@gmail.com", "prova@icloud.com", "prova@unisa.it", LocalDate.of(2003, 6, 9), "via Prova", "unisa.it", "note", false, false);
        Contatto claudia = new Contatto("Claudia", "MOntefusco", "10", "10", "10",false, true);
        r.aggiungiContatto(claudia);
    }

}
