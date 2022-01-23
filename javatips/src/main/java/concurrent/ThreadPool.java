package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService pool1 = Executors.newFixedThreadPool(10);
        ExecutorService pool2 = Executors.newSingleThreadExecutor();

        ExecutorService pool3 = Executors.newCachedThreadPool();

    }
}
