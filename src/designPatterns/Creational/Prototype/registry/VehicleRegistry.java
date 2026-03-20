package designPatterns.Creational.Prototype.registry;

import java.util.HashMap;
import java.util.Map;

/**
 * Prototype Registry - Manages a collection of prototype objects
 * 
 * Benefits:
 * 1. Centralized management of prototypes
 * 2. Easy to add/remove prototypes at runtime
 * 3. Clients don't need to know concrete classes
 * 4. Can create objects by name/key
 */
public class VehicleRegistry {
  private Map<String, Vehicle> prototypes = new HashMap<>();

  /**
   * Register a prototype with a unique key
   */
  public void addPrototype(String key, Vehicle prototype) {
    prototypes.put(key, prototype);
  }

  /**
   * Remove a prototype from the registry
   */
  public void removePrototype(String key) {
    prototypes.remove(key);
  }

  /**
   * Get a clone of the prototype by key
   * Returns null if key doesn't exist
   */
  public Vehicle getPrototype(String key) {
    Vehicle prototype = prototypes.get(key);
    if (prototype != null) {
      try {
        return prototype.clone();
      } catch (CloneNotSupportedException e) {
        System.err.println("Error cloning prototype: " + key);
        e.printStackTrace();
        return null;
      }
    }
    return null;
  }

  /**
   * Check if a prototype exists
   */
  public boolean hasPrototype(String key) {
    return prototypes.containsKey(key);
  }

  /**
   * Get all registered prototype keys
   */
  public void listPrototypes() {
    System.out.println("Registered Prototypes:");
    for (String key : prototypes.keySet()) {
      System.out.println("  - " + key + ": " + prototypes.get(key).getClass().getSimpleName());
    }
  }

  /**
   * Clear all prototypes
   */
  public void clear() {
    prototypes.clear();
  }

  /**
   * Get the number of registered prototypes
   */
  public int size() {
    return prototypes.size();
  }
}
