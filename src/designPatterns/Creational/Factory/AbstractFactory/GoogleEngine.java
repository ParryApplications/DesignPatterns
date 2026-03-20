package designPatterns.Creational.Factory.AbstractFactory;

public class GoogleEngine implements Instance {
    @Override
    public void instanceRunning() {
        System.out.println("GoogleEngine instance is running...");
    }

    @Override
    public void attachedStorage(int capInMb) {
        System.out.printf("GoogleEngine have now storage of %d MB%n", capInMb);
    }

    @Override
    public void instanceStopping() {
        System.out.println("GoogleEngine instance is stopping...");
    }
}
