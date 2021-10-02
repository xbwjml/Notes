package proxy.dynamic.jdk自带;

public class Test {
    public static void main(String[] args) {
        PersonHandeler proxy = new PersonHandeler();
        IPerson person = proxy.getInstance(new ZhangSan());
        person.study();
        person.eat();
        return;
    }
}
