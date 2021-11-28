package bridge.example1;

//具体实现B
public class ConcreteImplementorB implements IImplementor {
    @Override
    public void operationImpl() {
        System.out.println("Implementor  B  !!!");
    }
}
