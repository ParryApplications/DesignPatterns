package designPatterns.Creational.Factory.AbstractFactory2;

public class MacButton implements Button {
    @Override
    public void click() {
        System.out.println("Mac Button Clicked!");
    }
}
