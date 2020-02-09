package KursJavaRzeszow2020.Bartek6;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    static Integer customerNumber =0 ;
    static Integer accountNumber =0 ;

    private String name;
    private List<Klient> clients;


    public Bank(String name) {
        this.name = name;
        clients = new ArrayList<>();
    }

    public boolean addCustomer (Klient klient){
        if(checkCustomerOnList(klient)) {
            System.out.println("Klient " + klient + " jest juz w systemie");
            return false;
        }
        klient.setUID(customerNumber.toString());
        clients.add(klient);
        customerNumber++;
        System.out.println("Klient " + klient +"dodany");
        return true;

    }

    public  boolean removeCustomer(Klient klient){
        if (!checkCustomerOnList(klient)) {
            System.out.println("Klient " + klient + " nie jest w systemie");
        }else {
            RemoveClientWithEmptyAccList(klient);
        }
        return false;
    }

    private void RemoveClientWithEmptyAccList(Klient klient) {
        if (klient.getBills().isEmpty()) {
            clients.remove(klient);
            System.out.println("Klient " +klient+ "został usuniety");
        }
        System.out.println("Nie mozna usunąc klienta +" + klient +
                " bo ma otwarte rachunki");
    }

    public  boolean addAccount(Klient klient, AccountKind accountKind){
        if (checkCustomerOnList(klient)) {
            List<Rachunek> customerAccounts = klient.getBills();
            Rachunek rachunek = new Rachunek("IBAN" + accountNumber.toString());
            rachunek.setAccountKind(accountKind);
            customerAccounts.add(rachunek);
            accountNumber++;
            System.out.println("Dla klienta " + klient + "zostalo zalozone konto " +rachunek);
            return  true;
        }
        System.out.println("Nie ma takiego klienta");
        return false;
    }

    public boolean deposit(Klient klient, Rachunek rachunek, int amount){
        if(clients.contains(klient)){
            List<Rachunek> accounts = klient.getBills();
                    if(accounts.contains(rachunek)) {
                        accounts.get(accounts.indexOf(rachunek)).deposit(amount);
                        System.out.println("Wpłata " +amount+ " na rachunek" +
                                rachunek + " zaksiegowana");
                    }

        }
        System.out.println("Nie ma takiego klienta");
        return false;
    }

    public boolean deposit(Klient klient, Rachunek rachunek, int amount){
        if(clients.contains(klient)){
            List<Rachunek> accounts = klient.getBills();
                    if(accounts.contains(rachunek)) {
                        accounts.get(accounts.indexOf(rachunek)).deposit(amount);
                        System.out.println("Wpłata " +amount+ " na rachunek" +
                                rachunek + " zaksiegowana");
                    }

        }
        System.out.println("Nie ma takiego klienta");
        return false;
    }


    private boolean checkCustomerOnList(Klient klient) {
        return clients.contains(klient);
    }


}