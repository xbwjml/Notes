package command.example1;

public class ConcreteCommamd implements ICommand {

    private Receiver receiver = new Receiver();

    @Override
    public void execute() {
        this.receiver.action();
    }
}
