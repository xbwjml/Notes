package chapter4;

public class DaemonDemo {
    public static void main(String[] args) {
        Thread thread = new Thread(new DaemonRunner(), "DaemonRunner");
        thread.setDaemon(true);
        thread.start();
    }

    static class DaemonRunner implements Runnable{
        @Override
        public void run() {
            try {
                SleepUtils.sleepSecond(10);
            }finally {
                System.out.println("DaemonRunner finally ");
            }
        }
    }
}
