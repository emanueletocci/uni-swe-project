/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.swe.group07.rubrica.tests;
import it.unisa.diem.swe.group07.rubrica.models.Contatto;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author claud
 */
public class ContattoTest {
    private Contatto c;

    @BeforeEach
    public void setUp() {
    c = new Contatto("nome", "cognome", "telefono1", "telelfono2", "telelfono2", true, true);
    }

    @Test
    public void TestContattoConstructor() {
        Assertions.assertEquals("nome", c.getNome());
        Assertions.assertEquals("cognome", c.getNome());
        Assertions.assertEquals("telefono1", c.getNome());
        Assertions.assertEquals("telelfono2", c.getNome());
        Assertions.assertEquals("telelfono3", c.getNome());
        Assertions.assertTrue(c.getPreferito());
        Assertions.assertTrue(c.getEmergenza());
    }
    
    @Test 
    public void testGetterESetter() {
        c.setNome("nome");
        c.setCognome("cognome");
        c.setTelefono1("telelfono1");
        c.setTelefono2("telelfono2");
        c.setTelefono3("telelfono3");
        c.setPreferito(true);
        c.setEmergenza(true);
        
        Assertions.assertEquals("nome", c.getNome());
        Assertions.assertEquals("cognome", c.getNome());
        Assertions.assertEquals("telefono1", c.getNome());
        Assertions.assertEquals("telelfono2", c.getNome());
        Assertions.assertEquals("telelfono3", c.getNome());
        Assertions.assertTrue(c.getPreferito());
        Assertions.assertTrue(c.getEmergenza());
    }
    
    @Test
    public void TesttoString() {
        String s = "\nid=-1111, nome=nome, cognome=cognome, telefono1=telefono1, telefono2=telefono2, telefono3=telefono3, preferito=true, emergenza=true";
        
        Assertions.assertEquals(s, c.toString());
    }
    
    @Test
    public void Testequals() {
        Contatto c1 = new Contatto("nome", "cognome", "telefono1", "telelfono2", "telelfono2", true, true); 
        Contatto c1_1 = new Contatto( "Emanuele", "Tocci", "+3933333333", "+3933333333", "+3933333333", false, false);

        Assertions.assertTrue(c.equals(c1));
        Assertions.assertFalse(c.equals(c1_1));
} 


    @Test
    public void TesthashCode() {
        Contatto c2 = new Contatto("nome", "cognome", "telefono1", "telelfono2", "telelfono2", true, true);
        Assertions.assertEquals(c.hashCode(), c2.hashCode());
    }
    
    @Test
    public void TestisPreferito() {
       Assertions.assertTrue(c.getPreferito());  
    }
    
    @Test
    public void TestisEmergenza() {
       Assertions.assertTrue(c.getEmergenza()); 
    }

}