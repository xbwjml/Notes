package strategy.example2;

public class GroupStrategy implements ISellStrategy {
    @Override
    public void sell() {
        System.out.println("团购优惠");
    }
}
