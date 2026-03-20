package designPatterns.Behavioral.Memento;

import java.util.Stack;

/**
 * Receiver in Command Pattern
 * Contains business logic for text editor operations
 * Coordinates between Originator and Caretaker
 */
public class TextEditorReceiver {
    private TextEditor_originator originator;
    private History_CareTaker careTaker;
    private Stack<TextEditor_originator.TextEditor_Memento> redoStack;

    public TextEditorReceiver(TextEditor_originator originator, History_CareTaker careTaker) {
        this.originator = originator;
        this.careTaker = careTaker;
        this.redoStack = new Stack<>();
    }

    /**
     * Save current state to history
     */
    public void saveState() {
        TextEditor_originator.TextEditor_Memento memento = originator.save();
        careTaker.push(memento);
        // Clear redo stack when new state is saved
        redoStack.clear();
        System.out.println("State saved. Total saved states: " + careTaker.size());
    }

    /**
     * Undo to previous state
     */
    public void undo() {
        if (careTaker.isEmpty()) {
            System.out.println("Nothing to undo!");
            return;
        }

        // Save current state to redo stack before undoing
        TextEditor_originator.TextEditor_Memento currentState = originator.save();
        redoStack.push(currentState);

        // Restore previous state
        TextEditor_originator.TextEditor_Memento previousState = careTaker.pop();
        originator.restore(previousState);
        System.out.println("Undo performed. Current text: " + originator.getContent());
    }

    /**
     * Redo to next state
     */
    public void redo() {
        if (redoStack.isEmpty()) {
            System.out.println("Nothing to redo!");
            return;
        }

        // Save current state back to history
        TextEditor_originator.TextEditor_Memento currentState = originator.save();
        careTaker.push(currentState);

        // Restore next state from redo stack
        TextEditor_originator.TextEditor_Memento nextState = redoStack.pop();
        originator.restore(nextState);
        System.out.println("Redo performed. Current text: " + originator.getContent());
    }

    /**
     * Write/modify text in the editor
     */
    public void writeText(String text) {
        originator.setContent(text);
        System.out.println("Text updated: " + text);
    }

    /**
     * Get current text from editor
     */
    public String getCurrentText() {
        return originator.getContent();
    }

    /**
     * Check if undo is available
     */
    public boolean canUndo() {
        return !careTaker.isEmpty();
    }

    /**
     * Check if redo is available
     */
    public boolean canRedo() {
        return !redoStack.isEmpty();
    }
}
