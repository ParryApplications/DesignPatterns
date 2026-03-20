package designPatterns.Structural.Bridge;

public class OracleDriver implements Driver {
    @Override
    public void connect() {
        System.out.println("Connecting Oracle Driver...");
    }
}
