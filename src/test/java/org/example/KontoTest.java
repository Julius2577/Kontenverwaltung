package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KontoTest {
    @Test
    void einzahlen_erfolgreich(){
        Konto konto1 = new Konto("DE12378", 0, 200, "Heinrich", "Bohlweg");

        konto1.einzahlen(50);

        assertEquals(50, konto1.getSaldo());
    }

    @Test
    void abheben_erlaubt(){
        Konto konto1 = new Konto("DE12378", 0, 200, "Heinrich", "Bohlweg");

        boolean ok = konto1.abheben(80);
        assertTrue(ok);
        assertEquals(-80, konto1.getSaldo());
    }

    @Test
    void abheben_nicht_erlaubt(){
        Konto konto1 = new Konto("DE12378", 0, 200, "Heinrich", "Bohlweg");

        boolean ok = konto1.abheben(250);
        assertFalse(ok);
        assertEquals(0, konto1.getSaldo()); // Expected 0. weil sich ja nichts ändern soll, abheben nicht erlaubt!
    }
}
