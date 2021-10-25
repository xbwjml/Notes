package strategy.example1;

public class StrategyB implements IStrategy {
    @Override
    public void operate() {
        System.out.println("策略B运行");
    }
}
