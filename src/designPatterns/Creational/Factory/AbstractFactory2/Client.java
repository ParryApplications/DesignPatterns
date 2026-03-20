package designPatterns.Creational.Factory.AbstractFactory2;

public class Client {
    public static void main(String[] args) {
        WindowFactory windowFactory = new WindowFactory();
        windowFactory.getButton().click();
        windowFactory.getCheckbox().click();
    }
}
