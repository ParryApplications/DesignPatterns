package designPatterns.Creational.Prototype;

public class TestClone {
  public static void main(String[] args) throws CloneNotSupportedException {
    System.out.println("=== TEST 1: WITH initialize() (current implementation) ===");
    Car mercedes1 = new Car();
    mercedes1.isManual = true;
    mercedes1.isElectric = false;
    System.out.println("Before clone - mercedes1: " + mercedes1);

    Car bmw1 = (Car) mercedes1.clone();
    System.out.println("After clone - bmw1: " + bmw1);
    System.out.println("After clone - mercedes1: " + mercedes1);

    bmw1.isElectric = true;
    bmw1.isManual = false;
    System.out.println("\nAfter modifying bmw1:");
    System.out.println("bmw1: " + bmw1);
    System.out.println("mercedes1: " + mercedes1);

    System.out.println("\n=== TEST 2: WITHOUT initialize() ===");
    System.out.println("To test this, we need to comment out initialize() in Vehicle.clone()");
    System.out.println("Then mercedes values WILL be copied to bmw (but still independent)");

    // Manual simulation of clone WITHOUT initialize()
    Car mercedes2 = new Car();
    mercedes2.isManual = true;
    mercedes2.isElectric = false;
    System.out.println("\nBefore clone - mercedes2: " + mercedes2);

    // Simulating super.clone() without initialize()
    Car bmw2 = new Car();
    bmw2.isManual = mercedes2.isManual; // Copies the value
    bmw2.isElectric = mercedes2.isElectric; // Copies the value
    System.out.println("After clone (without initialize) - bmw2: " + bmw2);

    bmw2.isElectric = true;
    System.out.println("\nAfter modifying bmw2.isElectric = true:");
    System.out.println("bmw2: " + bmw2);
    System.out.println("mercedes2: " + mercedes2 + " <- UNCHANGED because they are independent objects");
  }
}
