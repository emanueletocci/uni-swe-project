package it.unisa.diem.swe.group07.rubrica.tests;

import it.unisa.diem.swe.group07.rubrica.models.ContattoEsteso;
import it.unisa.diem.swe.group07.rubrica.gestoreIO.Export;
import it.unisa.diem.swe.group07.rubrica.models.Rubrica;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;

class ExportTest {
    private ContattoEsteso c;
    private ContattoEsteso c2;
    private Export e;
    private StringBuffer sb;

    @BeforeEach
    void setUp() {
        c = new ContattoEsteso("Emanuele", "Tocci", "+3933333333", "+3933333333", "+3933333333", "prova@gmail.com", "prova@icloud.com", "prova@unisa.it", LocalDate.of(2003, 6, 9), "via Prova", "unisa.it", "note", false, false);
        c2 = new ContattoEsteso("Antonio", "Rossi", "+0234798123", "", "+3933333333", "", "prova@icloud.com", "prova@unisa.it", LocalDate.of(2001, 6, 9), "via Prova", "unisa.it", "note", false, false);
        e = new Export();
        sb = new StringBuffer();
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
    }

    @Test
    void testGetVcard() {
        String valoreAtteso = sb.toString();

        String valoreAttuale = e.getVcard(c);
        assertEquals(valoreAtteso, valoreAttuale);

        String valoreAttuale2 = e.getVcard(c2);
        assertNotEquals(valoreAtteso, valoreAttuale2);
    }

    @Test
    void testEsportaRubrica() {
        BufferedReader br = null;
        String lineaCorrente;
        StringBuffer lettura = new StringBuffer();
        StringBuffer sb = new StringBuffer();
        sb
                .append("BEGIN:VCARD\n")
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
                .append("END:VCARD\n")
                .append("BEGIN:VCARD\n")
                .append("VERSION:3.0\n")
                .append("FN:Antonio Rossi\n")
                .append("TEL;TYPE=cell:+0234798123\n")
                .append("TEL;TYPE=home:\n")
                .append("TEL;TYPE=work:+3933333333\n")
                .append("EMAIL;TYPE=work:\n")
                .append("EMAIL;TYPE=home:prova@icloud.com\n")
                .append("EMAIL;TYPE=other:prova@unisa.it\n")
                .append("BDAY:2001-06-09\n")
                .append("ADR;TYPE=home:via Prova\n")
                .append("URL:unisa.it\n")
                .append("NOTE:note\n")
                .append("END:VCARD\n");

        String valoreAtteso = sb.toString();

        Rubrica r = new Rubrica();
        r.aggiungiContatto(c);
        r.aggiungiContatto(c2);

        e.esportaRubrica(r);

        // leggo il contenuto del file esportato precedentemente
        try {
            br = new BufferedReader(new FileReader("src/main/resources/files/RubricaExport.vcf"));
            while ((lineaCorrente = br.readLine()) != null) {
                lettura.append(lineaCorrente).append("\n");
            }
        } catch (IOException e){
            e.printStackTrace();
            fail(e.getMessage());
        }
        String valoreAttuale = lettura.toString();
        assertEquals(valoreAtteso, valoreAttuale);
    }


    @Test
    void testEsportaContatto() {
        BufferedReader br = null;
        String lineaCorrente;
        StringBuffer lettura = new StringBuffer();
        String valoreAtteso = sb.toString();

        e.esportaContatto(c);

        // leggo il contenuto del file esportato precedentemente
        try {
            br = new BufferedReader(new FileReader("src/main/resources/files/" + c.getNome() + c.getCognome() + c.getId() + ".vcf"));
            while ((lineaCorrente = br.readLine()) != null) {
                lettura.append(lineaCorrente).append("\n");
            }
        } catch (IOException e){
                e.printStackTrace();
                fail(e.getMessage());
        }
        String valoreAttuale = lettura.toString();
        assertEquals(valoreAtteso, valoreAttuale);

        e.esportaContatto(c2);

        // leggo il contenuto del file esportato precedentemente
        try {
            br = new BufferedReader(new FileReader("src/main/resources/files/" + c2.getNome() + c2.getCognome() + c2.getId() + ".vcf"));
            while ((lineaCorrente = br.readLine()) != null) {
                lettura.append(lineaCorrente).append("\n");
            }
        } catch (IOException e){
            e.printStackTrace();
            fail(e.getMessage());
        }
        String valoreAttuale2 = lettura.toString();
        assertNotEquals(valoreAtteso, valoreAttuale2);
    }
}