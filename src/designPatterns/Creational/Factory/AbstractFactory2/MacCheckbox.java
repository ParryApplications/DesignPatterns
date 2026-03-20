package designPatterns.Creational.Factory.AbstractFactory2;

public class MacCheckbox implements Checkbox {
    @Override
    public void click() {
        System.out.println("Mac Checkbox Clicked!");
    }
}
