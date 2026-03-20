package designPatterns.Creational.Factory;

public class ProductA implements Product{
    @Override
    public void getProductName() {
        System.out.println("Product A");
    }

    @Override
    public void getProductDetails() {
        System.out.println("""
                This is a dummy json:
                {
                    "id":"123",
                    "name": Product A
                }
                """);
    }


}
