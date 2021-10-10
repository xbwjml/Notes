package strategy.example1;

public class Test {
    public static void main(String[] args) {
        IStrategy strategy = new StrategyA();
        Context context = new Context(strategy);
        context.operate();
    }
}
