package it.unisa.diem.swe.group07.rubrica.gestoreIO;

import it.unisa.diem.swe.group07.rubrica.models.ContattoEsteso;
import it.unisa.diem.swe.group07.rubrica.models.Rubrica;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @file Export.java
 * @brief  questo file contiene l'implementazione dei metodi utili al export
 * @autor Gruppo07
 * @date Dicembre, 2024
 * @version 1.0
 */
public class Export {
/**
 * @param[in] c, il contattoEsteso da dove ricavare i dati da salvare nella vcard
 * @brief metodo per ottenere la formattazione conforme allo standard vCard da un contatto
 * @return ritorna una stringa formattata per il vCard
 * @see Rubrica
 * @see Import
*/
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
        if (c.getPreferito() != null) sb.append("X-PREF:1\n");
        if (c.getEmergenza() != null) sb.append("X-EMERG:1\n");
        sb.append("UID:").append (c.getId()).append("\n");
        sb.append("END:VCARD\n");
        return sb.toString();
    }

    /**
     * @param[in] r Rubrica presa in ingresso
     * @param[in] path il percorso dove salvare il file
     * @brief metodo per fornire un file di output conforme allo standard vCard che contiene tutta la rubrica
     * @pre path, Il percorso di salvataggio deve essere un percorso valido.
     */
    public void esportaRubrica(Rubrica r, String path) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path + ".vcf", StandardCharsets.UTF_8))) {
            for (ContattoEsteso contatto : r.getContatti()) {
                String vcard = getVcard(contatto);
                writer.write(vcard);
            }
            System.out.println("Rubrica esportata con successo");
        } catch (IOException e) {
            System.err.println("Errore durante l'esportazione");
        }
    }
    /**
     * @param[in] contatto Il contatto selezionato e scelto per l'export
     * @brief metodo per fornire un file di output conforme allo standard vCard che contiene tutta le informazioni del contatto.
     * @pre path, Il percorso di salvataggio deve essere un percorso valido.
     */
    public void esportaContatto(ContattoEsteso contatto, String path){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path + ".vcf", StandardCharsets.UTF_8))) {
            String vcard = getVcard(contatto);
            writer.write(vcard);
            System.out.println("Contatto esportato con successo");
        } catch (IOException e) {
            System.err.println("Errore durante l'esportazione");
        }
    }

}
