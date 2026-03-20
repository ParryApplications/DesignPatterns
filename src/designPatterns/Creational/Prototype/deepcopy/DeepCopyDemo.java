package designPatterns.Creational.Prototype.deepcopy;

public class DeepCopyDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        System.out.println("=".repeat(80));
        System.out.println("SHALLOW COPY PROBLEM - Objects Share References");
        System.out.println("=".repeat(80));
        
        // Create original vehicle with shallow copy
        ShallowCopyVehicle mercedes = new ShallowCopyVehicle("John");
        mercedes.setManual(true);
        mercedes.setEngine(new Engine("V8", 500));
        
        System.out.println("Original Mercedes:");
        System.out.println(mercedes);
        System.out.println("Engine object reference: " + System.identityHashCode(mercedes.getEngine()));
        
        // Clone with SHALLOW copy
        ShallowCopyVehicle bmw = mercedes.clone();
        
        System.out.println("\nCloned BMW (after shallow copy):");
        System.out.println(bmw);
        System.out.println("Engine object reference: " + System.identityHashCode(bmw.getEngine()));
        
        System.out.println("\n⚠️  NOTICE: Both vehicles share the SAME Engine object!");
        System.out.println("Mercedes engine reference: " + System.identityHashCode(mercedes.getEngine()));
        System.out.println("BMW engine reference:      " + System.identityHashCode(bmw.getEngine()));
        System.out.println("Are they the same object? " + (mercedes.getEngine() == bmw.getEngine()));
        
        // Modify BMW's engine
        System.out.println("\n🔧 Modifying BMW's engine to V6 with 400 HP...");
        bmw.getEngine().setType("V6");
        bmw.getEngine().setHorsepower(400);
        
        System.out.println("\nAfter modifying BMW's engine:");
        System.out.println("Mercedes: " + mercedes);
        System.out.println("BMW:      " + bmw);
        
        System.out.println("\n❌ PROBLEM: Mercedes engine was also changed!");
        System.out.println("This is the SHALLOW COPY problem - they share the same Engine object");
        
        System.out.println("\n" + "=".repeat(80));
        System.out.println("DEEP COPY SOLUTION - Each Object Has Its Own Copy");
        System.out.println("=".repeat(80));
        
        // Create original vehicle with deep copy
        VehicleWithDeepCopy audi = new VehicleWithDeepCopy("Sarah");
        audi.setManual(true);
        audi.setEngine(new Engine("V8", 500));
        audi.addFeature("Sunroof");
        audi.addFeature("Leather Seats");
        
        System.out.println("\nOriginal Audi:");
        System.out.println(audi);
        System.out.println("Engine object reference: " + System.identityHashCode(audi.getEngine()));
        System.out.println("Features list reference: " + System.identityHashCode(audi.getFeatures()));
        
        // Clone with DEEP copy
        VehicleWithDeepCopy tesla = audi.clone();
        
        System.out.println("\nCloned Tesla (after deep copy):");
        System.out.println(tesla);
        System.out.println("Engine object reference: " + System.identityHashCode(tesla.getEngine()));
        System.out.println("Features list reference: " + System.identityHashCode(tesla.getFeatures()));
        
        System.out.println("\n✅ NOTICE: Each vehicle has its OWN Engine object!");
        System.out.println("Audi engine reference:  " + System.identityHashCode(audi.getEngine()));
        System.out.println("Tesla engine reference: " + System.identityHashCode(tesla.getEngine()));
        System.out.println("Are they the same object? " + (audi.getEngine() == tesla.getEngine()));
        
        System.out.println("\nAudi features list:  " + System.identityHashCode(audi.getFeatures()));
        System.out.println("Tesla features list: " + System.identityHashCode(tesla.getFeatures()));
        System.out.println("Are they the same list? " + (audi.getFeatures() == tesla.getFeatures()));
        
        // Modify Tesla's engine and features
        System.out.println("\n🔧 Modifying Tesla's engine to Electric with 600 HP...");
        tesla.getEngine().setType("Electric");
        tesla.getEngine().setHorsepower(600);
        tesla.setElectric(true);
        tesla.addFeature("Autopilot");
        
        System.out.println("\nAfter modifying Tesla:");
        System.out.println("Audi:  " + audi);
        System.out.println("Tesla: " + tesla);
        
        System.out.println("\n✅ SUCCESS: Audi remains unchanged!");
        System.out.println("This is the benefit of DEEP COPY - each object is independent");
        
        System.out.println("\n" + "=".repeat(80));
        System.out.println("SUMMARY");
        System.out.println("=".repeat(80));
        System.out.println("SHALLOW COPY:");
        System.out.println("  - Copies primitive values (int, boolean, etc.)");
        System.out.println("  - Copies object REFERENCES (both point to same object)");
        System.out.println("  - Modifying shared objects affects both original and clone");
        System.out.println("  - Fast but can cause unexpected side effects");
        
        System.out.println("\nDEEP COPY:");
        System.out.println("  - Copies primitive values (int, boolean, etc.)");
        System.out.println("  - Creates NEW copies of all objects");
        System.out.println("  - Original and clone are completely independent");
        System.out.println("  - Slower but safer - no shared state");
        System.out.println("=".repeat(80));
    }
}
