package decorator.example2;

public class DecoratorSausage extends Decorator {
    public DecoratorSausage(BatterCake cake) {
        super(cake);
    }

    @Override
    public String getMsg(){
        return super.getMsg()+" +1个香肠";
    }

    @Override
    public int getPrice(){
        return super.getPrice()+3;
    }
}
