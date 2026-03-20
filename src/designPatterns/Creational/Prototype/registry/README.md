# Prototype Registry Pattern

## Overview

The **Prototype Registry** is an advanced implementation of the Prototype pattern that manages a collection of prototype objects. Instead of clients creating prototypes themselves, they request clones from a centralized registry using keys/names.

## Structure

```
registry/
├── Vehicle.java              - Base abstract class
├── Sedan.java               - Concrete vehicle type
├── SUV.java                 - Concrete vehicle type
├── SportsCar.java           - Concrete vehicle type
├── VehicleRegistry.java     - The registry manager
├── RegistryDemo.java        - Complete demonstration
└── README.md               - This file
```

## How to Run

```bash
cd src
javac designPatterns/Creational/Prototype/registry/*.java
java designPatterns.Creational.Prototype.registry.RegistryDemo
```

## Key Components

### 1. VehicleRegistry - The Registry Manager

```java
public class VehicleRegistry {
    private Map<String, Vehicle> prototypes = new HashMap<>();
    
    // Register a prototype
    public void addPrototype(String key, Vehicle prototype) {
        prototypes.put(key, prototype);
    }
    
    // Get a clone of the prototype
    public Vehicle getPrototype(String key) {
        Vehicle prototype = prototypes.get(key);
        return prototype != null ? prototype.clone() : null;
    }
    
    // Remove a prototype
    public void removePrototype(String key) {
        prototypes.remove(key);
    }
}
```

### 2. Usage Pattern

```java
// Step 1: Create registry
VehicleRegistry registry = new VehicleRegistry();

// Step 2: Create and register prototypes
Sedan luxurySedan = new Sedan("Mercedes", "S-Class");
luxurySedan.setManual(false);
luxurySedan.setElectric(false);
registry.addPrototype("luxury-sedan", luxurySedan);

// Step 3: Clone from registry
Vehicle myMercedes = registry.getPrototype("luxury-sedan");

// Step 4: Customize the clone
myMercedes.setYear(2025);
```

## Benefits

### 1. **Centralized Management**
- All prototypes are managed in one place
- Easy to see what prototypes are available
- Consistent access pattern

### 2. **Decoupling**
- Clients don't need to know concrete classes
- Request objects by name/key
- Reduces dependencies

### 3. **Runtime Flexibility**
- Add new prototypes at runtime
- Remove obsolete prototypes
- Update prototype configurations

### 4. **Efficient Object Creation**
- Pre-configured templates
- Clone instead of construct
- Avoid expensive initialization

## Real-World Use Cases

### 1. **Car Dealership Inventory**
```java
// Register standard configurations
registry.addPrototype("base-sedan", baseSedan);
registry.addPrototype("luxury-sedan", luxurySedan);
registry.addPrototype("sport-sedan", sportSedan);

// Create inventory
for (int i = 0; i < 10; i++) {
    Vehicle car = registry.getPrototype("base-sedan");
    inventory.add(car);
}
```

### 2. **Game Development - Enemy Templates**
```java
registry.addPrototype("goblin", goblinPrototype);
registry.addPrototype("orc", orcPrototype);
registry.addPrototype("dragon", dragonPrototype);

// Spawn enemies
Enemy enemy = registry.getPrototype("goblin");
```

### 3. **Document Templates**
```java
registry.addPrototype("invoice", invoiceTemplate);
registry.addPrototype("receipt", receiptTemplate);
registry.addPrototype("contract", contractTemplate);

// Create new document
Document doc = registry.getPrototype("invoice");
```

### 4. **UI Component Library**
```java
registry.addPrototype("primary-button", primaryButton);
registry.addPrototype("secondary-button", secondaryButton);
registry.addPrototype("danger-button", dangerButton);

// Create button
Button btn = registry.getPrototype("primary-button");
```

## Comparison with Other Patterns

### vs Factory Pattern

| Aspect | Prototype Registry | Factory Pattern |
|--------|-------------------|-----------------|
| **Object Creation** | Cloning existing objects | Constructing new objects |
| **Configuration** | Pre-configured prototypes | Parameters to factory |
| **Flexibility** | Runtime prototype changes | Compile-time factory logic |
| **Performance** | Fast (cloning) | Slower (construction) |
| **Use Case** | Complex pre-configured objects | Simple object creation |

### vs Builder Pattern

| Aspect | Prototype Registry | Builder Pattern |
|--------|-------------------|-----------------|
| **Complexity** | Simple (clone + customize) | Complex (step-by-step) |
| **Reusability** | High (reuse prototypes) | Medium (reuse builder) |
| **Flexibility** | Pre-defined templates | Custom construction |
| **Use Case** | Standard configurations | Custom configurations |

## Advanced Features

### 1. **Nested Registries**

