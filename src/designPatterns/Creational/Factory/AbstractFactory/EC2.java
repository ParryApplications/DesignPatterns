package designPatterns.Creational.Factory.AbstractFactory;

public class EC2 implements Instance {
    @Override
    public void instanceRunning() {
        System.out.println("EC2 instance is running...");
    }

    @Override
    public void attachedStorage(int capInMb) {
        System.out.printf("EC2 have now storage of %d MB%n", capInMb);
    }

    @Override
    public void instanceStopping() {
        System.out.println("EC2 instance is stopping...");
    }
}
