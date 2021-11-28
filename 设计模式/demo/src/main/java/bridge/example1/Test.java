package bridge.example1;

public class Test {
    public static void main(String[] args) {
        //创建一个具体角色
        IImplementor imp = new ConcreteImplementorA();
        //创建一个抽象角色，聚合实现
        Abstratcion abs = new RefinedAbstraction(imp);
        abs.operation();
    }
}
