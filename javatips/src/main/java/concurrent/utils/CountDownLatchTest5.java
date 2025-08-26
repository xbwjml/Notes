package concurrent.utils;

import concurrent.threadDemo.SleepUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class CountDownLatchTest5 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService service = Executors.newFixedThreadPool(10);
        String[] all = new String[10];
        Random random = new Random();
        List<Future<String>> list = new ArrayList<>();

        for (int j = 0; j < 10; j++) {
            int k = j;
            Future<String> f = service.submit(() -> {
                for (int i = 0; i <= 100; i++) {
                    SleepUtils.millisSecond(random.nextInt(200));
                    all[k] = i + " %";
                    System.out.print("\r" + Arrays.toString(all));
                }
                return "" + k;
            });
            list.add(f);
        }

        System.out.println("准备加载");
        for (Future<String> f : list) {
            String s = f.get();
        }
        System.out.println("\n游戏开始");

        service.shutdown();
    }
}
