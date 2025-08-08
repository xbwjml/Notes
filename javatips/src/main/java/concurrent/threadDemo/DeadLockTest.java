package concurrent.threadDemo;
class ThreadDlg extends Thread {
    static Object objA = new Object();
    static Object objB = new Object();

    @Override
    public void run() {
        while (true) {
            String name = getName();
            if ("线程A".equals(name)) {
                synchronized (objA) {
                    System.out.println(name + " 拿到了A锁,准备拿B锁");
                    synchronized (objB) {
                        System.out.println(name + " 拿到了B锁,顺利执行完一轮");
                    }
                }
            }
            if ("线程B".equals(name)) {
                synchronized (objB) {
                    System.out.println(name + " 拿到了B锁,准备拿A锁");
                    synchronized (objA) {
                        System.out.println(name + " 拿到了A锁,顺利执行完一轮");
                    }
                }
            }
        }
    }

}

public class DeadLockTest {
    public static void main(String[] args) {
        ThreadDlg t1 = new ThreadDlg();
        ThreadDlg t2 = new ThreadDlg();
        t1.setName("线程A");
        t2.setName("线程B");

        t1.start();
        t2.start();
    }
}
