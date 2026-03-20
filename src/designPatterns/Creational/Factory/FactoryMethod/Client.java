package designPatterns.Creational.Factory.FactoryMethod;

public class Client {
    public static void main(String[] args) {
//        Transport ship = new Ship();
//        ship.delivery();

        ShipConcreteFactory shipConcreteFactory = new ShipConcreteFactory();
        Transport instance = shipConcreteFactory.getInstance();
        instance.delivery();
    }
}
