package org.example;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private final String name;
    private final String bankleitzahl;
    public Bank(String name, String Bankleitzahl) {
        this.name = name;
        this.bankleitzahl = Bankleitzahl;
    }

    public String getName() {
        return name;
    }

    public String getBankleitzahl() {
        return bankleitzahl;
    }

    private List<Konto> alleKonten = new ArrayList<>();

    public List<Konto> getalleKonten() {
        return alleKonten;
    }

    public void addKonto(Konto konto) {
        alleKonten.add(konto);
    }

    public void removeKonto(Konto konto) {
        alleKonten.remove(konto);
    }

    public Konto findKontoBykontonummer(String kontonummer) {
        for (Konto k : alleKonten) {
            if (k.getKontonummer().equals(kontonummer)){
                return k;
        }
        return null;
    }

    public boolean überweisen(String vonNr, String zurNr, int betrag) {
        Konto von = findKontoBykontonummer(vonNr);
        Konto zu = findKontoBykontonummer(zurNr);
        if(von == null || zu == null ){
            System.out.println("Konto nicht gefunden!");
            return false;
        }
        if(betrag <=0){
            System.out.println("Betrag muss positiv sein!");
            return false;
        }

        boolean erfolgreich = von.abheben(betrag);
        if (!erfolgreich) {
            System.out.println("Abheben nicht möglich!");
            return false;
        }
        zu.einzahlen(betrag);
        return true;

    }

    @Override // braucht man hier weil man Object.toString() (standartmethode von java) durch Bank.toString () ersetzen will. Jedes java projekt erbt automatische toString ()
    public String toString() {
        return name + " " + bankleitzahl;
    }
}
