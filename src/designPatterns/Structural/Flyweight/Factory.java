package designPatterns.Structural.Flyweight;

import java.util.HashMap;
import java.util.Map;

//Flyweight Factory
public class Factory {

    public enum MessageType {SUCCESS, ERROR, EXCEPTION}

    private final Map<MessageType, Message> cache;//To reuse the instance contains same intrinsic states

    public Factory() {
        cache = new HashMap<>(3);
        cache.put(MessageType.SUCCESS, new ApplicationMessage("SUCCESS: Application successfully completed the operation"));
        cache.put(MessageType.ERROR, new ApplicationMessage("ERROR: Application throws an error"));
        cache.put(MessageType.EXCEPTION, new ApplicationMessage("EXCEPTION: Application throws an exception"));
    }

    public Message message(MessageType type) {
        return cache.get(type);
    }
}
