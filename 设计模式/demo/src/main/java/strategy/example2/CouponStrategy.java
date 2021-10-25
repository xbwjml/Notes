package strategy.example2;

public class CouponStrategy implements ISellStrategy {
    @Override
    public void sell() {
        System.out.println("使用优惠券抵扣");
    }
}
