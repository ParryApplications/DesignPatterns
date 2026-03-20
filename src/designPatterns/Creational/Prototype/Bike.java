package designPatterns.Creational.Prototype;

public class Bike extends Vehicle {
    @Override
    protected void drivePower() {
        System.out.println("1x1 Bike");
    }

    @Override
    public String toString() {
        return "Bike{" +
                "isElectric=" + isElectric +
                ", isManual=" + isManual +
                '}';
    }
}
