package designPatterns.Structural.Decorator;

import java.util.Base64;

public class Base64Decorator implements Message {

    private Message msg;

    public Base64Decorator(Message msg) {
        this.msg = msg;
    }

    @Override
    public Object getContent() {
        return Base64.getEncoder().encodeToString(msg.getContent().toString().getBytes());
    }
}
