package designPatterns.Behavioral.Memento;

/**
 * Command interface in Command Pattern
 * Encapsulates a request as an object
 */
public interface Command {
    /**
     * Execute the command
     */
    void execute();

    /**
     * Undo the command (reverse the operation)
     */
    void undo();
}
