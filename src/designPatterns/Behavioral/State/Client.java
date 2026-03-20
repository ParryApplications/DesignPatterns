package designPatterns.Behavioral.State;

/**
 * Client class - demonstrates the State pattern with Flyweight
 * Shows both manual and automatic state transitions
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("=== State Pattern with Flyweight Demo ===\n");

        // Example 1: Manual state transitions
        System.out.println("--- Example 1: Manual State Transitions ---");
        Context trafficLight = new Context();
        
        // Manually trigger state changes
        trafficLight.request(); // Red -> Yellow
        trafficLight.request(); // Yellow -> Green
        trafficLight.request(); // Green -> Red
        trafficLight.request(); // Red -> Yellow

        System.out.println("\n--- Example 2: Automatic State Transitions ---");
        
        // Example 2: Automatic state transitions
        Context autoTrafficLight = new Context(Red.getInstance());
        autoTrafficLight.startAutoTransition(2); // Change state every 2 seconds

        // Let it run for a while, then stop
        try {
            Thread.sleep(10000); // Run for 10 seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        autoTrafficLight.stop();

        System.out.println("\n--- Example 3: Verifying Flyweight Pattern ---");
        
        // Verify that states are reused (Flyweight pattern)
        Red red1 = Red.getInstance();
        Red red2 = Red.getInstance();
        Yellow yellow1 = Yellow.getInstance();
        Yellow yellow2 = Yellow.getInstance();
        Green green1 = Green.getInstance();
        Green green2 = Green.getInstance();

        System.out.println("Red instances are same: " + (red1 == red2));
        System.out.println("Yellow instances are same: " + (yellow1 == yellow2));
        System.out.println("Green instances are same: " + (green1 == green2));
        System.out.println("\n✅ Flyweight pattern verified - All state instances are reused!");
    }
}
