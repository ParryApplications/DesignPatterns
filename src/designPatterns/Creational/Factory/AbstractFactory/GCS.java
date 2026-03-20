package designPatterns.Creational.Factory.AbstractFactory;

public class GCS extends Storage {
    @Override
    String getStorageName() {
        return "Google Cloud Storage";
    }

    @Override
    void storageFilled(int capInMb) {
        System.out.printf("GCS Storage filled with %d MB%n", capInMb);
    }
}
