package strategy.example2;

/**
 * 上下文角色
 */
public class SellActivity {
    private ISellStrategy strategy;

    public SellActivity(ISellStrategy strategy){
        this.strategy = strategy;
    }

    public void execute(){
        this.strategy.sell();
    }
}
