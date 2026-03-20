package designPatterns.Creational.Factory;

public class Main {
    public static void main(String[] args) {
        Product productA = SimpleFactory.createProduct('A');
        assert productA != null;
        productA.getProductName();

        Product productB = SimpleFactory.createProduct('B');
        assert productB != null;
        productB.getProductName();


        ProductAFactory productAFactory = new ProductAFactory();
        productAFactory.callGetProductName();
        Product productAInstance = productAFactory.createInstance();
        productAInstance.getProductDetails();


    }
}
