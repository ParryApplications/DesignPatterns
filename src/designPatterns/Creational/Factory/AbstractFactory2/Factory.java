package designPatterns.Creational.Factory.AbstractFactory2;

//Abstract Factory, Responsible to create multiple related families
public interface Factory {
    Button getButton();
    Checkbox getCheckbox();
}
