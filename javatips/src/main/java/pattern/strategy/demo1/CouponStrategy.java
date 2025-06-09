package pattern.strategy.demo1;

public class CouponStrategy implements IStrategy{
    @Override
    public void doPromotion() {
        System.out.println("优惠券抵扣");
    }
}
