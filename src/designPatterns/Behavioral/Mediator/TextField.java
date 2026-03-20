package designPatterns.Behavioral.Mediator;

public class TextField extends Component {
    private String field;
    private boolean isClosed;
    private Mediator mediator;

    public TextField(Mediator mediator) {
        this.isClosed = true;
        this.mediator = mediator;
        mediator.register(this);
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    //This method can be called by either User or Mediator (when other object is notifying it's updated value)
    @Override
    public void toggle(boolean isToggledByMediator) {
        System.out.println("TextField toggle to " + isClosed());
        field = "";
        this.isClosed = !this.isClosed;
        if (!isToggledByMediator)
            mediator.notifyObjects(this);
    }

    public boolean isClosed() {
        return this.isClosed;
    }
}
