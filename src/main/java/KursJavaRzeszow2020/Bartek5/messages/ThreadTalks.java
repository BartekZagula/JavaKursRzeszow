package KursJavaRzeszow2020.Bartek5.messages;

import java.util.Random;

public class ThreadTalks {

    public static void main(String[] args) {
        Message message = new Message();
        (new Thread(new Writer(message))).start();
        (new Thread(new Reader(message))).start();

    }
}

class Message {
    private String message;
    private boolean empty;

    public synchronized String read() {
        while(empty) {
            try{
                wait();
            } catch (InterruptedException e) {
                System.out.println("Błąd odczytu");
            }
        }

        empty = true;
        notifyAll();
        return message;
    }

    public  synchronized void write(String message) {
        while(!empty) {
            try{
                wait();
            }
            catch (InterruptedException e){
                System.out.println("Błąd zapisu");
            }
    }
        empty = false;
        this.message = message;
        notifyAll();
}
}

//producer

class Writer implements Runnable {
    private Message message;
    private String[] messages = {
      "Line 1", "Line 2", "Line 3", "Line 4"
    };

    public Writer(Message message) {
        this.message = message;
    }

    @Override
    public void run() {

        Random random = new Random();
        for (int i = 0; i < messages.length; i++) {
            message.write(messages[i]);
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        message.write("FIN!");
    }
}

//consumer
    class Reader implements Runnable{
    private  Message message;

    public Reader(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        Random random = new Random();
        for (String lastestMessage = message.read(); lastestMessage != "FIN!";
        lastestMessage = message.read()) {
            System.out.println("Odczytano " + lastestMessage);
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

