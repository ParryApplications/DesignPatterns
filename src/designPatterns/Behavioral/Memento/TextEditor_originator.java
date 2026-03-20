package designPatterns.Behavioral.Memento;

/**
 * Originator in Memento Pattern
 * Manages the text editor's state and creates/restores mementos
 */
public class TextEditor_originator {
    private String content;

    public TextEditor_originator(String content) {
        this.content = content;
    }

    /**
     * Set new content (state modification)
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Get current content
     */
    public String getContent() {
        return this.content;
    }

    /**
     * Create a memento containing current state
     */
    public TextEditor_Memento save() {
        return new TextEditor_Memento(content);
    }

    /**
     * Restore state from a memento
     */
    public void restore(TextEditor_Memento memento) {
        if (memento != null) {
            this.content = memento.getContent();
        }
    }

    /**
     * Memento - Holds originator state
     * Only the Originator can access its internals
     */
    public class TextEditor_Memento {
        private final String content;

        private TextEditor_Memento(String content) {
            this.content = content;
        }

        private String getContent() {
            return content;
        }
    }
}
