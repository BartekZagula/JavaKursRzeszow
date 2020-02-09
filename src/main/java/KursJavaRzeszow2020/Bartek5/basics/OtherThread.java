package KursJavaRzeszow2020.Bartek5.basics;

import static KursJavaRzeszow2020.Bartek5.ThreadColor.ANSI_BLUE;

public class OtherThread extends Thread {

    @Override
    public void run() {
        System.out.println(ANSI_BLUE + " thread name : " +currentThread().getName());

        try {
            sleep(3000);
        } catch (InterruptedException e) {
            System.out.println(ANSI_BLUE + " sombody woke me up");
            return;
        }
        System.out.println(ANSI_BLUE + " enough sleeping, back to work");
    }
}
