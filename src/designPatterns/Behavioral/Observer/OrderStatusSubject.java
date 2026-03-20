package designPatterns.Behavioral.Observer;

public interface OrderStatusSubject {
    void operationFailed();
    void operationSuccess();
    void attach(EVENT_NAME eventName, TaskManagementObserver observer);
    void detach(EVENT_NAME eventName, TaskManagementObserver observer);
    EVENT_NAME getEventName();
    int getFailCount();
    int getSuccessCount();
}
