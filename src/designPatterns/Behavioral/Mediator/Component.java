package designPatterns.Behavioral.Mediator;

public abstract class Component {
    abstract void toggle(boolean isToggledByMediator);//This method can be called by either User or Mediator (when other object is notifying it's updated value)
}
