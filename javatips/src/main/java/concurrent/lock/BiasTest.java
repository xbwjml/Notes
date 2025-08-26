package concurrent.lock;

import concurrent.threadDemo.SleepUtils;
import org.openjdk.jol.info.ClassLayout;
import utils.LogUtils;

class Dogg {

}

public class BiasTest {
    public static void main(String[] args) {
        Dogg dogg = new Dogg();
        ClassLayout classLayout = ClassLayout.parseInstance(dogg);

        Thread t1 = new Thread(() -> {
            LogUtils.log(classLayout.toPrintable());
            synchronized (dogg) {
                LogUtils.log(classLayout.toPrintable());
            }
            LogUtils.log(classLayout.toPrintable());
        });

        Thread t2 = new Thread(() -> {
            LogUtils.log(classLayout.toPrintable());
            synchronized (dogg) {
                LogUtils.log(classLayout.toPrintable());
            }
            LogUtils.log(classLayout.toPrintable());
        });

        t1.start();
        SleepUtils.second(1);
        t2.start();
    }
}
