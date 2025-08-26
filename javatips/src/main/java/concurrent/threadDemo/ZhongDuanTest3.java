package concurrent.threadDemo;

import utils.LogUtils;

public class ZhongDuanTest3 {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            try {
                LogUtils.log("开始睡眠");
                Thread.sleep(3000);
                LogUtils.log("结束睡眠");
            } catch (InterruptedException e) {
                LogUtils.log("异常了");
                LogUtils.log(Thread.currentThread().isInterrupted());
                LogUtils.log(Thread.currentThread().isInterrupted());
                Thread.currentThread().interrupt();
                LogUtils.log(Thread.currentThread().isInterrupted());
                LogUtils.log(Thread.currentThread().isInterrupted());
            }
        }, "试验线程");

        t.start();
        SleepUtils.second(1);
        t.interrupt();
    }
}
