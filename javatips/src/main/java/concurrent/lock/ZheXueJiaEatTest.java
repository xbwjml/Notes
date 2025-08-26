package concurrent.lock;

import concurrent.threadDemo.SleepUtils;
import utils.LogUtils;

class ChopStick {}

class ZheXueJia extends Thread {
    ChopStick left;
    ChopStick right;

    public ZheXueJia(String name, ChopStick left, ChopStick right) {
        super(name);
        this.left = left;
        this.right = right;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (left) {
                synchronized (right) {
                    eat();
                }
            }
        }
    }

    private void eat() {
        LogUtils.log("eating.....");
        SleepUtils.second(1);
    }
}

public class ZheXueJiaEatTest {
    public static void main(String[] args) {
        ChopStick c1 = new ChopStick();
        ChopStick c2 = new ChopStick();
        ChopStick c3 = new ChopStick();
        ChopStick c4 = new ChopStick();
        ChopStick c5 = new ChopStick();

        new ZheXueJia("aaa", c1, c2).start();
        new ZheXueJia("bbb", c2, c3).start();
        new ZheXueJia("ccc", c3, c4).start();
        new ZheXueJia("ddd", c4, c5).start();
        new ZheXueJia("eee", c5, c1).start();
    }
}
