package decorator.example2;

public class DecoratorEgg extends Decorator {

    public DecoratorEgg(BatterCake cake) {
        super(cake);
    }

    @Override
    public String getMsg(){
        return super.getMsg()+" +1个鸡蛋";
    }

    @Override
    public int getPrice(){
        return super.getPrice()+1;
    }
}
