package responsibility;

public abstract class AbsHandler {
    protected AbsHandler next;

    public void setnext(AbsHandler next){
        this.next = next;
    }

    public abstract void handleRequest(String request);
}
