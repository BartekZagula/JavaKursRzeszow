package KursJavaRzeszow2020.Bartek5.basics;

import static KursJavaRzeszow2020.Bartek5.ThreadColor.ANSI_RED;

public class RunnableSample implements Runnable {
    @Override
    public void run() {
        System.out.println(ANSI_RED + " Runnable sample working");

    }
}
