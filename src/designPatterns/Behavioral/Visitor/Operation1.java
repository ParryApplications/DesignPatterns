package designPatterns.Behavioral.Visitor;

//Price Calculator
public class Operation1 implements Visitor {
    @Override
    public void visit(Book book) {
        System.out.println("Book price will be 100 each");
    }

    @Override
    public void visit(Fruit book) {
        System.out.println("Fruit price will be 200 each");
    }
}
