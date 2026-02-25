package org.example;

public class Konten {
    private String kontonummer;
    private int saldo;
    private int kreditlinie;

    public Konten(String kontonummer, int saldo, int kreditlinie) {
        this.kontonummer = kontonummer;
        this.saldo = saldo;
        this.kreditlinie = kreditlinie;
    }

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
            throw new IllegalArgumentException ("Betrag muss positiv sein");
        }

        if ((saldo - betrag) < -kreditlinie) {
            System.out.println("Kreditlinie überschritten");
            return false;
        }
        this.saldo = saldo - betrag;

        return true;
    }

    public boolean einzahlen(int betrag) {
        if (betrag <= 0) {
            System.out.println("Einzuzahlender Betrag muss größer 0 sein");
            return false;
        }

        this.saldo = saldo + betrag;
        return true;
    }
}


