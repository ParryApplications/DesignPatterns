package designPatterns.Creational.Factory.FactoryMethod;

public class Ship implements Transport {
    @Override
    public void delivery() {
        System.out.println("Shipment is in progress...");
    }
}
