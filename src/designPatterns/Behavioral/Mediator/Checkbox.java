package designPatterns.Behavioral.Mediator;

public class Checkbox extends Component {
    private boolean isChecked;
    private Mediator mediator;

    public Checkbox(Mediator mediator) {
        this.isChecked = false;
        this.mediator = mediator;
        mediator.register(this);
    }

    //This method can be called by either User or Mediator (when other object is notifying it's updated value)
    @Override
    public void toggle(boolean isToggledByMediator) {
        System.out.println("Checkbox toggle to " + isChecked());
        this.isChecked = !this.isChecked;
        if (!isToggledByMediator)
            mediator.notifyObjects(this);
    }

    public boolean isChecked() {
        return this.isChecked;
    }
}
