package designPatterns.Behavioral.Memento;

/**
 * Concrete Command for undoing text editor changes
 * Delegates to Receiver for business logic
 */
public class UndoTextEditor_commandConcrete implements Command {
    private TextEditorReceiver receiver;

    public UndoTextEditor_commandConcrete(TextEditorReceiver receiver) {
        this.receiver = receiver;
    }

    /**
     * Execute undo operation by delegating to receiver
     */
    @Override
    public void execute() {
        receiver.undo();
    }

    /**
     * Undo the undo operation (which is essentially a redo)
     */
    @Override
    public void undo() {
        receiver.redo();
    }
}
