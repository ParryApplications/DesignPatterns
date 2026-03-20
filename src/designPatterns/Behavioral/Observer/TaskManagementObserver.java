package designPatterns.Behavioral.Observer;

//Observer, Subscriber, Listener
public interface TaskManagementObserver {
    void update(OrderStatusSubject subject);
}
