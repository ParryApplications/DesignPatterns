package designPatterns.Behavioral.Observer;

//Listener Concrete, either fail or success, user should get an email notification
public class EmailNotification implements TaskManagementObserver {
    @Override
    public void update(OrderStatusSubject subject) {
        if(subject.getEventName() == EVENT_NAME.F) {
            System.out.println("Sent out Failed Email Notification to the User");
        } else {
            System.out.println("Sent out Success Email Notification to the User");
        }
    }
}
