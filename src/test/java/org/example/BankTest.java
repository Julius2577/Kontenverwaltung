package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {

    @Test
    void ueberweisen_erfolgreich() {
        Bank bank = new Bank("TestBank", "123");
        Konto a = new Konto("A", 0, 200, "Hans", "Bebelhof");
        Konto b = new Konto("B", 0, 200, "Günther", "Magniviertel");

        bank.addKonto(a);
        bank.addKonto(b);

        a.einzahlen(100);

        boolean ok = bank.ueberweisen("A", "B", 50);

        assertTrue(ok);
        assertEquals(50, a.getSaldo());
        assertEquals(50, b.getSaldo());
    }

    @Test
    void ueberweisen_scheitert_wenn_konto_nicht_existiert() {
        Bank bank = new Bank("TestBank", "123");
        Konto a = new Konto("A", 0, 200, "Hans", "Bebelhof");
        bank.addKonto(a);

        boolean ok = bank.ueberweisen("A", "B", 50);

        assertFalse(ok);
        assertEquals(0, a.getSaldo()); // sollte unverändert bleiben
    }

    @Test
    void ueberweisen_scheitert_wenn_betrag_ungueltig() {
        Bank bank = new Bank("TestBank", "123");
        Konto a = new Konto("A", 0, 200, "Hans", "Bebelhof");
        Konto b = new Konto("B", 0, 200, "Günther", "Magniviertel");
        bank.addKonto(a);
        bank.addKonto(b);

        boolean ok = bank.ueberweisen("A", "B", 0);

        assertFalse(ok);
        assertEquals(0, a.getSaldo());
        assertEquals(0, b.getSaldo());
    }

    @Test
    void ueberweisen_scheitert_wenn_kreditlinie_ueberschritten() {
        Bank bank = new Bank("TestBank", "123");
        Konto a = new Konto("A", 0, 100, "Hans", "Bebelhof"); // kreditlinie 100
        Konto b = new Konto("B", 0, 100, "Günther", "Magniviertel");
        bank.addKonto(a);
        bank.addKonto(b);

        // a hat 0, darf bis -100 gehen. 150 wäre zu viel.
        boolean ok = bank.ueberweisen("A", "B", 150);

        assertFalse(ok);
        assertEquals(0, a.getSaldo());
        assertEquals(0, b.getSaldo());
    }
}