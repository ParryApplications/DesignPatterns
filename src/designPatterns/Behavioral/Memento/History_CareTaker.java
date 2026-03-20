package designPatterns.Behavioral.Memento;

import java.util.Stack;

/**
 * Caretaker in Memento Pattern
 * Stores mementos without examining or modifying their contents
 */
public class History_CareTaker {
    private Stack<TextEditor_originator.TextEditor_Memento> stack = new Stack<>();

    /**
     * Save a memento to history
     */
    public void push(TextEditor_originator.TextEditor_Memento memento) {
        if (memento != null) {
            stack.push(memento);
        }
    }

    /**
     * Retrieve and remove the most recent memento
     */
    public TextEditor_originator.TextEditor_Memento pop() {
        if (stack.isEmpty()) {
            return null;
        }
        return stack.pop();
    }

    /**
     * View the most recent memento without removing it
     */
    public TextEditor_originator.TextEditor_Memento peek() {
        if (stack.isEmpty()) {
            return null;
        }
        return stack.peek();
    }

    /**
     * Check if history is empty
     */
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    /**
     * Get the number of saved states
     */
    public int size() {
        return stack.size();
    }
}
