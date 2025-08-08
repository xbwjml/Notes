package concurrent.threadDemo;

public class WaitNotifyTest2 {
    static int flag = 0;
    static int total = 10;
    static Object lock = new Object();

    public static void main(String[] args) {
        Thread cook = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    if (total == 0) break;
                    if (flag == 1) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        System.out.println(Thread.currentThread().getName()+ " 做了一碗面条");
                        flag = 1;
                        lock.notifyAll();
                    }
                }
            }
        }, "厨师");

        Thread guest = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    if (total == 0) break;
                    if (flag == 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        total--;
                        System.out.println(Thread.currentThread().getName() + " 正在吃面条,还能再吃 " + total + " 碗");
                        lock.notifyAll();
                        flag = 0;
                    }
                }
            }
        }, "食客");

        /////////////////////
        cook.start();
        guest.start();
    }
}
