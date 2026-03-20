package designPatterns.Creational.Factory.AbstractFactory;

public interface AbstractFactory {//Resource
    Instance getInstance();

    Storage getStorage();
}
