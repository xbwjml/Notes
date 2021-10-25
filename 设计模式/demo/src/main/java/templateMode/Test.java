package templateMode;

public class Test {
    public static void main(String[] args) {
        AbsClass chineseMeal = new ChineseMeal();
        AbsClass frenchMeal = new FrenchMeal();

        chineseMeal.method();
        frenchMeal.method();

        return;
    }
}
