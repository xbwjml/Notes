package chapter4;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Depcreated {
    public static void main(String[] args) throws InterruptedException {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        Thread printThread = new Thread(new Runner(), "Print Thread");
        printThread.setDaemon(true);
        printThread.start();
        TimeUnit.SECONDS.sleep(3);
        printThread.suspend();
        System.out.println("main Thread printThread at " + format.format(new Date()) );
        TimeUnit.SECONDS.sleep(3);

        printThread.resume();
        System.out.println("main Thread printThread at " + format.format(new Date()) );
        TimeUnit.SECONDS.sleep(3);
        printThread.stop();
        System.out.println("main Thread printThread at " + format.format(new Date()) );
        TimeUnit.SECONDS.sleep(3);

    }

    static class Runner implements Runnable{
        @Override
        public void run() {
            SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
            while (true) {
                System.out.println(Thread.currentThread().getName()+" Run at " + format.format(new Date()) );
                SleepUtils.sleepSecond(1);
            }
        }
    }
}
