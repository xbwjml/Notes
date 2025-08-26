package concurrent.threadDemo;

import utils.LogUtils;

public class DeadLockTest2 {
    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();

        new Thread(() -> {
            synchronized (lock1) {
                LogUtils.log("111111");
                SleepUtils.second(1);
                synchronized (lock2) {
                    LogUtils.log("222222");
                }
            }
        }, "线程A").start();

        new Thread(() -> {
            synchronized (lock2) {
                LogUtils.log("333333");
                SleepUtils.second(1);
                synchronized (lock1) {
                    LogUtils.log("44444444");
                }
            }
        }, "线程B").start();

    }
}
