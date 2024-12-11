//package it.unisa.diem.swe.group07.rubrica.gestoreIO;
//import it.unisa.diem.swe.group07.rubrica.models.ContattoEsteso;
//import it.unisa.diem.swe.group07.rubrica.models.Rubrica;
//
//import java.io.*;
//import java.nio.charset.StandardCharsets;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//import java.util.Map;
//import java.io.BufferedInputStream;
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.DataInputStream;
//import java.io.DataOutputStream;
//import java.io.EOFException;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.HashMap;
//import java.util.Locale;
//import java.util.Map;
//import java.util.Scanner;
//
///**
// * @file Import.java
// * @brief importa i contatti da un file .vcf e li aggiunge ad una rubrica
// * @autor Gruppo07
// * @date Dicembre, 2024
// * @version 1.0
// */
//public class Import {
//    public void importRubrica(Rubrica r, String nomefile) throws IOException {
//        String nome [] = nomefile.split("[,]");
//         try (BufferedReader br = new BufferedReader(new FileReader(nomefile))) { 
//            if (br.readLine() == null) {
//                System.out.println("il file è vuoto");
//                return null;
//            }
//            String line;
//            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//            while ((line = br.readLine()) != null) { 
//                String campi[] = line.split(";");
//                ContattoEsteso ce = new ContattoEsteso(campi[0], campi[1], campi[2], LocalDate.parse(campi[3]), campi[4], campi[5]); 
//                r.aggiungiContatto(ce); 
//            }
//        }
//
//
//          }
//    
//        public void importaContatto(Contatto contatto, String nomefile){
//        String nome [] = nomefile.split("[,]");
//         try (BufferedReader br = new BufferedReader(new FileReader(nomefile))) { 
//            if (br.readLine() == null) {
//                System.out.println("il file è vuoto");
//                return null;
//            }
//            String line;
//            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//            while ((line = br.readLine()) != null) { 
//                String campi[] = line.split(";");
//                Contatto c = new Contatto(Integer.parseInt(campi[0]), campi[1], campi[2], campi[3], campi[4], campi[5]); 
//                r.aggiungiContatto(c); 
//            }
//        }
//      }
//    


    