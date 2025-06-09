package pattern.strategy.demo1;

public class CashStrategy implements IStrategy{
    @Override
    public void doPromotion() {
        System.out.println("返现");
    }
}
