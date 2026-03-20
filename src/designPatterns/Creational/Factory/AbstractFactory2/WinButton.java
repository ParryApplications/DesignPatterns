package designPatterns.Creational.Factory.AbstractFactory2;

public class WinButton implements Button{
    @Override
    public void click() {
        System.out.println("Window Button Clicked!");
    }
}
