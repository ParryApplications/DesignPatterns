package designPatterns.Behavioral.State;

/**
 * Red state - Flyweight pattern (singleton instance)
 * Represents the RED traffic light state
 */
public class Red implements TrafficLight {
    // Flyweight: Single instance shared across all contexts
    private static final Red INSTANCE = new Red();

    // Private constructor prevents external instantiation
    private Red() {
    }

    /**
     * Get the singleton instance of Red state
     * @return The single Red instance
     */
    public static Red getInstance() {
        return INSTANCE;
    }

    @Override
    public void message() {
        System.out.println("🔴 RED LIGHT: Vehicles STOP Now!");
    }

    @Override
    public void handle(Context context) {
        message();
        // Transition to Yellow state
        context.setState(Yellow.getInstance());
    }
}
