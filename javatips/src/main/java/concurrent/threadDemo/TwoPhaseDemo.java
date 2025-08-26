package concurrent.threadDemo;

import org.springframework.ui.context.Theme;

public class TwoPhaseDemo {
    private Thread jianKongThread;
    
    public void start() {
        jianKongThread = new Thread(() -> {
            while (true) {
                Thread curr = Thread.currentThread();
                if (curr.isInterrupted()) {
                    System.out.println("料理后续");
                    break;
                }
                try {
                    Thread.sleep(1000);
                    System.out.println("正在监控");
                } catch (InterruptedException e) {
                    curr.interrupt();
                    e.printStackTrace();
                }
            }
        });
        jianKongThread.start();
    }

    public void stop() {
        jianKongThread.interrupt();
    }

    public static void main(String[] args) {
        TwoPhaseDemo twoPhaseDemo = new TwoPhaseDemo();
        twoPhaseDemo.start();

        SleepUtils.second(5);

        System.out.println("before stop");
        twoPhaseDemo.stop();

    }
}
