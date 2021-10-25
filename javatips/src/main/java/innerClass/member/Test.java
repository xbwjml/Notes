package innerClass.member;

public class Test {
    public Test() {
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
//        Outer.Inner inner1 = new Outer.Inner();

        outer.eat();
        outer.run();
        inner.say();
        return;
    }
}
