package leetCode;

public class TestVola {
    public static volatile int race = 0;

    public static void increase(){
        race++;
    }

    public static final int THREADS_COUNT = 20;

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREADS_COUNT];
        for(int i=0; i<THREADS_COUNT; i++){
            threads[i] = new Thread(()->{
               for(int j=0; j<1000; j++)
                   increase();
            });
            threads[i].start();
        }

        while (Thread.activeCount() > 1)
            Thread.yield();

        System.out.println(race);
    }
}
