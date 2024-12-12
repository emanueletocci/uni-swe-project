/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.swe.group07.rubrica.gestoreIO;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException; 
import java.nio.file.Files; 
import java.nio.file.Path; 
import java.nio.file.Paths;

/**
 *
 * @author hp
 */
public class ImportTest { 

    @BeforeEach
    public void setUp() {
        rubrica=new Rubrica();
        Import i= new Import();
        
    }
    @Test 
    public void testImportVcard() throws IOException{
        //creazione file temporaneo del tipo vCard
        Path testFile = Files.createTempFile("testImport", ".vcf"); 
        String vcardContent = 
                "BEGIN:VCARD\n" + 
                "FN:Rossella Pale " + 
                "TEL;TYPE=cell:+3933333333" +
                "TEL;TYPE=home:+3933333333 "+
                "TEL;TYPE=work:+3933333333 "+
                "EMAIL;TYPE=work:prova@gmail.com " + 
                "EMAIL;TYPE=home:prova@gmail.com "+
                "EMAIL;TYPE=other:prova@gmail.com "+
                "BDAY: 2003/04/24"+
                "ADR;TYPE=home: Fisciano"
                "URL: github.com"
                "NOTE: studentessa"
                "X-PREF:1"
                "X-EMERG:1"
                "END:VCARD\n"; 
        Files.write(testFile, vcardContent.getBytes(StandardCharsets.UTF_8)); 
        // Chiamata al metodo importVcard 
        i.importVcard(rubrica, testFile.toString()); 
        // Verifica che il contatto sia stato aggiunto alla rubrica 
        assertEquals(1, rubrica.getContatti().size()); 
        ContattoEsteso contatto = rubrica.getContatti().get(0); 
        assertEquals("Rossella", contatto.getNome()); 
        assertEquals("Pale", contatto.getCognome()); 
        assertEquals("+3933333333", contatto.getTelefono1()); 
        assertEquals("+3933333333", contatto.getTelefono2());
        assertEquals("+3933333333", contatto.getTelefono3());
        assertEquals("prova@gmail.com", contatto.getEmail1()); 
        assertEquals("prova@gmail.com", contatto.getEmail1());
        assertEquals("prova@gmail.com", contatto.getEmail1());
        // Eliminazione del file temporaneo 
        Files.delete(testFile);
    }
}
