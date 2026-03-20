package designPatterns.Structural.Composite;

//Leaf Class
public class LeafSingleTaskClass implements Task {

    private String name;

    public LeafSingleTaskClass(String name) {
        this.name = name;
    }

    @Override
    public String getTaskName() {
        return name;
    }

    @Override
    public void display() {
        System.out.printf("Leaf Task :: AKA %s%n", name);
    }
}
