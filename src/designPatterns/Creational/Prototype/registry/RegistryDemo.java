package designPatterns.Creational.Prototype.registry;

/**
 * Prototype Registry Pattern Demo
 * 
 * This demonstrates how to use a registry to manage and clone prototype
 * objects.
 * 
 * Benefits:
 * 1. Centralized prototype management
 * 2. Create objects by name without knowing concrete classes
 * 3. Easy to add/remove prototypes at runtime
 * 4. Reduces coupling between client and concrete classes
 */
public class RegistryDemo {
  public static void main(String[] args) throws CloneNotSupportedException {
    System.out.println("=".repeat(80));
    System.out.println("PROTOTYPE REGISTRY PATTERN DEMO");
    System.out.println("=".repeat(80));

    // Step 1: Create the registry
    VehicleRegistry registry = new VehicleRegistry();
    System.out.println("\n✅ Created VehicleRegistry");

    // Step 2: Create and register prototype objects
    System.out.println("\n📝 Registering prototype vehicles...");

    // Register a luxury sedan prototype
    Sedan luxurySedan = new Sedan("Mercedes", "S-Class");
    luxurySedan.setManual(false);
    luxurySedan.setElectric(false);
    luxurySedan.setYear(2024);
    luxurySedan.setTrunkCapacity(500);
    registry.addPrototype("luxury-sedan", luxurySedan);
    System.out.println("  ✓ Registered: luxury-sedan");

    // Register an electric sedan prototype
    Sedan electricSedan = new Sedan("Tesla", "Model S");
    electricSedan.setManual(false);
    electricSedan.setElectric(true);
    electricSedan.setYear(2024);
    electricSedan.setTrunkCapacity(450);
    registry.addPrototype("electric-sedan", electricSedan);
    System.out.println("  ✓ Registered: electric-sedan");

    // Register an SUV prototype
    SUV familySUV = new SUV("Toyota", "Highlander");
    familySUV.setManual(false);
    familySUV.setElectric(false);
    familySUV.setYear(2024);
    familySUV.setSeatingCapacity(7);
    familySUV.setHasFourWheelDrive(true);
    registry.addPrototype("family-suv", familySUV);
    System.out.println("  ✓ Registered: family-suv");

    // Register a sports car prototype
    SportsCar sportsCar = new SportsCar("Ferrari", "F8");
    sportsCar.setManual(true);
    sportsCar.setElectric(false);
    sportsCar.setYear(2024);
    sportsCar.setTopSpeed(340);
    sportsCar.setHasConvertibleRoof(false);
    registry.addPrototype("sports-car", sportsCar);
    System.out.println("  ✓ Registered: sports-car");

    // Step 3: List all registered prototypes
    System.out.println("\n📋 Current registry:");
    registry.listPrototypes();
    System.out.println("Total prototypes: " + registry.size());

    // Step 4: Clone vehicles from the registry
    System.out.println("\n" + "=".repeat(80));
    System.out.println("CLONING VEHICLES FROM REGISTRY");
    System.out.println("=".repeat(80));

    // Clone a luxury sedan
    System.out.println("\n🚗 Creating a new luxury sedan from prototype...");
    Vehicle myMercedes = registry.getPrototype("luxury-sedan");
    if (myMercedes != null) {
      System.out.println("Original prototype: " + luxurySedan);
      System.out.println("Cloned vehicle:     " + myMercedes);
      System.out.println("Are they the same object? " + (luxurySedan == myMercedes));
      System.out.println("Are they equal in content? " + luxurySedan.toString().equals(myMercedes.toString()));
    }

    // Clone and customize
    System.out.println("\n🚗 Creating and customizing an electric sedan...");
    Vehicle myTesla = registry.getPrototype("electric-sedan");
    if (myTesla instanceof Sedan) {
      Sedan teslaSedan = (Sedan) myTesla;
      teslaSedan.setBrand("Tesla");
      teslaSedan.setModel("Model 3"); // Customize the model
      teslaSedan.setYear(2025); // Update year
      System.out.println("Original prototype: " + electricSedan);
      System.out.println("Customized clone:   " + teslaSedan);
    }

    // Clone multiple vehicles from the same prototype
    System.out.println("\n🚙 Creating multiple SUVs from the same prototype...");
    Vehicle suv1 = registry.getPrototype("family-suv");
    Vehicle suv2 = registry.getPrototype("family-suv");
    Vehicle suv3 = registry.getPrototype("family-suv");

    if (suv1 instanceof SUV && suv2 instanceof SUV && suv3 instanceof SUV) {
      ((SUV) suv1).setBrand("Toyota");
      ((SUV) suv2).setBrand("Honda");
      ((SUV) suv3).setBrand("Ford");

      System.out.println("SUV 1: " + suv1);
      System.out.println("SUV 2: " + suv2);
      System.out.println("SUV 3: " + suv3);
      System.out.println("All are independent objects: " +
          (suv1 != suv2 && suv2 != suv3 && suv1 != suv3));
    }

    // Step 5: Demonstrate runtime prototype management
    System.out.println("\n" + "=".repeat(80));
    System.out.println("RUNTIME PROTOTYPE MANAGEMENT");
    System.out.println("=".repeat(80));

    // Add a new prototype at runtime
    System.out.println("\n➕ Adding a new prototype at runtime...");
    SportsCar convertible = new SportsCar("Porsche", "911");
    convertible.setHasConvertibleRoof(true);
    convertible.setTopSpeed(320);
    registry.addPrototype("convertible", convertible);
    System.out.println("Added: convertible");

    registry.listPrototypes();

    // Remove a prototype
    System.out.println("\n➖ Removing 'sports-car' prototype...");
    registry.removePrototype("sports-car");
    registry.listPrototypes();

    // Try to get a non-existent prototype
    System.out.println("\n❓ Trying to get a non-existent prototype...");
    Vehicle nonExistent = registry.getPrototype("non-existent");
    System.out.println("Result: " + (nonExistent == null ? "null (as expected)" : nonExistent));

    // Check if prototype exists
    System.out.println("\n🔍 Checking prototype existence:");
    System.out.println("  luxury-sedan exists? " + registry.hasPrototype("luxury-sedan"));
    System.out.println("  sports-car exists? " + registry.hasPrototype("sports-car"));
    System.out.println("  convertible exists? " + registry.hasPrototype("convertible"));

    // Step 6: Real-world use case
    System.out.println("\n" + "=".repeat(80));
    System.out.println("REAL-WORLD USE CASE: Car Dealership Inventory");
    System.out.println("=".repeat(80));

    System.out.println("\n🏢 Dealership receives order for 5 electric sedans...");
    for (int i = 1; i <= 5; i++) {
      Vehicle car = registry.getPrototype("electric-sedan");
      if (car instanceof Sedan) {
        Sedan sedan = (Sedan) car;
        sedan.setModel("Model S #" + i);
        System.out.println("  Order " + i + ": " + sedan.getBrand() + " " + sedan.getModel());
      }
    }

    System.out.println("\n🏢 Dealership receives order for 3 family SUVs...");
    for (int i = 1; i <= 3; i++) {
      Vehicle car = registry.getPrototype("family-suv");
      if (car instanceof SUV) {
        SUV suv = (SUV) car;
        suv.setModel("Highlander #" + i);
        System.out.println("  Order " + i + ": " + suv.getBrand() + " " + suv.getModel() +
            " (Seats: " + suv.getSeatingCapacity() + ")");
      }
    }

    // Final summary
    System.out.println("\n" + "=".repeat(80));
    System.out.println("SUMMARY");
    System.out.println("=".repeat(80));
    System.out.println("✅ Prototype Registry allows:");
    System.out.println("   1. Centralized management of prototype objects");
    System.out.println("   2. Creating objects by name/key without knowing concrete classes");
    System.out.println("   3. Adding/removing prototypes at runtime");
    System.out.println("   4. Efficient object creation through cloning");
    System.out.println("   5. Reduced coupling between client and concrete classes");
    System.out.println("\n✅ Each cloned object is independent and can be customized");
    System.out.println("✅ Perfect for scenarios with pre-configured object templates");
    System.out.println("=".repeat(80));
  }
}
