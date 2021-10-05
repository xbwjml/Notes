package command.example2;

public class PlayAction implements IAction {

    private GPlayer player;

    public PlayAction(GPlayer player){
        this.player = player;
    }

    @Override
    public void execute() {
        this.player.play();
    }
}
