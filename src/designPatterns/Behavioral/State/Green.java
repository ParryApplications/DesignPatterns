package designPatterns.Behavioral.State;

/**
 * Green state - Flyweight pattern (singleton instance)
 * Represents the GREEN traffic light state
 */
public class Green implements TrafficLight {
    // Flyweight: Single instance shared across all contexts
    private static final Green INSTANCE = new Green();

    // Private constructor prevents external instantiation
    private Green() {
    }

    /**
     * Get the singleton instance of Green state
     * @return The single Green instance
     */
    public static Green getInstance() {
        return INSTANCE;
    }

    @Override
    public void message() {
        System.out.println("🟢 GREEN LIGHT: Vehicles should drive across!");
    }

    @Override
    public void handle(Context context) {
        message();
        // Transition back to Red state (completing the cycle)
        context.setState(Red.getInstance());
    }
}
