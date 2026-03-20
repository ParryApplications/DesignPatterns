package designPatterns.Behavioral.Visitor;

public class Book implements Objects {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
