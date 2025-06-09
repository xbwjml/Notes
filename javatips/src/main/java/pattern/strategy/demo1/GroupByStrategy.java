package pattern.strategy.demo1;

public class GroupByStrategy implements IStrategy{
    @Override
    public void doPromotion() {
        System.out.println("团购优惠");
    }
}
