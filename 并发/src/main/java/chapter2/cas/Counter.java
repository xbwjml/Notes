package chapter2.cas;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    private AtomicInteger atomibI = new AtomicInteger(0);

    private int i=0;

    public static void main(String[] args) {
        final Counter counter = new Counter();
        ArrayList<Thread> ts = new ArrayList<>(600);
        long start = System.currentTimeMillis();
        for (int j=0; j<100; j++){
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10000; i++) {
                        counter.count();
                        counter.safeCount();
                    }
                }
            });
            ts.add(t);
        }

        ts.forEach(e->e.start());

        for (Thread t : ts){
            try {
                t.join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        System.out.println(counter.i);
        System.out.println(counter.atomibI.get());
        System.out.println(System.currentTimeMillis()-start);
    }

    private void safeCount(){
        for (;;){
            int i = atomibI.get();
            boolean suc = atomibI.compareAndSet(i, ++i);
            if(suc)
                break;
        }
    }

    private void count(){
        i++;
    }
}