```java
public class VehicleRegistry {
    private Map<String, VehicleRegistry> subRegistries = new HashMap<>();
    
    public void addSubRegistry(String category, VehicleRegistry registry) {
        subRegistries.put(category, registry);
    }
    
    public Vehicle getPrototype(String category, String key) {
        VehicleRegistry subRegistry = subRegistries.get(category);
        return subRegistry != null ? subRegistry.getPrototype(key) : null;
    }
}

// Usage
VehicleRegistry sedanRegistry = new VehicleRegistry();
VehicleRegistry suvRegistry = new VehicleRegistry();

mainRegistry.addSubRegistry("sedans", sedanRegistry);
mainRegistry.addSubRegistry("suvs", suvRegistry);

Vehicle car = mainRegistry.getPrototype("sedans", "luxury");
```

### 2. **Prototype Versioning**

```java
public class VersionedRegistry {
    private Map<String, Map<String, Vehicle>> versionedPrototypes = new HashMap<>();
    
    public void addPrototype(String key, String version, Vehicle prototype) {
        versionedPrototypes
            .computeIfAbsent(key, k -> new HashMap<>())
            .put(version, prototype);
    }
    
    public Vehicle getPrototype(String key, String version) {
        Map<String, Vehicle> versions = versionedPrototypes.get(key);
        if (versions != null) {
            Vehicle prototype = versions.get(version);
            return prototype != null ? prototype.clone() : null;
        }
        return null;
    }
}

// Usage
registry.addPrototype("sedan", "v1", sedanV1);
registry.addPrototype("sedan", "v2", sedanV2);

Vehicle oldSedan = registry.getPrototype("sedan", "v1");
Vehicle newSedan = registry.getPrototype("sedan", "v2");
```

### 3. **Lazy Loading**

```java
public class LazyRegistry {
    private Map<String, Supplier<Vehicle>> prototypeFactories = new HashMap<>();
    private Map<String, Vehicle> loadedPrototypes = new HashMap<>();
    
    public void registerFactory(String key, Supplier<Vehicle> factory) {
        prototypeFactories.put(key, factory);
    }
    
    public Vehicle getPrototype(String key) {
        if (!loadedPrototypes.containsKey(key)) {
            Supplier<Vehicle> factory = prototypeFactories.get(key);
            if (factory != null) {
                loadedPrototypes.put(key, factory.get());
            }
        }
        Vehicle prototype = loadedPrototypes.get(key);
        return prototype != null ? prototype.clone() : null;
    }
}

// Usage
registry.registerFactory("luxury-sedan", () -> {
    Sedan sedan = new Sedan("Mercedes", "S-Class");
    // Expensive initialization
    return sedan;
});
```

## Best Practices

### ✅ DO

1. **Use meaningful keys**
   ```java
   registry.addPrototype("luxury-sedan-2024", sedan);  // Good
   registry.addPrototype("s1", sedan);                 // Bad
   ```

2. **Validate before cloning**
   ```java
   public Vehicle getPrototype(String key) {
       if (!prototypes.containsKey(key)) {
           throw new IllegalArgumentException("Unknown prototype: " + key);
       }
       return prototypes.get(key).clone();
   }
   ```

3. **Document available prototypes**
   ```java
   public void listPrototypes() {
       System.out.println("Available prototypes:");
       prototypes.keySet().forEach(key -> 
           System.out.println("  - " + key)
       );
   }
   ```

4. **Handle null safely**
   ```java
   Vehicle car = registry.getPrototype("unknown");
   if (car != null) {
       // Use car
   }
   ```

### ❌ DON'T

1. **Don't modify prototypes directly**
   ```java
   // Bad - modifies the prototype!
   registry.getPrototype("sedan").setYear(2025);
   
   // Good - clone first, then modify
   Vehicle car = registry.getPrototype("sedan");
   car.setYear(2025);
   ```

2. **Don't forget to implement clone()**
   ```java
   // All prototype classes must implement clone()
   @Override
   public Vehicle clone() throws CloneNotSupportedException {
       return (Vehicle) super.clone();
   }
   ```

3. **Don't use mutable keys**
   ```java
   // Bad - StringBuilder is mutable
   StringBuilder key = new StringBuilder("sedan");
   registry.addPrototype(key.toString(), sedan);
   
   // Good - use immutable String
   String key = "sedan";
   registry.addPrototype(key, sedan);
   ```

## Summary

The Prototype Registry pattern is ideal when:

- ✅ You have multiple pre-configured object templates
- ✅ Object creation is expensive
- ✅ You need runtime flexibility to add/remove prototypes
- ✅ You want to decouple clients from concrete classes
- ✅ You need to create many similar objects with slight variations

**Key Advantage**: Combines the benefits of the Prototype pattern (efficient cloning) with centralized management and runtime flexibility.
