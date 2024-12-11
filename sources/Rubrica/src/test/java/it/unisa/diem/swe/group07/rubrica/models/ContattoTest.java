/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.swe.group07.rubrica.models;


import org.junit.jupiter.api.Test;

/**
 *
 * @author claud
 */
public class ContattoTest {
       
  @Test
    public void testConstructor() {
      Contatto c = new Contatto("Rossella", "Pale", "+3933333333", "+3933333333", "+3933333333", true, true);
      assertEquals("Rossella", c.getNome());
      assertEquals("Pale", c.getCogome());
      assertEquals("+3933333333", c.getTelefono1());
      assertEquals("+3933333333", c.getTelefono2());
      assertEquals("+3933333333", c.getTelefono3());
      assertTrue(c.getPreferito());
      assertFalse(c.getEmergenza());
      
      }
    
@Test 
public void testGetterESetter() {
      Contatto c = new Contatto("Alessio", "Leo", "+3933333333", "+3933333333", "+3933333333", false, false);
      assertEquals("Alessio", c.getNome());
      assertEquals("Lep", c.getCogome());
      assertEquals("+3933333333", c.getTelefono1());
      assertEquals("+3933333333", c.getTelefono2());
      assertEquals("+3933333333", c.getTelefono3());
      assertTrue(c.getPreferito());
      assertFalse(c.getEmergenza());
      
}
}