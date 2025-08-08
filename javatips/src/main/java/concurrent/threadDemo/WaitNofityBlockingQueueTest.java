package concurrent.threadDemo;

import java.util.concurrent.ArrayBlockingQueue;

public class WaitNofityBlockingQueueTest {
    public static void main(String[] args) {
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(1);

        Thread cook = new Thread(() -> {
            while (true) {
                try {
                    queue.put("面条");
                    System.out.println(Thread.currentThread().getName() + " 做了碗面条");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "厨师");

        Thread guest = new Thread(() -> {
            while (true) {
                try {
                    queue.take();
                    System.out.println(Thread.currentThread().getName() + " 吃了碗面条");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "食客");

        cook.start();
        guest.start();
    }
}
