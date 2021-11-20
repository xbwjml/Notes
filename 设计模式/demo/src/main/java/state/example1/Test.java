package state.example1;

public class Test {
    public static void main(String[] args) {
        Context context = new Context();
        context.setCurrState(new StateB());
        context.handle();
    }
}
