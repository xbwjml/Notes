package pattern.strategy.demo1;

public class MainTest {
    public static void main(String[] args) {
        PropActivity activity = new PropActivity();

        activity.setStrategy(new CouponStrategy());
        activity.execute();

        activity.setStrategy(new CashStrategy());
        activity.execute();

    }
}
