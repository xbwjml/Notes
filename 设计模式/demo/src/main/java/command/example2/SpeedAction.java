package command.example2;

public class SpeedAction implements IAction {
    private GPlayer player;

    public SpeedAction(GPlayer player){
        this.player = player;
    }

    @Override
    public void execute() {
        this.player.speed();
    }
}
