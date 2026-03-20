package designPatterns.Behavioral.State;

/**
 * State interface - defines the contract for all concrete states
 */
public interface TrafficLight {
    /**
     * Display the message for this traffic light state
     */
    void message();

    /**
     * Handle the state transition by updating the context
     * @param context The context whose state will be changed
     */
    void handle(Context context);
}
