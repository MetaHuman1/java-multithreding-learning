public class Ex4 extends Thread{
    @Override
    public void run() {
        for (int i = 1; i<10;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new MyRunnable1());
        System.out.println(thread1.getState());
        Thread thread2 = new Thread(new Ex4());
        thread1.start();
        System.out.println(thread1.getState());
        thread2.start();

        thread1.join();
        System.out.println(thread1.getState());
        thread2.join();

        System.out.println("end");
    }
}

class  MyRunnable1 implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i<10;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}
