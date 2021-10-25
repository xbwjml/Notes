package templateMode;

public abstract class AbsClass {

    protected abstract void buy();

    protected abstract void cook();

    protected abstract void eat();

    public final void method(){
        this.buy();
        this.cook();
        this.eat();
    }
}
