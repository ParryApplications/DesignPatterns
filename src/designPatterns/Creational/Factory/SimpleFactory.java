package designPatterns.Creational.Factory;

public class SimpleFactory {

    //Simple Factory Method
    public static Product createProduct(Character productChar) {
        switch (productChar) {
            case 'A' -> {
                return new ProductA();
            }
            case 'B' -> {
                return new ProductB();
            }
            default -> System.out.println("None instance created via createProduct()");
        }

        return null;
    }
}
