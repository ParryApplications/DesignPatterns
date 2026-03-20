package designPatterns.Structural.Flyweight;

//Flyweight Concrete, Categorize Intrinsic and Extrinsic state of objects
public class ApplicationMessage implements Message {

    //Intrinsic State of Object, checkout how Factory class is handling this (Immutable)
    private String messageTemplate;

    public ApplicationMessage(String messageTemplate) {//Success, Error, Exception
        this.messageTemplate = messageTemplate;
    }

    @Override
    public String getMessage(int httpCode) {//Here errCode is extrinsic state of object
        return String.format("Message: %s :: HttpCode: %d", messageTemplate, httpCode);
    }
}
