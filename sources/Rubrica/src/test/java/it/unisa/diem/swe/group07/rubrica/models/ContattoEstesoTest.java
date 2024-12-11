
package it.unisa.diem.swe.group07.rubrica.models;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author claud
 */
public class ContattoEstesoTest {
    private ContattoEsteso ce;
    
    @BeforeEach
    public void setUp() {
       ce = new ContattoEsteso("Claudia", "Montefusco", "+3933333333", "+3933333333", "+3933333333", 
                               "prova@gmail.com", "prova@icloud.com", "prova@unisa.it", LocalDate.of(2020, 12, 12),
                               "via Prova", "unisa.it", "note", false, false );
    }

      @Test
    public void testContattoEstesoConstructor() {
     
      assertEquals("Claudia", ce.getNome());
      assertEquals("Montefusco", ce.getCognome());
      assertEquals("+3933333333", ce.getTelefono1());
      assertEquals("+3933333333", ce.getTelefono2());
      assertEquals("+3933333333", ce.getTelefono3());
      assertEquals("prova@gmail.com", ce.getEmail1());
      assertEquals("prova@icloud.com", ce.getEmail2()); 
      assertEquals("prova@unisa.it", ce.getEmail3());
      assertEquals(LocalDate.of(2020, 12, 12), ce.getCompleanno());
      assertEquals( "via Prova", ce.getIndirizzoResidenza());
      assertEquals("unisa.it", ce.getSitoWeb());
      assertEquals("note", ce.getNote());
      assertFalse(ce.getPreferito());
      assertFalse(ce.getEmergenza());
      }
    
@Test 
public void testGetterESetter() {
      
      ce.setEmail1("prova@gmail.com");
      ce.setEmail2("prova@icloud.com");
      ce.setEmail3("prova@unisa.it");
      ce.setCompleanno(LocalDate.of(2020, 12, 12));
      ce.setIndirizzoResidenza( "via Prova");
      ce.setSitoWeb("unisa.it");
      ce.setNote("note");
      
      assertEquals("prova@gmail.com", ce.getEmail1());
      assertEquals("prova@icloud.com", ce.getEmail2()); 
      assertEquals("prova@unisa.it", ce.getEmail3());
      assertEquals(LocalDate.of(2020, 12, 12), ce.getCompleanno());
      assertEquals( "via Prova", ce.getIndirizzoResidenza());
      assertEquals("unisa.it", ce.getSitoWeb());
      assertEquals("note", ce.getNote());          
      
}

@Test
public void TestToString() {
    String s = "\nid=0, nome=Claudia, cognome=Montefusco, telefono1=+3933333333, telefono2=+3933333333, telefono3=+3933333333, preferito=false, emergenza=false" +
               ", email1='prova@gmail.com, email2='prova@icloud.com, email3='prova@unisa.it, compleanno='2020-12-12, indirizzoResidenza='via Prova, sitoWeb='unisa.it, note='note";
    assertEquals(s, ce.toString());
}

@Test
public void TestEquals() {
  ContattoEsteso ce1 = new ContattoEsteso("Claudia", "Montefusco", "+3933333333", "+3933333333", "+3933333333", 
                               "prova@gmail.com", "prova@icloud.com", "prova@unisa.it", LocalDate.of(2020, 12, 12),
                               "via Prova", "unisa.it", "note", false, false ); 
  ContattoEsteso ce1_1 = new ContattoEsteso( "Emanuele", "Tocci", "+3933333333", "+3933333333", "+3933333333", 
                                             "prova@gmail.com", "prova@icloud.com", "prova@unisa.it", LocalDate.of(2020, 12, 12), 
                                             "via Prova", "unisa.it", "note", false, false);
  
  assertTrue(ce.equals(ce1));
  assertFalse(ce.equals(ce1_1));
} 


@Test
public void TestHashCode() {
    ContattoEsteso ce2 = new ContattoEsteso ( "Claudia", "Montefusco", "+3933333333", "+3933333333", "+3933333333", 
                               "prova@gmail.com", "prova@icloud.com", "prova@unisa.it", LocalDate.of(2020, 12, 12),
                               "via Prova", "unisa.it", "note", false, false );
    assertEquals(ce.hashCode(), ce2.hashCode());
}

    
}
