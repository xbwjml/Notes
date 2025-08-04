package concurrent.threadDemo;

public class DaemonTest {
    public static void main(String[] args) {
        Thread t =  new Thread(new DeamonmRunner(), "测试 DeamonmRunner");
        t.setDaemon(true);
        t.start();
    }

    static class DeamonmRunner implements Runnable {
        @Override
        public void run() {
            try {
                System.out.println("开始了");
                SleepUtils.second(10);
                System.out.println("结束了");
            } finally {
                System.out.println(" finally 里的");
            }
        }
    }
}
