package concurrent.threadDemo;

import utils.LogUtils;

public class WaitNotifyTest4 {
    static final Object lock = new Object();
    public static void main(String[] args) {
        new Thread(() -> {
            LogUtils.log("启动");
            synchronized (lock) {
                try {
                    Thread.sleep(8000);
                    //lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                LogUtils.log("sleep完毕");
            }
        }, "t1").start();

        SleepUtils.second(1);
        LogUtils.log("------------");
        synchronized (lock) {
            LogUtils.log("获取锁了");
        }
    }
}
