package chapter4;

public class SynchDemo {
    public static void main(String[] args) {
        synchronized (SynchDemo.class) {

        }
        m();
    }

    public static synchronized void m(){}
}
