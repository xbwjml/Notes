package concurrent.threadDemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class XiangZi extends Thread {
    List<Integer> list = new ArrayList<>();
    public XiangZi(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (XiangZi.class) {
                List<Integer> bag = new ArrayList<>();
                if (list.isEmpty()) {
                    System.out.println();
                    System.out.println(getName() + " 抽中的奖 : " + bag);
                    break;
                }
                Collections.shuffle(list);
                Integer prize = list.remove(0);
                bag.add(prize);
                System.out.println(getName() + " 产生了一个 " + prize + " 元的奖");
            }
            SleepUtils.millisSecond(1);
        }
    }
}

public class ChouJiangTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 10,5,30, 50, 100, 200, 500);

        XiangZi t1 = new XiangZi(list);
        XiangZi t2 = new XiangZi(list);
        t1.setName("一号抽奖箱");
        t2.setName("二号抽奖箱");
        t1.start();
        t2.start();
    }
}
