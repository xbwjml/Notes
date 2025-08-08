package concurrent.threadDemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class XiangZi2 implements Callable<Integer> {
    List<Integer> list = new ArrayList<>();
    public XiangZi2(List<Integer> list) {
        this.list = list;
    }

    @Override
    public Integer call() throws Exception {
        List<Integer> bag = new ArrayList<>();
        while (true) {
            synchronized (XiangZi.class) {
                if (list.isEmpty()) {
                    System.out.println();
                    System.out.println(Thread.currentThread().getName() + " 抽中的奖 : " + bag);
                    break;
                }
                Collections.shuffle(list);
                Integer prize = list.remove(0);
                bag.add(prize);
                System.out.println(Thread.currentThread().getName() + " 产生了一个 " + prize + " 元的奖");
            }
            SleepUtils.millisSecond(1);
        }

        if (bag.isEmpty())
            return null;
        return Collections.max(bag);
    }
}

public class ChouJiangTest2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 10,5,30, 50, 100, 200, 500);

        XiangZi2 c1 = new XiangZi2(list);
        XiangZi2 c2 = new XiangZi2(list);

        FutureTask<Integer> ft1 = new FutureTask<>(c1);
        FutureTask<Integer> ft2 = new FutureTask<>(c2);

        Thread t1 = new Thread(ft1);
        Thread t2 = new Thread(ft2);
        t1.setName("一号箱子");
        t2.setName("二号箱子");

        t1.start();
        t2.start();

        System.out.println(t1.getName() + " 最大奖项 : "+ft1.get());
        System.out.println(t2.getName() + " 最大奖项 : "+ft2.get());
    }
}
