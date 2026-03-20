package designPatterns.Behavioral.Observer;

public class User {
    public static void main(String[] args) {
        //User is performing some operation on amazon:

        //Subject
        OrderStatusSubject subject = new OrderStatusConcrete();

        //Observers
        TaskManagementObserver emailObserver = new EmailNotification();
        TaskManagementObserver retryObserver = new RetryAttempts();

        subject.attach(EVENT_NAME.F, retryObserver);
        subject.attach(EVENT_NAME.F, emailObserver);

        subject.attach(EVENT_NAME.S, emailObserver);

        subject.operationFailed();
        subject.operationFailed();
        subject.detach(EVENT_NAME.F, retryObserver);
        subject.operationFailed();
        subject.operationSuccess();
    }
}
