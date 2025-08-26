package concurrent.lock;

import concurrent.threadDemo.SleepUtils;
import utils.LogUtils;

public class HuoSuotest {
    static volatile int count = 10;
    public static void main(String[] args) {
        new Thread(() -> {
            while (count > 0) {
                SleepUtils.second(1);
                count--;
                LogUtils.log("count : " + count);
            }
        }, "t1").start();

        new Thread(() -> {
            while (count < 20) {
                SleepUtils.second(1);
                count++;
                LogUtils.log("count : " + count);
            }
        }, "t3").start();
    }
}
