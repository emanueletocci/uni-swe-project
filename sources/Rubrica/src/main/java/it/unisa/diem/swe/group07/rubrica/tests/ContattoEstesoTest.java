
package it.unisa.diem.swe.group07.rubrica.tests;
import static org.junit.jupiter.api.Assertions.*;
import it.unisa.diem.swe.group07.rubrica.models.ContattoEsteso;
import org.junit.jupiter.api.*;
import java.time.LocalDate;

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
     
      Assertions.assertEquals("Claudia", ce.getNome());
      Assertions.assertEquals("Montefusco", ce.getCognome());
      Assertions.assertEquals("+3933333333", ce.getTelefono1());
      Assertions.assertEquals("+3933333333", ce.getTelefono2());
      Assertions.assertEquals("+3933333333", ce.getTelefono3());
      Assertions.assertEquals("prova@gmail.com", ce.getEmail1());
      Assertions.assertEquals("prova@icloud.com", ce.getEmail2());
      Assertions.assertEquals("prova@unisa.it", ce.getEmail3());
      Assertions.assertEquals(LocalDate.of(2020, 12, 12), ce.getCompleanno());
      Assertions.assertEquals( "via Prova", ce.getIndirizzoResidenza());
      Assertions.assertEquals("unisa.it", ce.getSitoWeb());
      Assertions.assertEquals("note", ce.getNote());
      Assertions.assertFalse(ce.getPreferito());
      Assertions.assertFalse(ce.getEmergenza());
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
      
      Assertions.assertEquals("prova@gmail.com", ce.getEmail1());
      Assertions.assertEquals("prova@icloud.com", ce.getEmail2());
      Assertions.assertEquals("prova@unisa.it", ce.getEmail3());
      Assertions.assertEquals(LocalDate.of(2020, 12, 12), ce.getCompleanno());
      Assertions.assertEquals( "via Prova", ce.getIndirizzoResidenza());
      Assertions.assertEquals("unisa.it", ce.getSitoWeb());
      Assertions.assertEquals("note", ce.getNote());
      
}

@Test
public void TestToString() {
    String s = "\nid=-1857870450, nome=Claudia, cognome=Montefusco, telefono1=+3933333333, telefono2=+3933333333, telefono3=+3933333333, preferito=false, emergenza=false, email1='prova@gmail.com, email2='prova@icloud.com, email3='prova@unisa.it, compleanno='2020-12-12, indirizzoResidenza='via Prova, sitoWeb='unisa.it, note='note";
    Assertions.assertEquals(s, ce.toString());
}

@Test
public void TestEquals() {
  ContattoEsteso ce1 = new ContattoEsteso("Claudia", "Montefusco", "+3933333333", "+3933333333", "+3933333333", 
                               "prova@gmail.com", "prova@icloud.com", "prova@unisa.it", LocalDate.of(2020, 12, 12),
                               "via Prova", "unisa.it", "note", false, false ); 
  ContattoEsteso ce1_1 = new ContattoEsteso( "Emanuele", "Tocci", "+3933333333", "+3933333333", "+3933333333", 
                                             "prova@gmail.com", "prova@icloud.com", "prova@unisa.it", LocalDate.of(2020, 12, 12), 
                                             "via Prova", "unisa.it", "note", false, false);
  
  Assertions.assertTrue(ce.equals(ce1));
  Assertions.assertFalse(ce.equals(ce1_1));
} 


@Test
public void TestHashCode() {
    ContattoEsteso ce2 = new ContattoEsteso ( "Claudia", "Montefusco", "+3933333333", "+3933333333", "+3933333333", 
                               "prova@gmail.com", "prova@icloud.com", "prova@unisa.it", LocalDate.of(2020, 12, 12),
                               "via Prova", "unisa.it", "note", false, false );
    Assertions.assertEquals(ce.hashCode(), ce2.hashCode());
}


    @AfterEach
    void tearDown() {
    }

    @Test
    void getCompleanno() {
    }

    @Test
    void setCompleanno() {
    }

    @Test
    void getIndirizzoResidenza() {
    }

    @Test
    void setIndirizzoResidenza() {
    }

    @Test
    void getSitoWeb() {
    }

    @Test
    void setSitoWeb() {
    }

    @Test
    void getEmail3() {
    }

    @Test
    void setEmail3() {
    }

    @Test
    void getEmail2() {
    }

    @Test
    void setEmail2() {
    }

    @Test
    void getEmail1() {
    }

    @Test
    void setEmail1() {
    }

    @Test
    void getNote() {
    }

    @Test
    void setNote() {
    }

    @Test
    void testToString1() {
    }

    @Test
    void testEquals1() {
    }

    @Test
    void testHashCode1() {
    }
}
