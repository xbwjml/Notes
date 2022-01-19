package chapter4;

import java.util.concurrent.TimeUnit;

public class SleepUtils {
    public static final void sleepSecond(long seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
