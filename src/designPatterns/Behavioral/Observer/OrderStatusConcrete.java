package designPatterns.Behavioral.Observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderStatusConcrete implements OrderStatusSubject {

    Map<EVENT_NAME, List<TaskManagementObserver>> observersCategoryList = new HashMap<>(2);

    private int successCount;
    private int failCount;
    private EVENT_NAME eventName;

    @Override
    public int getSuccessCount() {
        return successCount;
    }

    private void notifyAllObservers(EVENT_NAME eventName) {
        if(observersCategoryList != null)
            observersCategoryList.get(eventName).forEach(observer -> observer.update(this));
    }

    @Override
    public int getFailCount() {
        return failCount;
    }

    @Override
    public EVENT_NAME getEventName() {
        return eventName;
    }

    public void setEventName(EVENT_NAME eventName) {
        this.eventName = eventName;
    }

    @Override
    public void operationFailed() {
        setEventName(EVENT_NAME.F);
        failCount++;
        notifyAllObservers(getEventName());
    }

    @Override
    public void operationSuccess() {
        setEventName(EVENT_NAME.S);
        successCount++;
        notifyAllObservers(getEventName());
    }

    @Override
    public void attach(EVENT_NAME eventName, TaskManagementObserver observer) {
        if (eventName == EVENT_NAME.F)
            observersCategoryList.computeIfAbsent(EVENT_NAME.F, (f) -> new ArrayList<>()).add(observer);
        else
            observersCategoryList.computeIfAbsent(EVENT_NAME.S, (f) -> new ArrayList<>()).add(observer);
    }

    @Override
    public void detach(EVENT_NAME eventName, TaskManagementObserver observer) {
        if (eventName == EVENT_NAME.F && observersCategoryList.containsKey(EVENT_NAME.F))
            observersCategoryList.get(EVENT_NAME.F).remove(observer);
        else if (eventName == EVENT_NAME.S && observersCategoryList.containsKey(EVENT_NAME.S))
            observersCategoryList.get(EVENT_NAME.S).remove(observer);
    }
}
