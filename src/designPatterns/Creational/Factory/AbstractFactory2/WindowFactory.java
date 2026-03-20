package designPatterns.Creational.Factory.AbstractFactory2;

public class WindowFactory implements Factory {
    @Override
    public Button getButton() {
        return new WinButton();
    }

    @Override
    public Checkbox getCheckbox() {
        return new WinCheckbox();
    }
}
