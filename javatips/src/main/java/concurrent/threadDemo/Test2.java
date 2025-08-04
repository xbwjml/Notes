package concurrent.threadDemo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Counter {
    private int count = 0;
    private Lock lock = new ReentrantLock();

    public void increment() {
        lock.lock();
        try{
            count++;
        } finally {
            lock.unlock();
        }
    }

    public synchronized int getCount() {
        return count;
    }
}

public class Test2 {
    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counter.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counter.increment();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
            System.out.println("最终值 : " + counter.getCount());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
