package concurrent.threadDemo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class OutDatedTest {
    public static void main(String[] args) throws InterruptedException {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        Thread printThread = new Thread(new Runner(), "打印线程");
        printThread.setDaemon(true);
        printThread.start();

        TimeUnit.SECONDS.sleep(3);
        printThread.suspend();
        System.out.println("main suspend 打印线程 at " + format.format(new Date()));

        TimeUnit.SECONDS.sleep(3);
        printThread.resume();
        System.out.println("main resume 打印线程 at " + format.format(new Date()));

        TimeUnit.SECONDS.sleep(3);
        printThread.stop();
        System.out.println("main stop 打印线程 at " + format.format(new Date()));

        TimeUnit.SECONDS.sleep(3);
    }

    static class Runner implements Runnable {
        @Override
        public void run() {
            DateFormat format = new SimpleDateFormat("HH:mm:ss");
            while (true) {
                System.out.println(Thread.currentThread().getName() + " run at " + format.format(new Date()));
                SleepUtils.second(1);
            }
        }
    }

}
