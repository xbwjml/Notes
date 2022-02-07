package chapter8;

import java.util.concurrent.CyclicBarrier;

public class CybicBarrierTest2 {
    static CyclicBarrier c = new CyclicBarrier(2, ()-> System.out.println("AAA"));
    public static void main(String[] args) {
        new Thread(()->{
            try {
                System.out.println(0);
                c.await();
            }catch (Exception e){}
            System.out.println(1);
        }).start();

        try {
            System.out.println("a");
            c.await();
        }catch (Exception e){}
        System.out.println("b");

    }

}
