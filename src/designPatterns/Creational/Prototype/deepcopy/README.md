# Deep Copy vs Shallow Copy - Complete Guide

## Overview

This package demonstrates the difference between **shallow copy** and **deep copy** in Java's Prototype pattern.

## Files Created

1. **[`Engine.java`](Engine.java)** - A cloneable object representing a car engine
2. **[`ShallowCopyVehicle.java`](ShallowCopyVehicle.java)** - Vehicle with SHALLOW copy (problematic)
3. **[`VehicleWithDeepCopy.java`](VehicleWithDeepCopy.java)** - Vehicle with DEEP copy (correct)
4. **[`DeepCopyDemo.java`](DeepCopyDemo.java)** - Demo showing the difference

## How to Run

```bash
cd src
javac designPatterns/Creational/Prototype/deepcopy/*.java
java designPatterns.Creational.Prototype.deepcopy.DeepCopyDemo
```

## Key Concepts

### Shallow Copy (Problematic)

```java
@Override
public ShallowCopyVehicle clone() throws CloneNotSupportedException {
    // Only copies references, not the objects themselves
    return (ShallowCopyVehicle) super.clone();
}
```

**Problem:**
- Primitives are copied ✅
- Object references are copied ❌ (both point to SAME object)
- Modifying the Engine in the clone affects the original!

**Memory Diagram:**
```
mercedes.engine ──┐
                  ├──> Engine@123 (SHARED!)
bmw.engine ───────┘
```

### Deep Copy (Correct Solution)

```java
@Override
public VehicleWithDeepCopy clone() throws CloneNotSupportedException {
    // Step 1: Shallow copy
    VehicleWithDeepCopy cloned = (VehicleWithDeepCopy) super.clone();
    
    // Step 2: Deep copy all object references
    if (this.engine != null) {
        cloned.engine = this.engine.clone();  // Create NEW Engine
    }
    
    if (this.features != null) {
        cloned.features = new ArrayList<>(this.features);  // Create NEW List
    }
    
    return cloned;
}
```

**Solution:**
- Primitives are copied ✅
- Object references are cloned ✅ (each has its OWN object)
- Modifying the clone does NOT affect the original ✅

**Memory Diagram:**
```
audi.engine ──> Engine@123 (Independent)

tesla.engine ──> Engine@456 (Independent)
```

## What Gets Deep Copied?

| Type | Needs Deep Copy? | How to Deep Copy |
|------|-----------------|------------------|
| **Primitives** (int, boolean, etc.) | ❌ No | Automatically copied by value |
| **String** | ❌ No | Immutable - safe to share |
| **Custom Objects** (Engine, etc.) | ✅ Yes | Call `.clone()` on the object |
| **Collections** (List, Set, Map) | ✅ Yes | Create new collection: `new ArrayList<>(original)` |
| **Arrays** | ✅ Yes | Use `array.clone()` or `Arrays.copyOf()` |

## Example Output

When you run [`DeepCopyDemo.java`](DeepCopyDemo.java), you'll see:

### Shallow Copy Problem:
```
Original Mercedes: ShallowCopyVehicle{engine=Engine{type='V8', horsepower=500}}
Cloned BMW:        ShallowCopyVehicle{engine=Engine{type='V8', horsepower=500}}

⚠️  Both share the SAME Engine object!

After modifying BMW's engine to V6:
Mercedes: ShallowCopyVehicle{engine=Engine{type='V6', horsepower=400}}  ❌ Changed!
BMW:      ShallowCopyVehicle{engine=Engine{type='V6', horsepower=400}}
```

### Deep Copy Solution:
```
Original Audi: VehicleWithDeepCopy{engine=Engine{type='V8', horsepower=500}}
Cloned Tesla:  VehicleWithDeepCopy{engine=Engine{type='V8', horsepower=500}}

✅ Each has its OWN Engine object!

After modifying Tesla's engine to Electric:
Audi:  VehicleWithDeepCopy{engine=Engine{type='V8', horsepower=500}}     ✅ Unchanged!
Tesla: VehicleWithDeepCopy{engine=Engine{type='Electric', horsepower=600}}
```

## Best Practices

### 1. Always Deep Copy Mutable Objects

```java
// ❌ BAD - Shallow copy
this.features = original.features;

// ✅ GOOD - Deep copy
this.features = new ArrayList<>(original.features);
```

### 2. Make Objects Cloneable

```java
public class Engine implements Cloneable {
    @Override
    public Engine clone() throws CloneNotSupportedException {
        return (Engine) super.clone();
    }
}
```

### 3. Handle Null References

```java
if (this.engine != null) {
    cloned.engine = this.engine.clone();
}
```

### 4. Consider Using Copy Constructors

Alternative to clone():

```java
public VehicleWithDeepCopy(VehicleWithDeepCopy original) {
    this.isElectric = original.isElectric;
    this.isManual = original.isManual;
    this.engine = new Engine(original.engine);  // Copy constructor
    this.features = new ArrayList<>(original.features);
}
```

## Common Mistakes

### ❌ Mistake 1: Forgetting to Clone Nested Objects

```java
@Override
public Vehicle clone() throws CloneNotSupportedException {
    Vehicle cloned = (Vehicle) super.clone();
    // Forgot to clone engine!
    return cloned;  // ❌ Shallow copy problem
}
```

### ❌ Mistake 2: Shallow Copying Collections

```java
cloned.features = this.features;  // ❌ Both point to same List
```

### ✅ Correct: Deep Copy Everything

```java
@Override
public Vehicle clone() throws CloneNotSupportedException {
    Vehicle cloned = (Vehicle) super.clone();
    cloned.engine = this.engine.clone();  // ✅ Deep copy
    cloned.features = new ArrayList<>(this.features);  // ✅ Deep copy
    return cloned;
}
```

## Summary

| Aspect | Shallow Copy | Deep Copy |
|--------|-------------|-----------|
| **Primitives** | Copied by value ✅ | Copied by value ✅ |
| **Object References** | Copied (shared) ❌ | Cloned (independent) ✅ |
| **Performance** | Fast ⚡ | Slower 🐢 |
| **Safety** | Risky - shared state | Safe - independent |
| **Use Case** | Only primitives/immutables | Has mutable objects |

## Relation to Your Original Code

Your original [`Vehicle.java`](../Vehicle.java) only has **primitive fields** (`boolean isElectric`, `boolean isManual`), so:

- Shallow copy works fine (primitives are always copied by value)
- Deep copy is not needed (no object references to clone)
- The `initialize()` method just resets values, doesn't affect copy depth

**But if you add object fields** (like Engine, List, etc.), you MUST implement deep copy as shown in [`VehicleWithDeepCopy.java`](VehicleWithDeepCopy.java).
