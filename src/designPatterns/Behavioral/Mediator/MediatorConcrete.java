package designPatterns.Behavioral.Mediator;

import java.util.ArrayList;
import java.util.List;

public class MediatorConcrete implements Mediator {

    List<Component> componentList;

    public MediatorConcrete() {
        this.componentList = new ArrayList<>();
    }

    @Override
    public void notifyObjects(Component component) {
        System.out.printf("%s class request mediator to notify others%n", component.getClass().getSimpleName());
        componentList.stream().filter(obj -> obj != component).forEach(obj -> obj.toggle(true));
    }

    @Override
    public void register(Component component) {
        this.componentList.add(component);
        System.out.printf("%s class registered with the Mediator%n", component.getClass().getSimpleName());
    }
}
