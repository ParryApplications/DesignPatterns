package designPatterns.Creational.Factory.FactoryMethod;

public class ShipConcreteFactory extends Factory {
    @Override
    public Transport getInstance() {
        return new Ship();
    }
}
