package designPatterns.Creational.Prototype.registry;

/**
 * Base Vehicle class for Prototype Registry pattern
 */
public abstract class Vehicle implements Cloneable {
  protected String brand;
  protected String model;
  protected boolean isElectric;
  protected boolean isManual;
  protected int year;

  public Vehicle(String brand, String model) {
    this.brand = brand;
    this.model = model;
    this.isElectric = false;
    this.isManual = false;
    this.year = 2024;
  }

  @Override
  public Vehicle clone() throws CloneNotSupportedException {
    return (Vehicle) super.clone();
  }

  // Getters and Setters
  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

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

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  @Override
  public String toString() {
    return getClass().getSimpleName() + "{" +
        "brand='" + brand + '\'' +
        ", model='" + model + '\'' +
        ", isElectric=" + isElectric +
        ", isManual=" + isManual +
        ", year=" + year +
        '}';
  }
}
