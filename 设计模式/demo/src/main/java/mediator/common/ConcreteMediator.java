package mediator.common;

public class ConcreteMediator extends Mediator {
    @Override
    public void transferA() {
        this.b.selfMethodB();
    }

    @Override
    public void transferB() {
        this.a.selfMethodA();
    }
}
