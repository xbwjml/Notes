package concurrent.threadDemo;

public class YieldTest {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
           for (int i = 0; i < 100; i++) {
               System.out.println(Thread.currentThread().getName() + " : " + i);
               Thread.yield();
           }
        }, "线程1");

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
                Thread.yield();
            }
        }, "线程2");

        t1.start();
        t2.start();
    }
}
