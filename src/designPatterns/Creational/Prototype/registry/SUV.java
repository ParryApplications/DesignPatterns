package designPatterns.Creational.Prototype.registry;

public class SUV extends Vehicle {
  private boolean hasFourWheelDrive;
  private int seatingCapacity;

  public SUV(String brand, String model) {
    super(brand, model);
    this.hasFourWheelDrive = true;
    this.seatingCapacity = 7;
  }

  public boolean isHasFourWheelDrive() {
    return hasFourWheelDrive;
  }

  public void setHasFourWheelDrive(boolean hasFourWheelDrive) {
    this.hasFourWheelDrive = hasFourWheelDrive;
  }

  public int getSeatingCapacity() {
    return seatingCapacity;
  }

  public void setSeatingCapacity(int seatingCapacity) {
    this.seatingCapacity = seatingCapacity;
  }

  @Override
  public String toString() {
    return "SUV{" +
        "brand='" + brand + '\'' +
        ", model='" + model + '\'' +
        ", isElectric=" + isElectric +
        ", isManual=" + isManual +
        ", year=" + year +
        ", hasFourWheelDrive=" + hasFourWheelDrive +
        ", seatingCapacity=" + seatingCapacity +
        '}';
  }
}
