package designPatterns.Behavioral.State;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Context class - maintains a reference to the current state
 * and delegates state-specific behavior to the current state object
 */
public class Context {
    private TrafficLight currentState;
    private ScheduledExecutorService scheduler;

    /**
     * Constructor initializes with Red state as default
     */
    public Context() {
        this.currentState = Red.getInstance();
    }

    /**
     * Constructor with custom initial state
     * @param initialState The initial state to start with
     */
    public Context(TrafficLight initialState) {
        this.currentState = initialState;
    }

    /**
     * Set the current state (called by state objects during transitions)
     * @param state The new state to transition to
     */
    public void setState(TrafficLight state) {
        this.currentState = state;
    }

    /**
     * Get the current state
     * @return The current traffic light state
     */
    public TrafficLight getCurrentState() {
        return currentState;
    }

    /**
     * Request the current state to handle its behavior
     * This triggers the state's action and potential state transition
     */
    public void request() {
        currentState.handle(this);
    }

    /**
     * Start automatic state transitions at fixed intervals
     * @param intervalSeconds Time between state changes in seconds
     */
    public void startAutoTransition(int intervalSeconds) {
        if (scheduler != null && !scheduler.isShutdown()) {
            System.out.println("Auto-transition already running!");
            return;
        }

        scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(this::request, 0, intervalSeconds, TimeUnit.SECONDS);

        System.out.println("🚦 Traffic light auto-transition started (every " + intervalSeconds + " seconds)");
    }

    /**
     * Stop the automatic state transitions and clean up resources
     */
    public void stop() {
        if (scheduler != null && !scheduler.isShutdown()) {
            scheduler.shutdown();
            try {
                if (!scheduler.awaitTermination(1, TimeUnit.SECONDS)) {
                    scheduler.shutdownNow();
                }
                System.out.println("🛑 Traffic light stopped");
            } catch (InterruptedException e) {
                scheduler.shutdownNow();
                Thread.currentThread().interrupt();
            }
        }
    }
}
