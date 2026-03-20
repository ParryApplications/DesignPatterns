package designPatterns.Creational.Prototype.registry;

public class SportsCar extends Vehicle {
  private int topSpeed;
  private boolean hasConvertibleRoof;

  public SportsCar(String brand, String model) {
    super(brand, model);
    this.topSpeed = 300; // km/h
    this.hasConvertibleRoof = false;
  }

  public int getTopSpeed() {
    return topSpeed;
  }

  public void setTopSpeed(int topSpeed) {
    this.topSpeed = topSpeed;
  }

  public boolean isHasConvertibleRoof() {
    return hasConvertibleRoof;
  }

  public void setHasConvertibleRoof(boolean hasConvertibleRoof) {
    this.hasConvertibleRoof = hasConvertibleRoof;
  }

  @Override
  public String toString() {
    return "SportsCar{" +
        "brand='" + brand + '\'' +
        ", model='" + model + '\'' +
        ", isElectric=" + isElectric +
        ", isManual=" + isManual +
        ", year=" + year +
        ", topSpeed=" + topSpeed + "km/h" +
        ", hasConvertibleRoof=" + hasConvertibleRoof +
        '}';
  }
}
