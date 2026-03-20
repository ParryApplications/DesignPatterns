package designPatterns.Creational.Factory.AbstractFactory;

public class GoogleResource implements AbstractFactory {
    @Override
    public Instance getInstance() {
        return new GoogleEngine();
    }

    @Override
    public Storage getStorage() {
        return new GCS();
    }
}
