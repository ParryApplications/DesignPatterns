package designPatterns.Behavioral.Memento;

/**
 * Client demonstrating Memento + Command Pattern
 * Shows proper usage of both patterns working together
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("=== Text Editor with Memento + Command Pattern ===\n");

        // Step 1: Create Originator (TextEditor)
        TextEditor_originator originator = new TextEditor_originator("Hello World");
        System.out.println("Initial text: " + originator.getContent());

        // Step 2: Create Caretaker (History)
        History_CareTaker careTaker = new History_CareTaker();

        // Step 3: Create Receiver (coordinates Originator and Caretaker)
        TextEditorReceiver receiver = new TextEditorReceiver(originator, careTaker);

        // Step 4: Create Commands
        SaveTextEditor_commandConcrete saveCommand = new SaveTextEditor_commandConcrete(receiver);
        UndoTextEditor_commandConcrete undoCommand = new UndoTextEditor_commandConcrete(receiver);
        RedoTextEditor_commandConcrete redoCommand = new RedoTextEditor_commandConcrete(receiver);

        // Step 5: Create Invoker
        Invoker invoker = new Invoker(saveCommand);

        System.out.println("\n--- Saving initial state ---");
        invoker.executeCommand(); // Save state #1

        // Modify text
        System.out.println("\n--- Modifying text (Edit 1) ---");
        originator.setContent("Hello World - Edit 1");
        System.out.println("Current text: " + originator.getContent());
        invoker.executeCommand(); // Save state #2

        // Modify text again
        System.out.println("\n--- Modifying text (Edit 2) ---");
        originator.setContent("Hello World - Edit 1 - Edit 2");
        System.out.println("Current text: " + originator.getContent());
        invoker.executeCommand(); // Save state #3

        // Modify text one more time
        System.out.println("\n--- Modifying text (Edit 3) ---");
        originator.setContent("Hello World - Edit 1 - Edit 2 - Edit 3");
        System.out.println("Current text: " + originator.getContent());

        // Perform Undo operations
        System.out.println("\n--- Performing Undo #1 ---");
        invoker.setCommand(undoCommand);
        invoker.executeCommand();

        System.out.println("\n--- Performing Undo #2 ---");
        invoker.executeCommand();

        System.out.println("\n--- Performing Undo #3 ---");
        invoker.executeCommand();

        // Try to undo when nothing left
        System.out.println("\n--- Attempting Undo #4 (should fail) ---");
        invoker.executeCommand();

        // Perform Redo operations
        System.out.println("\n--- Performing Redo #1 ---");
        invoker.setCommand(redoCommand);
        invoker.executeCommand();

        System.out.println("\n--- Performing Redo #2 ---");
        invoker.executeCommand();

        // Try to redo when nothing left
        System.out.println("\n--- Attempting Redo #3 (should fail) ---");
        invoker.executeCommand();

        // Final state
        System.out.println("\n=== Final State ===");
        System.out.println("Current text: " + originator.getContent());
        System.out.println("Can undo: " + receiver.canUndo());
        System.out.println("Can redo: " + receiver.canRedo());
        System.out.println("Total saved states: " + careTaker.size());

        // Demonstrate that modifying after undo clears redo stack
        System.out.println("\n--- Modifying text after undo (clears redo stack) ---");
        originator.setContent("New text after undo");
        System.out.println("Current text: " + originator.getContent());
        invoker.setCommand(saveCommand);
        invoker.executeCommand();
        System.out.println("Can redo: " + receiver.canRedo() + " (redo stack cleared)");

        System.out.println("\n=== Pattern Demonstration Complete ===");
    }
}
