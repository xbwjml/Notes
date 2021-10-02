package templateMode;

public class FrenchMeal extends AbsClass{
    @Override
    protected void buy() {
        System.out.println("买cheese");
    }

    @Override
    protected void cook() {
        System.out.println("涂抹面包");
    }

    @Override
    protected void eat() {
        System.out.println("上手吃");
    }
}
