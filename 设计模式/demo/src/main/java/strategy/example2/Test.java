package strategy.example2;

public class Test {
    public static void main(String[] args) {
        SellActivity ac1 = new SellActivity(new CouponStrategy());
        SellActivity ac2 = new SellActivity(new CashStrategy());
        SellActivity ac3 = new SellActivity(new GroupStrategy());

        ac1.execute();
        ac2.execute();
        ac3.execute();
    }
}
