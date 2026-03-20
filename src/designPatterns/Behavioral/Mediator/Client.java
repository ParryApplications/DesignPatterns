package designPatterns.Behavioral.Mediator;

public class Client {
    public static void main(String[] args) {
        Mediator mediator = new MediatorConcrete();
        Component checkbox = new Checkbox(mediator);
        Component textField = new TextField(mediator);

        checkbox.toggle(false);
        //How can i setField() from TextField?
        ((TextField) textField).setField("Paras will definitely crack some MANG companies!");
        System.out.println(((TextField) textField).getField());

        textField.toggle(false);
        System.out.println(((TextField) textField).getField());
    }
}
