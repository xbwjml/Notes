package proxy.staticProxy;

public class Proxy implements ISubject{

    private ISubject subject;

    public Proxy(ISubject subject){
        this.subject = subject;
    }

    @Override
    public void request() {
        before();
        subject.request();
        after();
    }

    public void before(){
        System.out.println("proxy before");
    }

    public void after(){
        System.out.println("proxy after");
    }
}
