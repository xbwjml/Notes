package concurrent.utils;

import concurrent.threadDemo.SleepUtils;
import utils.LogUtils;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierTest4 {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2,
                () -> LogUtils.log("!!!!!!!")
        );

        for (int i = 0; i < 3; i++) {
            service.submit(() -> {
                LogUtils.log("task1 begin");
                SleepUtils.second(3);
                try {
                    cyclicBarrier.await();
                    LogUtils.log("task1 after await");
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });

            service.submit(() -> {
                LogUtils.log("task2 begin");
                SleepUtils.second(4);
                try {
                    cyclicBarrier.await();
                    LogUtils.log("task2 after await");
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }

        LogUtils.log("====================");
        service.shutdown();
    }
}
