package concurrent.threadDemo;

public class Test5 {
    public static void main(String[] args) throws InterruptedException {
        ThreadGroup group = new ThreadGroup("测试线程组");

        Thread t1 = new Thread(group,()->{
            try {
                System.out.println("线程1开始");
                Thread.sleep(2000);
                System.out.println("线程1结束");
            } catch (InterruptedException e) {
                System.out.println("线程1被中断");
            }
        });

        Thread t2 = new Thread(group,()->{
            try {
                System.out.println("线程2开始");
                Thread.sleep(3000);
                System.out.println("线程2结束");
            } catch (InterruptedException e) {
                System.out.println("线程2被中断");
            }
        });

        t1.start();
        t2.start();

        Thread.sleep(1000);
        group.interrupt();

    }
}
