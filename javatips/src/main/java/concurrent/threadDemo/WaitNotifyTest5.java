package concurrent.threadDemo;

import utils.LogUtils;

public class WaitNotifyTest5 {
    static Object room = new Object();
    static boolean has = false;
    static boolean hasTakeOut = false;

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (room) {
                while (!has) {
                    LogUtils.log("没烟,歇会儿");
                    try {
                        room.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                LogUtils.log("有烟了,开始干活");
            }
        }, "一号员工").start();

        new Thread(() -> {
            synchronized (room) {
                while (!hasTakeOut) {
                    LogUtils.log("没外卖,歇会儿");
                    try {
                        room.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                LogUtils.log("有外卖了,开始干活");
            }
        }, "二号员工").start();

        //for (int i = 0; i < 5; i++) {
        //    new Thread(() -> {
        //        synchronized (room) {
        //            LogUtils.log("可以开始干活了");
        //        }
        //    }, "其他人 " + i).start();
        //}

        SleepUtils.second(1);
        new Thread(() -> {
            synchronized (room) {
                //has = true;
                //LogUtils.log("烟送到了");
                hasTakeOut = true;
                LogUtils.log("外卖送到了");
                room.notifyAll();
            }
        }, "送烟者").start();
    }
}
