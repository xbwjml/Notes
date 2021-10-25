package command.example2;

public class PauseAction implements IAction {
    private GPlayer player;

    public PauseAction(GPlayer player){
        this.player = player;
    }

    @Override
    public void execute() {
        this.player.pause();
    }
}
