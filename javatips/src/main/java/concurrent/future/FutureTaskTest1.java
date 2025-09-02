package concurrent.future;

import concurrent.threadDemo.SleepUtils;
import lombok.extern.java.Log;
import utils.LogUtils;

import java.util.concurrent.*;

public class FutureTaskTest1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);
        LogUtils.log("=================================");

        Future<String> f1 = service.submit(() -> {
            SleepUtils.second(5);
            LogUtils.log(" 1 done.");
            return Thread.currentThread().getName();
        });

        Future<String> f2 = service.submit(() -> {
            SleepUtils.second(4);
            LogUtils.log(" 2 done.");
            return Thread.currentThread().getName();
        });

        Future<String> f3 = service.submit(() -> {
            SleepUtils.second(6);
            LogUtils.log(" 3 done.");
            return Thread.currentThread().getName();
        });


        LogUtils.log("111111");
        f1.get();
        f2.get();
        f3.get();

        Callable<String> c1 = () -> {
            LogUtils.log("c1 start");
            SleepUtils.second(2);
            return "c1";
        };
        FutureTask<String> ft1 = new FutureTask<>(c1);
        new Thread(ft1).start();
        LogUtils.log(ft1.get());

        FutureTask<String> ft2 = new FutureTask<>( () -> {
            LogUtils.log("c2 start");
            SleepUtils.second(2);
            return "c2";
        });
        service.submit(ft2);
        LogUtils.log(ft2.get());

        LogUtils.log("done");
        service.shutdown();
    }
}
