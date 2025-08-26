package concurrent.utils;

import concurrent.threadDemo.SleepUtils;
import utils.LogUtils;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchTest3 {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(3);

        ExecutorService service = Executors.newFixedThreadPool(4);

        service.submit(() -> {
            LogUtils.log("start");
            SleepUtils.second(6);
            LogUtils.log("end");
            latch.countDown();
        });

        service.submit(() -> {
            LogUtils.log("start");
            SleepUtils.second(2);
            LogUtils.log("end");
            latch.countDown();
        });

        service.submit(() -> {
            LogUtils.log("start");
            SleepUtils.second(5);
            LogUtils.log("end");
            latch.countDown();
        });

        LogUtils.log("==================");
        service.submit(() -> {
            try {
                LogUtils.log("before await");
                latch.await();
                LogUtils.log("after await");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        LogUtils.log("------------------");
        service.shutdown();
    }
}
