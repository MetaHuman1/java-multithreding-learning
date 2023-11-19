import java.util.TreeMap;
import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    public static void main(String[] args) {
        Semaphore callBox = new Semaphore(2);

        new Person("Oleg", callBox);
        new Person("Masha", callBox);
        new Person("Gena", callBox);
        new Person("Marina", callBox);
        new Person("Alesha", callBox);
    }
}

class Person extends Thread {
    String name;
    private Semaphore callBox;
    public Person (String name, Semaphore callBox) {
        this.name = name;
        this.callBox = callBox;
        this.start();
    }

    public void run() {

           System.out.println(name + " ждет...");
        try {
            callBox.acquire();
            System.out.println(name + " пользуется телефоном");
            Thread.sleep(2000);
            System.out.println(name + " завершил(а) звонок");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            callBox.release();
        }

    }
}


















