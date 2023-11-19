public class InterruptionExample {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("main starts");
        InterruptedThread thread = new InterruptedThread();
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();

        thread.join();
        System.out.println("main ends");
    }
}

class InterruptedThread extends Thread {
    public void run() {
        double sqrtSum = 0;
        for (int i = 1; i <= 1000000000; i++) {
            if (isInterrupted()) {
                System.out.println("Поток хотят прервать");
                System.out.println("Мы убедились что состояние " +
                        " всех обьектов нормальное и решили завершить работу потока");
                System.out.println(sqrtSum);
                return;
            }
                sqrtSum += Math.sqrt(i);
            try {
                sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Поток хотят прервать во время сна давайте завершим его работу");
                System.out.println(sqrtSum);
                return;
            }
        }
        System.out.println(sqrtSum);
    }
}












