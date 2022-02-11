package thread;

public class InterrTest {
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            for(int i=0; i<5000; i++);
        });

        t1.start();
        try{
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        t1.interrupt();
        //Thread.currentThread().interrupt();
        System.out.println(t1.isInterrupted());
        System.out.println(t1.isInterrupted());
    }
}
