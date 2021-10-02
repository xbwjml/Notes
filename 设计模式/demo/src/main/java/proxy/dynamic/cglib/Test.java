package proxy.dynamic.cglib;

public class Test {
    public static void main(String[] args) throws Exception {
        Consumer consumer = (Consumer) new CGlibPro().getInstance(Consumer.class);
        consumer.buy();
        return;
    }
}
