package strategy.example1;

public class StrategyA implements IStrategy {
    @Override
    public void operate() {
        System.out.println("策略A运行");
    }
}
