package chapter8;

import java.util.concurrent.CyclicBarrier;

public class CybicBarrierTest {
    static CyclicBarrier c = new CyclicBarrier(2);
    public static void main(String[] args) {
        new Thread(()->{
          try {
              System.out.println(0);
              c.await();
              System.out.println(1);
          }catch (Exception e){}
        }).start();

        try{
            System.out.println("a");
            c.await();
            System.out.println("b");
        }catch (Exception e){}

        System.out.println(2);
    }
}
