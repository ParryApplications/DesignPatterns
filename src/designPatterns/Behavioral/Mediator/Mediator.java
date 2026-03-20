package designPatterns.Behavioral.Mediator;

public interface Mediator {
    void notifyObjects(Component component);

    void register(Component component);
}
