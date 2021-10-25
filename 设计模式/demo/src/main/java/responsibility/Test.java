package responsibility;

public class Test {
    public static void main(String[] args) {
        AbsHandler handlerA = new HandlerA();
        AbsHandler handlerB = new HandlerB();
        handlerA.setnext(handlerB);
        handlerA.handleRequest("requestB");
    }
}
