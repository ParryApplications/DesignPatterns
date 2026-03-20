package designPatterns.Behavioral.Command;

public class Client {
    public static void main(String[] args) {
        Receiver receiver = new Receiver();//Contains BIZ logic
        CommandConcrete commandConcrete = new CommandConcrete(receiver);//Map Biz logic with command execute

        //Invoke is not aware about the implementation done under the receiver
        Invoke invoke = new Invoke(commandConcrete);
        invoke.invoke();
    }
}
