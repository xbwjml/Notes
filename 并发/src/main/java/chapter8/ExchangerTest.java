package chapter8;

import java.util.concurrent.Exchanger;

public class ExchangerTest {
    public static void main(String[] args) {
        Exchanger<String> stringExchanger = new Exchanger<>();

        Thread studentA = new Thread(() -> {
            try {
                String dataA = "A同学收藏多年的大片";
                System.out.println("A原来有 "+dataA);
                String kk = stringExchanger.exchange(dataA);
                System.out.println("A同学得到了" + kk);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread studentB = new Thread(() -> {
            try {
                String dataB = "B同学收藏多年的大片";
                System.out.println("B原来有 "+dataB);
                String xx = stringExchanger.exchange(dataB);
                System.out.println("B同学得到了" + xx);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        studentA.start();
        studentB.start();
    }
}
