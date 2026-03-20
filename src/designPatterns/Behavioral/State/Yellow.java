package designPatterns.Behavioral.State;

/**
 * Yellow state - Flyweight pattern (singleton instance)
 * Represents the YELLOW traffic light state
 */
public class Yellow implements TrafficLight {
    // Flyweight: Single instance shared across all contexts
    private static final Yellow INSTANCE = new Yellow();

    // Private constructor prevents external instantiation
    private Yellow() {
    }

    /**
     * Get the singleton instance of Yellow state
     * @return The single Yellow instance
     */
    public static Yellow getInstance() {
        return INSTANCE;
    }

    @Override
    public void message() {
        System.out.println("🟡 YELLOW LIGHT: Vehicles should be ready to stop or carefully drive across!");
    }

    @Override
    public void handle(Context context) {
        message();
        // Transition to Green state
        context.setState(Green.getInstance());
    }
}
