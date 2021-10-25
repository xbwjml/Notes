package proxy.staticProxy;

public class Client {
    public static void main(String[] args) {
        ISubject subject = new Proxy(new RealSubject());
        subject.request();
    }

}
