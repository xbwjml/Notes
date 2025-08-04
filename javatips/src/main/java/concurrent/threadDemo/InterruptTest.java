package concurrent.threadDemo;

import java.util.concurrent.TimeUnit;

public class InterruptTest {
    public static void main(String[] args) throws InterruptedException {
        Thread sleepThread = new Thread(new SleepRunner(), "睡觉线程");
        sleepThread.setDaemon(true);

        Thread busyThread = new Thread(new BusyRunner(), "忙碌线程");
        busyThread.setDaemon(true);

        sleepThread.start();
        busyThread.start();

        TimeUnit.SECONDS.sleep(5);

        sleepThread.interrupt();
        busyThread.interrupt();
        System.out.println("SleepThread interrupted is : " + sleepThread.isInterrupted());
        System.out.println("BusyThread interrupted is : " + busyThread.isInterrupted());

        SleepUtils.second(2);
    }

    static class SleepRunner implements Runnable {
        @Override
        public void run() {
            while (true) SleepUtils.second(10);
        }
    }

    static class BusyRunner implements Runnable {
        @Override
        public void run() {
            while (true) {}
        }
    }
}
