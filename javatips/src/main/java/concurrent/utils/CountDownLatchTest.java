package concurrent.utils;

import concurrent.threadDemo.SleepUtils;
import utils.LogUtils;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
    static CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            SleepUtils.second(2);
            LogUtils.log(1);
            countDownLatch.countDown();
        }).start();

        new Thread(() -> {
            SleepUtils.second(3);
            LogUtils.log(2);
            countDownLatch.countDown();
        }).start();

        LogUtils.log("+++++++");

        countDownLatch.await();
        LogUtils.log(3);
    }
}
