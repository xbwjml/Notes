package state.example1;

public class Context {

    private static final IState stateA = new StateA();
    private static final IState stateB = new StateB();

    private IState currState = stateA;

    public void setCurrState(IState state){
        this.currState = state;
    }

    public void handle(){
        this.currState.handle();
    }
}
