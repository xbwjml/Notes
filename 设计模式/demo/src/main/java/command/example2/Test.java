package command.example2;

import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        GPlayer player = new GPlayer();
        List<IAction> actions = Arrays.asList(
                new PlayAction(player),
                new PauseAction(player),
                new SpeedAction(player),
                new StopAction(player)
        );

        actions.forEach(e->{
            e.execute();
        });
    }
}
