/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import it.unisa.diem.swe.group07.rubrica.models.Contatto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author claud
 */
public class ContattoTest {
    private Contatto c;
    private Contatto c2;
    private Contatto c3;

    @BeforeEach
    public void setUp() {
        c = new Contatto("nome", "cognome", "telefono1", "telefono2", "telefono3", true, true);
        c2 = new Contatto("Claudia", "Montefusco", "", "+3933333333", "", false, true);
        c3 = new Contatto("Claudia", "Montefusco", "", "+3933333333", "", false, true);
    }

    @Test
    public void testContattoConstructor() {
        assertEquals("nome", c.getNome());
        assertEquals("cognome", c.getCognome());
        assertEquals("telefono1", c.getTelefono1());
        assertEquals("telefono2", c.getTelefono2());
        assertEquals("telefono3", c.getTelefono3());
        assertTrue(c.getPreferito());
        assertTrue(c.getEmergenza());

        assertNotEquals("nome", c2.getNome());
        assertNotEquals("cognome", c2.getCognome());
        assertNotEquals("telefono1", c2.getTelefono1());
        assertNotEquals("telefono2", c2.getTelefono2());
        assertNotEquals("telefono3", c2.getTelefono3());
        assertFalse(c2.getPreferito());
        assertTrue(c2.getEmergenza());

    }
    
    @Test 
    public void testGetterESetter() {
        c.setNome("nome");
        c.setCognome("cognome");
        c.setTelefono1("telefono1");
        c.setTelefono2("telefono2");
        c.setTelefono3("telefono3");
        c.setPreferito(true);
        c.setEmergenza(true);
        
        assertEquals("nome", c.getNome());
        assertEquals("cognome", c.getCognome());
        assertEquals("telefono1", c.getTelefono1());
        assertEquals("telefono2", c.getTelefono2());
        assertEquals("telefono3", c.getTelefono3());
        Assertions.assertTrue(c.getPreferito());
        Assertions.assertTrue(c.getEmergenza());
    }
    
    @Test
    public void testToString() {
        String s = "\nid=996724187, nome=nome, cognome=cognome, telefono1=telefono1, telefono2=telefono2, telefono3=telefono3, preferito=true, emergenza=true";
        assertEquals(s, c.toString());

        String s2 = "\nid=1530347218, nome=Claudia, cognome=Montefusco, telefono1=, telefono2=+3933333333, telefono3=, preferito=false, emergenza=true";
        assertEquals(s2, c2.toString());

    }

    @Test
    public void testEquals() {
        Assertions.assertTrue(c2.equals(c3));
        Assertions.assertFalse(c.equals(c2));
    }

    @Test
    public void testHashCode() {
        c2 = new Contatto("nome", "cognome", "telefono1", "telefono2", "telefono3", true, true);
        assertEquals(c.hashCode(), c2.hashCode());
    }
    
    @Test
    public void testIsPreferito() {
       Assertions.assertTrue(c.getPreferito());  
    }
    
    @Test
    public void testisEmergenza() {
       Assertions.assertTrue(c.getEmergenza()); 
    }

}