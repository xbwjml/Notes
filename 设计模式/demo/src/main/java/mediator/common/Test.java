package mediator.common;

public class Test {
    public static void main(String[] args) {
        Mediator mediator = new ConcreteMediator();
        ColleagueA a = new ColleagueA(mediator);
        ColleagueB b = new ColleagueB(mediator);
        a.depMethodA();
        b.depMethodB();
    }
}
