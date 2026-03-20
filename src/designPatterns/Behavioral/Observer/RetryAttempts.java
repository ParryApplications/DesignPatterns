package designPatterns.Behavioral.Observer;

public class RetryAttempts implements TaskManagementObserver {
    @Override
    public void update(OrderStatusSubject subject) {
        System.out.println("Retrying but Failed");
    }
}
