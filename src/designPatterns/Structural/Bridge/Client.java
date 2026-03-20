package designPatterns.Structural.Bridge;

public class Client {
    public static void main(String[] args) {
        DriverManager driverManager = new DriverManagerImpl(new SqlDriver());
        driverManager.joinNetwork();
    }
}
