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
 * @file Import.java
 * @brief importa i contatti da un file .vcf e li aggiunge ad una rubrica
 * @autor Gruppo07
 * @date Dicembre, 2024
 * @version 1.0
 */
public class Import {
    public static void importRubricaDaVcf(Rubrica r, String nomefile) throws IOException {
      try(BufferedReader br = new BufferedReader(new FileReader(nomefile)))   {
          ContattoEsteso ce = null;
          StringBuilder sb = new StringBuilder();
          String line;
          while ((line = br.readLine()) != null) { 
            if(line.equals("BEGIN:VCARD")) {
                ce = new ContattoEsteso();
            }else if(line.sb("FN:") && ce != null) {
                ce.setNome(sb.toString());
                //da completare
            }
             
          
          }
      }
    }

}
