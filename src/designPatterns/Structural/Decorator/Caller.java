package designPatterns.Structural.Decorator;

public class Caller {
    public static void main(String[] args) {
        Message<String> message = new PlainMessage("Paras will crack a MANG Company");
        System.out.println(message.getContent());

        Message<String> encodedMsg = new Base64Decorator(message);
        System.out.println(encodedMsg.getContent());
    }
}
