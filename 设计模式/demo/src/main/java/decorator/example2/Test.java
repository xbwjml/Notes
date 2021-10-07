package decorator.example2;

public class Test {
    public static void main(String[] args) {
        BatterCake cake = new BaseBatterCake();
        System.out.println(cake);
        cake = new DecoratorEgg(cake);
        System.out.println(cake);
        cake = new DecoratorEgg(cake);
        System.out.println(cake);
        cake = new DecoratorSausage(cake);
        System.out.println(cake);
        return;
    }
}
