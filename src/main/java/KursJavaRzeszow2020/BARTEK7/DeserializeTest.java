package KursJavaRzeszow2020.BARTEK7;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
public class DeserializeTest {
    public static void main(String[] args) {
        Person person = null;
        FileInputStream file = null;
        try {
            file = new FileInputStream("Personserialized.data");
            ObjectInputStream ois = new ObjectInputStream(file);
            person = (Person) ois.readObject();
            ois.close();
            file.close();
            System.out.println(person.getName()+ " "+ person.getSurname());
            System.out.println(person.getAge());
            System.out.println(person.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
