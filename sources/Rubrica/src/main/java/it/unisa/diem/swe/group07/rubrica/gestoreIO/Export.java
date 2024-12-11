package it.unisa.diem.swe.group07.rubrica.gestoreIO;

import it.unisa.diem.swe.group07.rubrica.models.ContattoEsteso;
import it.unisa.diem.swe.group07.rubrica.models.Rubrica;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class Export {

    Collection<ContattoEsteso> lst;
    public Export(Rubrica r){
        lst=r.getContatti();
    }
    public Export(){}

    public String getVcard(ContattoEsteso c) {
        StringBuilder sb = new StringBuilder();
        sb.append("BEGIN:VCARD\n");
        sb.append("VERSION:3.0\n");
        sb.append("FN:").append(c.getNome() != null ? c.getNome() : "").append(" ").append(c.getCognome() != null ? c.getCognome() : "").append("\n");
        sb.append("BDAY:").append(c.getCompleanno() != null ? c.getCompleanno() : "").append("\n");
        sb.append("EMAIL;TYPE=work:").append(c.getEmail1() != null ? c.getEmail1() : "").append("\n");
        sb.append("END:VCARD").append("\n");
        return sb.toString();
    }

    public void esportaRubrica() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("rubrica.vcf", StandardCharsets.UTF_8))) {
            for (ContattoEsteso contatto : lst) {
                String vcard = getVcard(contatto);
                writer.write(vcard);
            }
            System.out.println("Rubrica esportata con successo");
        } catch (IOException e) {
            System.err.println("Errore durante l'esportazione");
        }
    }

    public void esportaContatto(ContattoEsteso contatto){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(contatto.getNome()+".vcf", StandardCharsets.UTF_8))) {
            String vcard = getVcard(contatto);
            writer.write(vcard);
            System.out.println("Contatto esportato con successo");
        } catch (IOException e) {
            System.err.println("Errore durante l'esportazione");
        }
    }

}
