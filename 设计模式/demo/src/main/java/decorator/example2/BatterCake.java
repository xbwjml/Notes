package decorator.example2;

public abstract class BatterCake {
    protected abstract String getMsg();
    protected abstract int getPrice();

    @Override
    public String toString() {
        return getMsg()+" 售价 "+getPrice();
    }
}
