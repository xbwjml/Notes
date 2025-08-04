package concurrent.threadDemo;

import java.util.concurrent.TimeUnit;

public class ShutDownTest {
    public static void main(String[] args) throws InterruptedException {
        Runner one = new Runner();
        Thread countThread = new Thread(one, "计数线程");
        countThread.start();

        TimeUnit.SECONDS.sleep(1);
        countThread.interrupt();

        Runner two = new Runner();
        countThread = new Thread(two, "计数线程2");
        countThread.start();

        TimeUnit.SECONDS.sleep(1);
        two.cancel();
    }

    static class Runner implements Runnable {
        private long i;
        private volatile boolean on = true;
        @Override
        public void run() {
            while (on && !Thread.currentThread().isInterrupted()) {
                i++;
            }
            System.out.println("count i = " + i);
        }

        public void cancel() {
            on = false;
        }

    }
}
