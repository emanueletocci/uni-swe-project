/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import it.unisa.diem.swe.group07.rubrica.gestoreIO.Export;
import it.unisa.diem.swe.group07.rubrica.gestoreIO.Import;
import it.unisa.diem.swe.group07.rubrica.models.ContattoEsteso;
import it.unisa.diem.swe.group07.rubrica.models.Rubrica;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 * @author gruppo 07
 */
public class ImportTest {

    private Rubrica rubrica;
    private Import i;
    private ObservableList<ContattoEsteso> list;

    @Test
    public void testImportVcard() throws IOException{
        rubrica=new Rubrica();
        i= new Import();
        list = FXCollections.observableArrayList();
        ContattoEsteso contatto=new ContattoEsteso("Rossella", "Pale", "+3933333333", "+3933333333", "+3933333333", "prova@gmail.com", "prova@gmail.com", "prova@gmail.com", LocalDate.of(2003, 4, 24),"Fisciano","github.com", "studentessa", true, true);
        ContattoEsteso contatto2;
        Export e=new Export();
        e.esportaContatto(contatto, "./");
        i.importVcard(rubrica, list, "provaImport.vcf");
        Rubrica r=new Rubrica();
        r.aggiungiContatto(contatto);
        assertEquals(rubrica, r);
    }
}
