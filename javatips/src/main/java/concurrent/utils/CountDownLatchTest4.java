package concurrent.utils;

import concurrent.threadDemo.SleepUtils;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchTest4 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        ExecutorService service = Executors.newFixedThreadPool(10);
        String[] all = new String[10];
        Random random = new Random();

        for (int j = 0; j < 10; j++) {
            int k = j;
            service.submit(() -> {
                for (int i = 0; i <= 100; i++) {
                    SleepUtils.millisSecond(random.nextInt(100));
                    all[k] = i + " %";
                    System.out.print("\r" + Arrays.toString(all));
                }
                countDownLatch.countDown();
            });
        }

        System.out.println("准备加载");
        countDownLatch.await();
        System.out.println("\n游戏开始");

        service.shutdown();
    }
}
