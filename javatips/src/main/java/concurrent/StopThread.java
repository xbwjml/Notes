package concurrent;

import java.util.concurrent.TimeUnit;

public class StopThread {

    private static boolean flag;

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            int i = 0;
            while (!flag)
                i++;
        });
        t.start();

        TimeUnit.SECONDS.sleep(1);
        flag = true;
    }
}
