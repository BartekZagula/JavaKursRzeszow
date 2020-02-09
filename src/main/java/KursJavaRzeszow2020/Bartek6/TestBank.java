package KursJavaRzeszow2020.Bartek6;

import KursJavaRzeszow2020.Bartek6.migration.CustomersMigration;

import java.util.List;

public class TestBank {

    public static void main(String[] args) {
        Bank bank = new Bank("SDA Bank");
        Klient klient1 = new Klient("Jan", "Kowalski");
        Klient klient2 = new Klient("Maria", "Kowalska");
        Klient klient3 = new Klient("Danuta", "Kowalsky");

        bank.addCustomer(klient1);
        bank.addCustomer(klient2);
        bank.addCustomer(klient3);

        bank.addAccount(klient1, AccountKind.CURRENT);
        bank.addAccount(klient2, AccountKind.CURRENT);
        bank.addAccount(klient3, AccountKind.CURRENT);
        bank.addAccount(klient3, AccountKind.SAVINGS);
        bank.addAccount(klient1, AccountKind.SAVINGS);

        bank.printCustomerList(true);
        Rachunek rachunek = klient1.getBills().get(0);
        bank.deposit(klient1, rachunek, 10);
        rachunek = klient3.getBills().get(1);
        bank.deposit(klient3, rachunek, 25);

        bank.printCustomerList(true);
        CustomersMigration migration = new CustomersMigration();
        List<Klient> migratedCustomers = migration.migrate("BankData.txt", "\\|");
        migration.addMigratedCustomers(bank,migratedCustomers);

        System.out.println("Migration done");
        bank.printCustomerList(true);

        bank.printAllBankAccounts();
    }
}
