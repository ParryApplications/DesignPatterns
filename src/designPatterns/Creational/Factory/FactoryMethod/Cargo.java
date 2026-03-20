package designPatterns.Creational.Factory.FactoryMethod;

public class Cargo implements Transport {
    @Override
    public void delivery() {
        System.out.println("Cargo is in progress...");
    }
}
