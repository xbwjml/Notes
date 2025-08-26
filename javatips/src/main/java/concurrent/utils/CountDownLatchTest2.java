package concurrent.utils;

import concurrent.threadDemo.SleepUtils;
import utils.LogUtils;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest2 {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);

        new Thread(() -> {
            LogUtils.log("start");
            SleepUtils.second(3);
            LogUtils.log("end");
            latch.countDown();
        }).start();

        new Thread(() -> {
            LogUtils.log("start");
            SleepUtils.second(1);
            LogUtils.log("end");
            latch.countDown();
        }).start();

        new Thread(() -> {
            LogUtils.log("start");
            SleepUtils.second(2);
            LogUtils.log("end");
            latch.countDown();
        }).start();

        LogUtils.log(Thread.currentThread().getName() + "  等待中");
        latch.await();

        LogUtils.log("!!!!!!!!");
    }
}
