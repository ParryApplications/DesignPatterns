package designPatterns.Creational.Factory;

public class ProductAFactory extends Factory {
    @Override
    public Product createInstance() {
        return new ProductA();
    }
}
