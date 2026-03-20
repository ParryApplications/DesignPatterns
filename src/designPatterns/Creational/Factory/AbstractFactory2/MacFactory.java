package designPatterns.Creational.Factory.AbstractFactory2;

public class MacFactory implements Factory {
    @Override
    public Button getButton() {
        return new MacButton();
    }

    @Override
    public Checkbox getCheckbox() {
        return new MacCheckbox();
    }
}
