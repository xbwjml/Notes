package state.example1;

public class StateA implements IState {
    @Override
    public void handle() {
        System.out.println("stateA do");
    }
}
