package concurrent.threadDemo;

public class SynchronizedTesrt {
    public static void main(String[] args) {
        synchronized (SynchronizedTesrt.class) {
            method1();
        }
    }

    public static synchronized void method1() {

    }
}
