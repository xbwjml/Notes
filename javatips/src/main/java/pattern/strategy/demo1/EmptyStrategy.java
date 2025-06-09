package pattern.strategy.demo1;

public class EmptyStrategy implements IStrategy{
    @Override
    public void doPromotion() {
        System.out.println("无优惠");
    }
}
