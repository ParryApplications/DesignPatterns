package designPatterns.Structural.Bridge;

public class DriverManagerImpl implements DriverManager {
    //Composition
    private Driver driver;

    public DriverManagerImpl(Driver driver) {
        this.driver = driver;
    }

    @Override
    public void joinNetwork() {
        driver.connect();
    }
}
