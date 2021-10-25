package command.example2;

public class StopAction implements IAction {
    private GPlayer player;

    public StopAction(GPlayer player){
        this.player = player;
    }

    @Override
    public void execute() {
        this.player.stop();
    }
}
