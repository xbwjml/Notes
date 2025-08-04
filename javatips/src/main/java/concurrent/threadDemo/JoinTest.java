package concurrent.threadDemo;


import java.util.concurrent.TimeUnit;

public class JoinTest {
    public static void main(String[] args) throws InterruptedException {
        Thread prev = Thread.currentThread();
        for (int i = 0; i< 10; i++) {
            Thread thread = new Thread(new Domino(prev), "线程 - " + i);
            thread.start();
            prev = thread;
        }

        System.out.println("11111111");
        TimeUnit.SECONDS.sleep(5);
        System.out.println(Thread.currentThread().getName() + " 结束了.");
    }

    static class Domino implements Runnable {
        private Thread prevThread;
        public Domino(Thread thread) {
            this.prevThread = thread;
        }
        @Override
        public void run() {
            try {
                prevThread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " 结束了.");
        }
    }

}
