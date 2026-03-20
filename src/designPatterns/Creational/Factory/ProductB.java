package designPatterns.Creational.Factory;

public class ProductB implements Product{
    @Override
    public void getProductName() {
        System.out.println("Product B");
    }

    @Override
    public void getProductDetails() {
        System.out.println("""
                This is a dummy json:
                {
                    "id":"456",
                    "name": Product B
                }
                """);
    }
}
