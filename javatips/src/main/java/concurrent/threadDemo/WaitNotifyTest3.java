package concurrent.threadDemo;

import utils.LogUtils;

public class WaitNotifyTest3 {
    static Object OBJ = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            LogUtils.log(Thread.currentThread().getName() + " 启动");
            synchronized (OBJ) {
                try {
                    OBJ.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                LogUtils.log(Thread.currentThread().getName() + " 不等了");
            }
        }, "t1").start();

        new Thread(() -> {
            LogUtils.log(Thread.currentThread().getName() + " 启动");
            synchronized (OBJ) {
                try {
                    OBJ.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                LogUtils.log(Thread.currentThread().getName() + " 不等了");
            }
        }, "t2").start();

        SleepUtils.second(3);

        LogUtils.log(Thread.currentThread().getName() + " 准备唤醒其他的线程");
        synchronized (OBJ) {
            OBJ.notifyAll();
        }
        LogUtils.log("=====");
    }
}
