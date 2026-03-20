package designPatterns.Behavioral.Visitor;

public interface Visitor {
    void visit(Book book);
    void visit(Fruit book);
}
