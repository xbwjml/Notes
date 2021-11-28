package bridge.example1;

//抽象
public abstract class Abstratcion {

    protected IImplementor implementor;

    public Abstratcion(IImplementor implementor) {
        this.implementor = implementor;
    }

    public void operation(){
        this.implementor.operationImpl();
    }
}
