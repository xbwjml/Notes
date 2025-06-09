package pattern.strategy.demo1;

public class PropActivity {

    private IStrategy strategy;

    public PropActivity() {
    }

    public PropActivity(IStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(IStrategy strategy) {
        this.strategy = strategy;
    }

    public void execute() {
        this.strategy.doPromotion();
    }
}
