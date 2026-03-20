package designPatterns.Behavioral.Memento;

/**
 * Concrete Command for redoing text editor changes
 * Delegates to Receiver for business logic
 */
public class RedoTextEditor_commandConcrete implements Command {
    private TextEditorReceiver receiver;

    public RedoTextEditor_commandConcrete(TextEditorReceiver receiver) {
        this.receiver = receiver;
    }

    /**
     * Execute redo operation by delegating to receiver
     */
    @Override
    public void execute() {
        receiver.redo();
    }

    /**
     * Undo the redo operation (which is essentially an undo)
     */
    @Override
    public void undo() {
        receiver.undo();
    }
}
