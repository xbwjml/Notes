package chapter1;

public class DeadLockDemo {
    private static String a = "A";
    private static String b = "B";

    public static void main(String[] args) {
        new DeadLockDemo().deadLock();
    }

    private void deadLock(){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (a){
                    try {
                        Thread.currentThread().sleep(1000 * 2);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    synchronized (b){
                        System.out.println("1");
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (b){
                    synchronized (a){
                        System.out.println("2");
                    }
                }
            }
        });

        t1.start();
        t2.start();
    }
}
