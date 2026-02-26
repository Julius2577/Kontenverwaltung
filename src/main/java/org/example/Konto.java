package org.example;

public class Konto {
    private final String kontonummer;
    private int saldo;
    private final int kreditlinie;
    private final String name;
    private final String adresse;

    public Konto(String kontonummer, int saldo, int kreditlinie, String name, String adresse) {
        this.kontonummer = kontonummer;
        this.saldo = saldo;
        this.kreditlinie = kreditlinie;
        this.name = name;
        this.adresse = adresse;
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

    public String getName() {
        return name;
    }

    public String getAdresse() {
        return adresse;
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


