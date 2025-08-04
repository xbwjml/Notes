package concurrent.threadDemo;


public class Test1 {

    public static void main(String[] args) throws InterruptedException{
        Thread t1 = new Thread(() -> {
            try {
                System.out.println("t1 开始");
                Thread.sleep(3000);
                System.out.println("t1 结束");
            } catch (InterruptedException e) {

            }
        });

        Thread t2 = new Thread(() -> {
            try {
                t1.join();
                System.out.println("t2 开始");
            } catch (InterruptedException e) {

            }
        });

        System.out.println("=========================");
        t1.start();
        t2.start();
    }
}
