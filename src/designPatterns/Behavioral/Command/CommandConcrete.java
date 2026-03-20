package designPatterns.Behavioral.Command;

//Map command interface with Receiver implementation hiding details from invoker
public class CommandConcrete implements Command {
    private Receiver receiver;

    public CommandConcrete(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.lightOn();
    }
}
