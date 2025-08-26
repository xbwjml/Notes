package concurrent.utils;

import concurrent.threadDemo.SleepUtils;
import utils.LogUtils;

import java.nio.file.LinkOption;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.*;

public class BankWaterService implements Runnable {
    private CyclicBarrier cyclicBarrier = new CyclicBarrier(4, this);
    private Executor executor = Executors.newFixedThreadPool(4);
    private ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

    private void count() {
        for (int i = 0; i < 4; i++) {
            executor.execute(() -> {
                map.put(Thread.currentThread().getName(), 1);
                try {
                    int t = new Random().nextInt(1, 10);
                    SleepUtils.second(t);
                    LogUtils.log("开始 await");
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }

    @Override
    public void run() {
        int res = 0;
        for (Map.Entry<String, Integer> sheet : map.entrySet())
            res += sheet.getValue();

        map.put("res", res);
        LogUtils.log(res);
    }

    public static void main(String[] args) {
        BankWaterService bankWaterService = new BankWaterService();
        LogUtils.log("===================");
        bankWaterService.count();
    }
}
