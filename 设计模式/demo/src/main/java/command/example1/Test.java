package command.example1;

public class Test {
    public static void main(String[] args) {
        ICommand cmd = new ConcreteCommamd();
        Invoker invoker = new Invoker(cmd);
        invoker.action();
    }
}
