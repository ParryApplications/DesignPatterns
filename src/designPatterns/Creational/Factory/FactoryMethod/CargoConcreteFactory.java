package designPatterns.Creational.Factory.FactoryMethod;

public class CargoConcreteFactory extends Factory {
    @Override
    public Transport getInstance() {
        return new Cargo();
    }
}
