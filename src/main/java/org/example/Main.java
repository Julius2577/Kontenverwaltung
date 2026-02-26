package org.example;


public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("Meine Bank", "DE 12345678");

        Konto konto1 = new Konto("DE123456", 1000, 500, "Hans", "Bebelhof");
        Konto konto2 = new Konto("DE132456", 500, 300, "Günther","Magniviertel");

        bank.addKonto(konto1);
        bank.addKonto(konto2);

        boolean erfolg = bank.ueberweisen("DE123456", "DE132456", 300);



        konto1.einzahlen(1000);
        konto2.einzahlen(750);

        konto1.abheben(300);

        System.out.println("Überweisung erfolgreich: " + erfolg);
        System.out.println("Saldo Konto 1: " + konto1.getSaldo());
        System.out.println("Saldo Konto 2: " + konto2.getSaldo());





    }
}