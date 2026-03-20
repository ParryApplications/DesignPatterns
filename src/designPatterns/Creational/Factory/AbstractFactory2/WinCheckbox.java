package designPatterns.Creational.Factory.AbstractFactory2;

public class WinCheckbox implements Checkbox {
    @Override
    public void click() {
        System.out.println("Windows Checkbox Clicked!");
    }
}
