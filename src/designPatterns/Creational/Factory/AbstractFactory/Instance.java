package designPatterns.Creational.Factory.AbstractFactory;

public interface Instance {
    void instanceRunning();

    void attachedStorage(int capInMb);
    void instanceStopping();
}
