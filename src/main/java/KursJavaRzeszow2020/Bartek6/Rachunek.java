package KursJavaRzeszow2020.Bartek6;

import java.util.Objects;

public class Rachunek {
    private AccountKind accountKind;
    private String AccountNumber;
    private double accountBalance;

    public Rachunek(AccountKind accountKind, String accountNumber, double accountBalance) {
        this.accountKind = accountKind;
        AccountNumber = accountNumber;
        this.accountBalance = 0;
    }

    public Rachunek(String accountNumber) {
        AccountNumber = accountNumber;
    }

    public void setAccountNumber(String accountNumber) { this.AccountNumber = accountNumber; }

    public void setAccountKind(AccountKind accountKind) {
        this.accountKind = accountKind;
    }

    public AccountKind getAccountKind() { return accountKind; }

    public String getAccountNumber() { return AccountNumber; }

    public double getAccountBalance() { return accountBalance; }



    public void deposit(int amount) {

        this.accountBalance += amount;
        System.out.println("Wpłata na rachunek  " +this.AccountNumber + "zostala zaksiegowana");

    }

    public  boolean withdraw(int amount) {
        if(this.accountBalance < amount ){
            System.out.println("Stan konta " + this.AccountNumber + "mniejszy niz żądana kwota " + amount);
            return false;
        }
        this.accountBalance -= amount;
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rachunek rachunek = (Rachunek) o;
        return Objects.equals(AccountNumber, rachunek.AccountNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(AccountNumber);
    }

    @Override
    public String toString() {
        return "Rachunek{" +
                "AccountNumber='" + AccountNumber + '\'' +
                '}';
    }
}
