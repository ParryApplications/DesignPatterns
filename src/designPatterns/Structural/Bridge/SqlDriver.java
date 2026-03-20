package designPatterns.Structural.Bridge;

public class SqlDriver implements Driver {
    @Override
    public void connect() {
        System.out.println("Connecting SQL Driver...");
    }
}
