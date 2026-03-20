package designPatterns.Creational.Prototype.deepcopy;

import java.util.ArrayList;
import java.util.List;

public class VehicleWithDeepCopy implements Cloneable {
  // Primitive fields - always copied by value
  private boolean isElectric;
  private boolean isManual;

  // Object references - need deep copying
  private Engine engine;
  private List<String> features;
  private String ownerName; // String is immutable, so shallow copy is safe

  public VehicleWithDeepCopy(String ownerName) {
    this.ownerName = ownerName;
    this.isElectric = false;
    this.isManual = false;
    this.features = new ArrayList<>();
  }

  /**
   * DEEP COPY IMPLEMENTATION
   * This ensures that all object references are cloned, not just copied
   */
  @Override
  public VehicleWithDeepCopy clone() throws CloneNotSupportedException {
    // Step 1: Perform shallow copy (copies primitives and references)
    VehicleWithDeepCopy cloned = (VehicleWithDeepCopy) super.clone();

    // Step 2: Deep copy the Engine object
    if (this.engine != null) {
      cloned.engine = this.engine.clone(); // Create a new Engine object
    }

    // Step 3: Deep copy the List
    if (this.features != null) {
      cloned.features = new ArrayList<>(this.features); // Create a new List with same elements
    }

    // Step 4: String is immutable, so no need to clone
    // cloned.ownerName already points to the same String, which is safe

    return cloned;
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

  public List<String> getFeatures() {
    return features;
  }

  public void addFeature(String feature) {
    this.features.add(feature);
  }

  public String getOwnerName() {
    return ownerName;
  }

  public void setOwnerName(String ownerName) {
    this.ownerName = ownerName;
  }

  @Override
  public String toString() {
    return "VehicleWithDeepCopy{" +
        "isElectric=" + isElectric +
        ", isManual=" + isManual +
        ", engine=" + engine +
        ", features=" + features +
        ", ownerName='" + ownerName + '\'' +
        '}';
  }
}
