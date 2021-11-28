package bridge.example1;

//修正抽象
public class RefinedAbstraction extends Abstratcion {
    public RefinedAbstraction(IImplementor implementor) {
        super(implementor);
    }

    @Override
    public void operation() {
        super.operation();
        System.out.println("refined operation");
    }
}
