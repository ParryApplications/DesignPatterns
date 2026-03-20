package designPatterns.Creational.Factory.AbstractFactory;

public class AWSResource implements AbstractFactory {
    @Override
    public Instance getInstance() {
        return new EC2();
    }

    @Override
    public Storage getStorage() {
        return new S3();
    }
}
