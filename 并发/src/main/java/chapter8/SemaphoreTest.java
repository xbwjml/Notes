package chapter8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {

    private static final int THREAD_COUNT = 30;
    private static ExecutorService pool =  Executors.newFixedThreadPool(THREAD_COUNT);
    private static Semaphore s = new Semaphore(10);

    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            pool.execute(()->{
                try {
                    s.acquire();
                    System.out.println("save data");
                    s.release();
                }catch (Exception e){}
            });
        }

        pool.shutdown();
    }
}
