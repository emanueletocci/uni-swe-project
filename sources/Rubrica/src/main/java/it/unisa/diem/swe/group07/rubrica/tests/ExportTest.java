package it.unisa.diem.swe.group07.rubrica.tests;

import it.unisa.diem.swe.group07.rubrica.models.ContattoEsteso;
import it.unisa.diem.swe.group07.rubrica.gestoreIO.Export;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

class ExportTest {
    private ContattoEsteso c;
    private ContattoEsteso c2;
    private ContattoEsteso c3;
    private Export e;

    @BeforeEach
    void setUp() {
        c = new ContattoEsteso("Emanuele", "Tocci", "+3933333333", "+3933333333", "+3933333333", "prova@gmail.com", "prova@icloud.com", "prova@unisa.it", LocalDate.of(2003, 6, 9), "via Prova", "unisa.it", "note", false, false);
        c2 = new ContattoEsteso("Antonio", "Rossi", "+3933333333", "+3933333333", "+3933333333", "prova@gmail.com", "prova@icloud.com", "prova@unisa.it", LocalDate.of(2001, 6, 9), "via Prova", "unisa.it", "note", false, false);
        e = new Export();
    }

    @Test
    void testGetVcard() {
        StringBuffer valoreAtteso = new StringBuffer();
        valoreAtteso.append("BEGIN:VCARD\n")
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
        String valoreAttuale = e.getVcard(c);
        assertEquals(valoreAtteso.toString(), valoreAttuale);

        String valoreAttuale2 = e.getVcard(c2);
        assertNotEquals(valoreAtteso.toString(), valoreAttuale2);
    }

    @Test
    void testEsportaRubrica() {

    }

    @Test
    void testEsportaContatto() {
    }
}