package org.example;

public class Konten {
    private String kontonummer;
    private int saldo;
    private int kreditlinie;

    public String getKontonummer() {
        return kontonummer;
    }

    public int getSaldo() {
        return saldo;
    }

    public int getKreditlinie() {
        return kreditlinie;
    }

    public boolean abheben(int betrag) {
        if (betrag <= 0) {
            System.out.println("Betrag muss positiv sein");
            return false;
        }

        if ((saldo - betrag) < -kreditlinie) {
            System.out.println("Kreditlinie überschritten");
            return false;
        }
        saldo = saldo - betrag;

        return true;
    }

    public boolean einzahlen(int betrag) {
        if (betrag <= 0) {
            System.out.println("Einzuzahlender Betrag muss größer 0 sein");
            return false;
        }

        saldo = saldo + betrag;
        return true;
    }
}


