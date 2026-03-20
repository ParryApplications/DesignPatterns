package designPatterns.Structural.Flyweight;

public class Client {
    public static void main(String[] args) {
        Factory factory = new Factory();
        System.out.println(factory.message(Factory.MessageType.SUCCESS).getMessage(200));
        System.out.println(factory.message(Factory.MessageType.ERROR).getMessage(400));
        System.out.println(factory.message(Factory.MessageType.EXCEPTION).getMessage(429));
    }
}
