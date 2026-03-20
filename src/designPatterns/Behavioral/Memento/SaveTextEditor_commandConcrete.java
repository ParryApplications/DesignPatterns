package designPatterns.Behavioral.Memento;

/**
 * Concrete Command for saving text editor state
 * Delegates to Receiver for business logic
 */
public class SaveTextEditor_commandConcrete implements Command {

    private TextEditorReceiver receiver;

    public SaveTextEditor_commandConcrete(TextEditorReceiver receiver) {
        this.receiver = receiver;
    }

    /**
     * Execute save operation by delegating to receiver
     */
    @Override
    public void execute() {
        receiver.saveState();
    }

    /**
     * Undo save operation (typically a no-op for save commands)
     * In this implementation, we don't undo a save operation
     */
    @Override
    public void undo() {
        // Save operations are typically not undone
        // The undo of changes is handled by UndoCommand
        System.out.println("Save command undo - no operation");
    }
}
