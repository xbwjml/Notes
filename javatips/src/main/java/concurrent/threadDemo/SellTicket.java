package concurrent.threadDemo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BuyThread extends Thread {
    static int ticket = 0;
    static Object obj = new Object();
    static Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            lock.lock();
            try {
                if (ticket < 100) {
                    SleepUtils.millisSecond(1);
                    ticket++;
                    System.out.println(Thread.currentThread().getName()
                            + " 正在买第 " + ticket + " 张票");
                } else {
                    break;
                }
            } finally {
                lock.unlock();
            }
        }
    }
}

public class SellTicket {
    public static void main(String[] args) {
        BuyThread t1 = new BuyThread();
        BuyThread t2 = new BuyThread();
        BuyThread t3 = new BuyThread();
        t1.setName("窗口-1-");
        t2.setName("窗口-2-");
        t3.setName("窗口-3-");

        t1.start();
        t2.start();
        t3.start();
    }
}
