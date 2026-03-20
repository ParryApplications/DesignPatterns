package designPatterns.Behavioral.Visitor;

public class Fruit implements Objects{

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
