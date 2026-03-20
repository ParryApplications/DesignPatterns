package designPatterns.Creational.Prototype;

public class Car extends Vehicle {
    @Override
    protected void drivePower() {
        System.out.println("4x4 Car");
    }

    @Override
    public String toString() {
        return "Car{" +
                "isElectric=" + isElectric +
                ", isManual=" + isManual +
                '}';
    }
}
