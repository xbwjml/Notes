package concurrent.utils;

import concurrent.threadDemo.SleepUtils;
import utils.LogUtils;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                LogUtils.log("running...");
                SleepUtils.second(1);
                LogUtils.log("end...");
                semaphore.release();
            }).start();
        }

        LogUtils.log("====================");
    }
}
