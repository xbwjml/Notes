package bridge.example1;

//具体实现A
public class ConcreteImplementorA implements IImplementor {
    @Override
    public void operationImpl() {
        System.out.println("Implementor  A  !!!");
    }
}
