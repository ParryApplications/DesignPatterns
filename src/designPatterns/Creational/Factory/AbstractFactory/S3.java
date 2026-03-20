package designPatterns.Creational.Factory.AbstractFactory;

public class S3 extends Storage {
    @Override
    String getStorageName() {
        return "Simple Storage Service";
    }

    @Override
    void storageFilled(int capInMb) {
        System.out.printf("S3 Storage filled with %d MB%n", capInMb);
    }
}
