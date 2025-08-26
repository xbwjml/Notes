package concurrent.threadDemo;



public class InterruptTest2 {
    public static void main(String[] args) {
        //Thread t1 = new Thread(() -> {
        //    System.out.println("睡觉");
        //    SleepUtils.second(50);
        //}, "t11");

        Thread t1 = new Thread(() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted())
                    break;
            }
        }, "t11");

        t1.start();
        SleepUtils.second(1);

        System.out.println("before interrupt");
        t1.interrupt();
        System.out.println("标记 : " + t1.isInterrupted());
    }
}
