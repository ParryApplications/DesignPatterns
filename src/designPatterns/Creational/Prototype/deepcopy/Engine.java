package designPatterns.Creational.Prototype.deepcopy;

public class Engine implements Cloneable {
  private String type;
  private int horsepower;

  public Engine(String type, int horsepower) {
    this.type = type;
    this.horsepower = horsepower;
  }

  // Deep copy implementation for Engine
  @Override
  public Engine clone() throws CloneNotSupportedException {
    // For simple objects with only primitives and Strings, super.clone() is
    // sufficient
    // String is immutable, so it's safe to share
    return (Engine) super.clone();
  }

  // Getters and Setters
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public int getHorsepower() {
    return horsepower;
  }

  public void setHorsepower(int horsepower) {
    this.horsepower = horsepower;
  }

  @Override
  public String toString() {
    return "Engine{type='" + type + "', horsepower=" + horsepower + "}";
  }
}
