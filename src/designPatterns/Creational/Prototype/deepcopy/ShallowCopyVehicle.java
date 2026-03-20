package designPatterns.Creational.Prototype.deepcopy;

public class ShallowCopyVehicle implements Cloneable {
  // Primitive fields
  private boolean isElectric;
  private boolean isManual;

  // Object references
  private Engine engine;

  public ShallowCopyVehicle(String ownerName) {
    this.isElectric = false;
    this.isManual = false;
  }

  /**
   * SHALLOW COPY IMPLEMENTATION (PROBLEMATIC!)
   * This only copies references, not the actual objects
   */
  @Override
  public ShallowCopyVehicle clone() throws CloneNotSupportedException {
    // Only performs shallow copy - object references are copied, not the objects
    // themselves
    return (ShallowCopyVehicle) super.clone();
  }

  // Getters and Setters
  public boolean isElectric() {
    return isElectric;
  }

  public void setElectric(boolean electric) {
    isElectric = electric;
  }

  public boolean isManual() {
    return isManual;
  }

  public void setManual(boolean manual) {
    isManual = manual;
  }

  public Engine getEngine() {
    return engine;
  }

  public void setEngine(Engine engine) {
    this.engine = engine;
  }

  @Override
  public String toString() {
    return "ShallowCopyVehicle{" +
        "isElectric=" + isElectric +
        ", isManual=" + isManual +
        ", engine=" + engine +
        '}';
  }
}
