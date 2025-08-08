package concurrent.threadDemo;


import java.util.Random;

class HongBaoPeople extends Thread{
    static double totalMoney = 100;
    static int count = 3;
    static final double MIN = 0.01;

    @Override
    public void run() {
        synchronized (HongBaoPeople.class) {
            if (count == 0) {
                System.out.println(getName() + " 没有抢到红包");
                return;
            }

            double prize = 0;
            if (count == 1) {
                prize = totalMoney;
            } else{
                prize = new Random().nextDouble(totalMoney - (count - 1) * MIN);
                if (prize < MIN) prize = MIN;
            }

            totalMoney -= prize;
            count--;
            System.out.println(getName() + " 抢到了 " + prize + " 元");
        }
    }
}

public class HongBaoTest {
    public static void main(String[] args) {
        HongBaoPeople t1 = new HongBaoPeople();
        HongBaoPeople t2 = new HongBaoPeople();
        HongBaoPeople t3 = new HongBaoPeople();
        HongBaoPeople t4 = new HongBaoPeople();
        HongBaoPeople t5 = new HongBaoPeople();
        t1.setName("a");
        t2.setName("b");
        t3.setName("c");
        t4.setName("d");
        t5.setName("e");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
