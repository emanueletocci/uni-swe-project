import it.unisa.diem.swe.group07.rubrica.models.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class RubricaTest {

    private ContattoEsteso c;
    private Rubrica r;

    @BeforeEach
    void setUp() {
        c = new ContattoEsteso("nome", "cognome", "num1", "num2", "num3", "em1", "em2", "em3", LocalDate.of(1970, 1, 1), "adr", "link", "note", true, true);
        r = new Rubrica();
    }


    @Test
    void testAggiungiContatto() {
        assertTrue(r.aggiungiContatto(c));
        assertFalse(r.aggiungiContatto(c));
    }

    @Test
    void testRimuoviContatto() {
        assertNull(r.rimuoviContatto(c));
        r.aggiungiContatto(c);
        assertEquals(c, r.rimuoviContatto(c));
    }

    @Test
    void testRicercaContatto() {
        assertNull(r.ricercaContatto(c));
        r.aggiungiContatto(c);
        assertEquals(c, r.ricercaContatto(c));
    }

    @Test
    void testGetContatti() {
        assertFalse(r.getContatti().contains(c));
        r.aggiungiContatto(c);
        assertTrue(r.getContatti().contains(c));
    }

    @Test
    void testAggiornaContatto() {
        assertFalse(r.aggiornaContatto(c));
        r.aggiungiContatto(c);
        assertTrue(r.aggiornaContatto(c));
        assertEquals("nome", c.getNome());
        c.setNome("nome2");
        r.aggiornaContatto(c);
        assertEquals("nome2", r.ricercaContatto(c).getNome());
    }

    @Test
    void testToString() {
        r.aggiungiContatto(c);
        String s = "\nRubrica\n" + r.getContatti();
        assertEquals(s, r.toString());

    }
}