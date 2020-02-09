package KursJavaRzeszow2020.Bartek6.migration;

import KursJavaRzeszow2020.Bartek6.AccountKind;
import KursJavaRzeszow2020.Bartek6.Bank;
import KursJavaRzeszow2020.Bartek6.Klient;
import KursJavaRzeszow2020.Bartek6.Rachunek;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//BankData.txt
public class CustomersMigration {
    public List<Klient> migrate(String filename, String separator) {
        List<Klient> customers = new ArrayList<>();
        try {
            FileReader reader = new FileReader((filename));
            Scanner scanner = new Scanner(reader);
            while(scanner.hasNextLine()){
                String[] lineSplit = scanner.nextLine().split(separator);
                Klient klient = new Klient(lineSplit[1],lineSplit[2]);
                List<Rachunek> rachunek = new ArrayList<>();
                for(int index = 3; index<lineSplit.length-1; index +=2) {
                    Rachunek rachunekk = new Rachunek(lineSplit[index]);
                    rachunekk.deposit(Integer.parseInt(lineSplit[index +1]));
                    rachunek.add(rachunekk);
                }
                klient.setBills(rachunek);
                customers.add(klient);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return customers;

    }

    public void addMigratedCustomers(Bank bank, List<Klient> migratedCustomers) {
        // dodajemy identyfikatory zmigrowanym klientom
        migratedCustomers.forEach(k -> {
            k.setUID(bank.getNextCustomerNumber());
            k.getBills().stream().forEach(r-> {
                fixAccountKind(r);
                fixAccountNumber(r, bank.getNextAccountNumber());
            });
        }
        );
        //ustawiamy rodzaje kont i poprawiamy numery IBAN

        //dodajemy zmigrowanych klientow do aktualnych klientow banku
        List<Klient> bankCustomers = bank.getClients();
        bankCustomers.addAll(migratedCustomers);
        bank.setClients(bankCustomers);
    }

    private void fixAccountNumber(Rachunek rachunek, String nextAccountNumber) {
        rachunek.setAccountNumber(nextAccountNumber);

    }

    private void fixAccountKind(Rachunek rachunek) {
        if("O".equals(rachunek.getAccountNumber())){
            rachunek.setAccountKind(AccountKind.SAVINGS);
            return;
        }
        rachunek.setAccountKind(AccountKind.CURRENT);
    }

}
