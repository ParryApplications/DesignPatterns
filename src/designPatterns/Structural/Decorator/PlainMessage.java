package designPatterns.Structural.Decorator;

public class PlainMessage implements Message {

    private Object msg;

    public PlainMessage(Object msg) {
        this.msg = msg;
    }

    @Override
    public Object getContent() {
        return msg;
    }
}
