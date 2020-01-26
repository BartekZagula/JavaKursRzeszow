package KursJavaRzeszow2020.Bartek;

public class English extends Person2 {
    private boolean hasGuardian;
    private String taxNumber;
    private String nationality;

    static { //przy uruchamianiu JVM i tworzeniu klasy
        //...
    }

    {
        this.hasGuardian = false;
        this.nationality = "English";
    }

    public English(String FirstName, String LastName, int age, String sex, String taxNumber) {
        super(FirstName, LastName, age, sex);
        this.taxNumber = taxNumber;
    }

    public boolean isHasGuardian() {
        return hasGuardian;
    }

    public void setHasGuardian(boolean hasGuardian) {
        this.hasGuardian = hasGuardian;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    @Override
    public String getIdentity() {
        return taxNumber;
    }

    @Override
    public boolean add(Person2 driver) {
        return false;
    }

    @Override
    public boolean canDriveCar() {
        return (getAge() >16 && isDrivingLicense())||(getAge()>14 && isHasGuardian());
    }

    @Override
    public boolean canRace() {
        return getAge() >12;
    }
}
