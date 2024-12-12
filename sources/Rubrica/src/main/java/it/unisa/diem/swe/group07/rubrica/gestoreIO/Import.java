package it.unisa.diem.swe.group07.rubrica.gestoreIO;

import it.unisa.diem.swe.group07.rubrica.models.ContattoEsteso;
import it.unisa.diem.swe.group07.rubrica.models.Rubrica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @file Import.java
 * @brief importa i contatti da un file .vcf e li aggiunge ad una rubrica
 * @autor Gruppo07
 * @date Dicembre, 2024
 * @version 1.0
 */
public class Import {
    private String path = "src/main/resources/files/";
    /**
     * @brief metodo per importare i contatti da un file vCard (.vcf) e aggiungerli a una rubrica
     * @param r la rubrica in cui importare i contatti
     * @param nomefile il nome del file .vcf da cui importare i contatti
     * @throws IOException se si verifica un errore durante la lettura del file
     */
    public void importVcard(Rubrica r, String nomefile) throws IOException {
        //aggiunta dello standard utf8 perché è l'unico accettato dai .vcf (fonte stackoverflow)
        nomefile="AlessioLeo-342770766.vcf"; //test
        System.out.println("import start\n");
        try (BufferedReader br = new BufferedReader(new FileReader(path+nomefile, StandardCharsets.UTF_8))) {
            if (br.readLine() == null) {
                System.out.println("Il file è vuoto");
                return;
            }
            String line;
            ContattoEsteso contatto = new ContattoEsteso();
            String nome = null;
            String cognome = null;
            String telefono1 = null;
            String telefono2 = null;
            String telefono3 = null;
            String email1 = null; 
            String email2 = null;
            String email3 = null;
            String indirizzo = null;
            String sito = null;
            String note = null;
            Boolean preferito = null;
            Boolean emergenza = null;
            LocalDate compleanno = null;
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            while ((line = br.readLine()) != null) {
                if (line.startsWith("BEGIN:VCARD")) {
                    ;
                } else if (line.startsWith("FN:")) {
                    String[] n = line.substring(3).split(" "); //uso substring per togliere il tag vcard//tramite split al primo incice ho il nome
                    contatto.setNome(n[0]);
                    if (n.length > 1) contatto.setCognome(n[1]); //al secondo indice il cognome
                } else if (line.startsWith("TEL;TYPE=cell:")) {
                    contatto.setTelefono1(line.substring(13));
                } else if (line.startsWith("TEL;TYPE=home:")) {
                    contatto.setTelefono2(line.substring(13));
                } else if (line.startsWith("TEL;TYPE=work:")) {
                    contatto.setTelefono3(line.substring(13));
                } else if (line.startsWith("EMAIL;TYPE=work:")) {
                    contatto.setEmail1(line.substring(15));
                } else if (line.startsWith("EMAIL;TYPE=home:")) {
                    contatto.setEmail2(line.substring(15));
                } else if (line.startsWith("EMAIL;TYPE=other:")) {
                    contatto.setEmail3(line.substring(16));
                } else if (line.startsWith("BDAY:")) {
                    contatto.setCompleanno(LocalDate.parse(line.substring(5), dateFormatter));
                } else if (line.startsWith("ADR;TYPE=home:")) {
                    contatto.setIndirizzoResidenza(line.substring(13));
                } else if (line.startsWith("URL:")) {
                    contatto.setSitoWeb(line.substring(4));
                } else if (line.startsWith("NOTE:")) {
                    contatto.setNote(line.substring(5));
                } else if (line.startsWith("X-PREF:1")) {
                    contatto.setPreferito(true);
                } else if (line.startsWith("X-EMERG:1")) {
                    contatto.setEmergenza(true);
                } else if (line.startsWith("END:VCARD")) {
                    //contatto.setId(contatto.hashCode());
                    System.out.println(contatto);
                    r.aggiungiContattoEVerifica(contatto);
                }
            }
            System.out.println("Rubrica importata con successo");
        } catch (IOException e) {
            System.err.println("Errore durante l'importazione");
        }
    }
}
