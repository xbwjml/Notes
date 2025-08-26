package concurrent.utils;

import utils.LogUtils;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest3 {
    static CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        });

        LogUtils.log(cyclicBarrier.getNumberWaiting());
        thread.start();
        LogUtils.log(cyclicBarrier.getNumberWaiting());
        thread.interrupt();

        try {
            LogUtils.log(cyclicBarrier.getNumberWaiting());
            cyclicBarrier.await();
        } catch (Exception e) {
            LogUtils.log(cyclicBarrier.isBroken());
            LogUtils.log(cyclicBarrier.getNumberWaiting());
        }
    }
}
