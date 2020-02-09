package KursJavaRzeszow2020.Bartek5.basics;

import static KursJavaRzeszow2020.Bartek5.ThreadColor.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(ANSI_PURPLE +" Main thread in action");

        Thread otherThread = new OtherThread();
        otherThread.setName("=== Other Thread ===");
        otherThread.start();
        Thread runnableSample = new Thread(new RunnableSample());
        runnableSample.start();
        System.out.println(ANSI_PURPLE + " End of main");

        // watek na klasie anonimowej

        new Thread() {
            public void run() {
                System.out.println(ANSI_GREEN + " Anonymous class based thread");
            }
        }.start();


        runnableSample = new Thread(new RunnableSample(){
            @Override
            public void run() {
                System.out.println(ANSI_RED + " ovveridden RunnableSample");
                try {
                    otherThread.join();
                    System.out.println(ANSI_RED + " Other thread terminated"
                    + " so i Work Aagain");
                } catch (InterruptedException e) {
                    System.out.println(ANSI_RED + " overriden Runnable terminated");
                }
            }
        });
        runnableSample.start();
        //otherThread.interrupt();




    }
}
