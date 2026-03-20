package designPatterns.Creational.Factory;

public abstract class Factory {

    //Factory Method
    public abstract Product createInstance();

    //Optional
    public void callGetProductName() {
        createInstance().getProductName();
    }
}
