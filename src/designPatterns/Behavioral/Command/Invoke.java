package designPatterns.Behavioral.Command;

//This calls Command, can contains Stack or Queue based on the undo redo requirements.
public class Invoke {
    private final Command command;

    public Invoke(Command command) {
        this.command = command;
    }

    public void invoke() {
        command.execute();
    }
}
