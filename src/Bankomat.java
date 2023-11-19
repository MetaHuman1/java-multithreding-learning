import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bankomat {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();

        new Employee("Petr",lock);
        new Employee("Elena",lock);
        new Employee("Gena",lock);
        new Employee("Masha",lock);
    }
}

class Employee extends Thread{
    String name;
    private Lock lock;
    public Employee(String name, Lock lock) {
        this.name = name;
        this.lock = lock;
        this.start();
    }

    public void run() {
        System.out.println(name + " ждет... ");
        lock.lock();
        System.out.println(name + " пользуется банкоматом");
        try {
            Thread.sleep(2000);
            System.out.println(name + " завершил(а) свои дела");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            lock.unlock();
        }
    }

}



























