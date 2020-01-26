package KursJavaRzeszow2020.Bartek;
import java.util.Optional;

public abstract class Person2 implements Driver {
    private String firstName;
    private String lastName;
    private int age;
    private Sex sex;
    private boolean drivingLicense;

    public Person2() {
    }

    public Person2(String firstName, String lastName, int age, String sex) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.sex = Sex.getByShortName(sex);
    }

    public Person2(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSexShortName() {
        return Optional.ofNullable(sex).map(Sex::getShortName).orElse("");
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public boolean isDrivingLicense() {
        return drivingLicense;
    }

    public void setDrivingLicense(boolean drivingLicense) {
        this.drivingLicense = drivingLicense;
    }

    public boolean isRetired() {
        if(this.sex ==Sex.MAN && this.age > 67) return true;
        if(this.sex ==Sex.WOMAN && this.age > 65) return true;
        return false;
    }
    //CTRL + /
    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", sex='" + getSexShortName() + '\'' +
                '}';
    }

    public abstract String getIdentity();

    public abstract boolean add(Person2 driver);
}
