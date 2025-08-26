package concurrent.threadDemo;

import utils.LogUtils;

public class ZhongduanTest {
    public static void main(String[] args) {
        Thread car2 = new Thread(() -> {
            Thread curr = Thread.currentThread();
            LogUtils.log(curr.getName() + " 等待过桥");
            try {
                Thread.sleep(8000);
            } catch (InterruptedException e) {
                LogUtils.log(curr.getName() + " 开始过桥");
            }
            LogUtils.log(curr.getName() + " 过桥完毕");
        }, "二号车");


        Thread car1 = new Thread(() -> {
            Thread curr = Thread.currentThread();
            LogUtils.log(curr.getName() + " 开始过桥");
            SleepUtils.millisSecond(3200);
            LogUtils.log(curr.getName() + " 过桥完毕");
            car2.interrupt();
        }, "一号车");

        car1.start();
        car2.start();
        LogUtils.log("========================");

        //Thread car3 = new Thread(() -> {
        //    long start = System.currentTimeMillis();
        //    while (System.currentTimeMillis() - start < 3) {
        //        //if (Thread.currentThread().isInterrupted()) {
        //        if (Thread.interrupted()) {
        //            LogUtils.log(Thread.currentThread().getName() + " 向左开一米");
        //        } else {
        //            LogUtils.log(Thread.currentThread().getName() + " 向前面开一米");
        //        }
        //    }
        //}, "三号车");
        //
        //car3.interrupt();
        //SleepUtils.millisSecond(1);
        //car3.start();
    }
}
