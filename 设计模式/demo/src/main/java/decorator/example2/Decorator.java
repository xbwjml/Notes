package decorator.example2;

public abstract class Decorator extends BatterCake{
    private BatterCake cake;

    public Decorator(BatterCake cake){
        this.cake = cake;
    }

    @Override
    public String getMsg(){
        return this.cake.getMsg();
    }

    @Override
    public int getPrice(){
        return this.cake.getPrice();
    }
}
