package concurrent.threadDemo;

import utils.LogUtils;

import java.util.concurrent.locks.LockSupport;

public class ParkTest {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            LogUtils.log("start");
            SleepUtils.second(3);
            LogUtils.log("park");
            LockSupport.park();
            LogUtils.log("resume");
        }, "t1");
        t1.start();

        SleepUtils.second(1);
        LogUtils.log("unpark");
        LockSupport.unpark(t1);
    }
}
