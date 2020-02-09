package KursJavaRzeszow2020.Bartek6;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Klient  {
    private String FirstName;
    private String SecondName;
    private String UID;
    private List<Rachunek> bills;

    public Klient(String firstName, String secondName) {
        FirstName = firstName;
        SecondName = secondName;
        bills = new ArrayList<>();
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getSecondName() {
        return SecondName;
    }

    public List<Rachunek> getBills() {
        return bills;
    }

    public void setBills(List<Rachunek> bills) {
        this.bills = bills;
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Klient klient = (Klient) o;
        return Objects.equals(FirstName, klient.FirstName) &&
                Objects.equals(SecondName, klient.SecondName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(FirstName, SecondName);
    }

    @Override
    public String toString() {
        return "Pan/Pani " + FirstName +" "
                 + SecondName;
    }
}

