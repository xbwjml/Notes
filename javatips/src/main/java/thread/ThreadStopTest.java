package thread;

public class ThreadStopTest {
    public static void main(String[] args) throws Exception{
        Thread t1 = new Thread(() -> {
            for(int i=0; i<50000; i++)
                System.out.println("i = "+i);
        });
        t1.start();
        Thread.sleep(2000);
        t1.interrupt();

    }
}
