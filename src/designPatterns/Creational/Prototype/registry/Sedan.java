package designPatterns.Creational.Prototype.registry;

public class Sedan extends Vehicle {
  private int trunkCapacity;

  public Sedan(String brand, String model) {
    super(brand, model);
    this.trunkCapacity = 500; // liters
  }

  public int getTrunkCapacity() {
    return trunkCapacity;
  }

  public void setTrunkCapacity(int trunkCapacity) {
    this.trunkCapacity = trunkCapacity;
  }

  @Override
  public String toString() {
    return "Sedan{" +
        "brand='" + brand + '\'' +
        ", model='" + model + '\'' +
        ", isElectric=" + isElectric +
        ", isManual=" + isManual +
        ", year=" + year +
        ", trunkCapacity=" + trunkCapacity + "L" +
        '}';
  }
}
