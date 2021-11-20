package state.example1;

public class StateB implements IState {
    @Override
    public void handle() {
        System.out.println("stateB do");
    }
}
