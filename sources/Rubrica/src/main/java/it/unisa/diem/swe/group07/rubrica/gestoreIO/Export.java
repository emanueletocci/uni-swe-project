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
        if (c.getTelefono1() != null) sb.append("TEL;TYPE=cell:").append(c.getTelefono1()).append("\n");
        if (c.getTelefono2() != null) sb.append("TEL;TYPE=home:").append(c.getTelefono2()).append("\n");
        if (c.getTelefono3() != null) sb.append("TEL;TYPE=work:").append(c.getTelefono3()).append("\n");
        if (c.getEmail1() != null) sb.append("EMAIL;TYPE=work:").append(c.getEmail1()).append("\n");
        if (c.getEmail2() != null) sb.append("EMAIL;TYPE=home:").append(c.getEmail2()).append("\n");
        if (c.getEmail3() != null) sb.append("EMAIL;TYPE=other:").append(c.getEmail3()).append("\n");
        if (c.getCompleanno() != null) sb.append("BDAY:").append(c.getCompleanno()).append("\n");
        if (c.getIndirizzoResidenza() != null) sb.append("ADR;TYPE=home:").append(c.getIndirizzoResidenza()).append("\n");
        if (c.getSitoWeb() != null) sb.append("URL:").append(c.getSitoWeb()).append("\n");
        if (c.getNote() != null) sb.append("NOTE:").append(c.getNote()).append("\n");
        if (c.getPreferito() != null && c.getPreferito()) sb.append("X-PREF:1\n");
        if (c.getEmergenza() != null && c.getEmergenza()) sb.append("X-EMERG:1\n");
        sb.append("END:VCARD\n");
        return sb.toString();
    }

    public void esportaRubrica() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("RubricaExport.vcf", StandardCharsets.UTF_8))) {
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
