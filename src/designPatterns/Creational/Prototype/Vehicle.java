package designPatterns.Creational.Prototype;

public abstract class Vehicle implements Cloneable {
    public boolean isElectric;
    public boolean isManual;

    @Override
    public Vehicle clone() throws CloneNotSupportedException {
        Vehicle vehicle = (Vehicle) super.clone();
        vehicle.initialize();
        return vehicle;
    }

    protected void initialize() {
        this.isManual = false;
        this.isElectric = false;
    }

    public Vehicle() {
        isElectric = false;
        isManual = false;
    }

    protected void accelerate() {
        System.out.println("Vehicle is moving...");
    }

    protected void brake() {
        System.out.println("Vehicle is stopping...");
    }

    protected abstract void drivePower();
}
