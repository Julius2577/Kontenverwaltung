package org.example;

public class Bank {
    private String name;
    private String bankleitzahl;
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

    @Override // braucht man hier weil man Object.toString() (standartmethode von java) durch Bank.toString () ersetzen will. Jedes java projekt erbt automatische toString ()
    public String toString() {
        return name + " " + bankleitzahl;
    }
}
