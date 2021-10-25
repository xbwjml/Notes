package proxy.staticProxy;

public class RealSubject implements ISubject{
    @Override
    public void request() {
        System.out.println("real method called");
    }
}
