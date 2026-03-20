package designPatterns.Behavioral.Memento;

/**
 * Invoker in Command Pattern
 * Executes commands without knowing their implementation details
 */
public class Invoker {
    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    /**
     * Set a new command to execute
     */
    public void setCommand(Command command) {
        this.command = command;
    }

    /**
     * Execute the current command
     */
    public void executeCommand() {
        if (command != null) {
            command.execute();
        }
    }

    /**
     * Undo the current command
     */
    public void undoCommand() {
        if (command != null) {
            command.undo();
        }
    }
}
