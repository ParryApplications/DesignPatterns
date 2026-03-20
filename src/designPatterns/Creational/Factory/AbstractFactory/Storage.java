package designPatterns.Creational.Factory.AbstractFactory;

public abstract class Storage {

    public int capacityInMb;

    final int createStorage(int gb) {
        capacityInMb = 1024*gb;
        return capacityInMb;//returning MB
    }


    abstract String getStorageName();

    abstract void storageFilled(int capInMb);

}
