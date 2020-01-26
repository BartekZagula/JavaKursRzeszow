package KursJavaRzeszow2020.Bartek3;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SilniaTest {


    @Before
    public void setup(){
        System.out.println("Biforek");
    }
    @After
    public void clean() {
        System.out.println("Afterek");
    }
    Silnia silnia = new Silnia();

    @Test
    public void silnia() {

        int silniaVakue = Silnia.silnia(6);
        assertEquals(720,silniaVakue);
    }

    @Test
    public void testSilnia5(){
        int silniaValue = Silnia.silnia(5);
        assertEquals(120, silniaValue);
    }
}