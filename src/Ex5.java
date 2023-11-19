public class Ex5 {
    public static void main(String[] args) {
        MyRunnableImpl1 runnable = new MyRunnableImpl1();
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class Counter1 {
    static int count = 0;
}

class  MyRunnableImpl1 implements Runnable {
    public synchronized void  increment () {
        Counter1.count++;
        System.out.println(Counter1.count + " ");
    }

    @Override
    public void run() {
        for (int i = 0; i<10; i++) {
            increment();
        }
    }
}










