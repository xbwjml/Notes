package decorator.example1;

public class Test {
    public static void main(String[] args) {
        Component c1 = new ConcreteComponent();
        Decorator dA = new ConcreteDecorateA(c1);
        dA.operate();

        Decorator dB = new ConcreteDecorateB(c1);
        dB.operate();

        Decorator dBAndA = new ConcreteDecorateB(dA);
        dBAndA.operate();
    }
}
