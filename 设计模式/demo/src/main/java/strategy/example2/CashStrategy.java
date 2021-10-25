package strategy.example2;

public class CashStrategy implements ISellStrategy {
    @Override
    public void sell() {
        System.out.println("使用现金");
    }
}
