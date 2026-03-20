# Clone Method Analysis - Prototype Pattern

## IMPORTANT CLARIFICATION

**You mentioned: "when I am not calling initialize then mercedes values impacting bmw"**

This is a **MISUNDERSTANDING** of terminology. Let me clarify:

- **WITHOUT initialize()**: mercedes values are **COPIED TO** bmw initially, but they remain **INDEPENDENT** objects
- **WITH initialize()**: bmw gets **RESET** values (false, false), ignoring mercedes values  
- **In BOTH cases**: mercedes and bmw are **SEPARATE, INDEPENDENT** objects - changing one NEVER affects the other

### The Confusion: "Impacting" vs "Copying Initial Values"

| Scenario | What happens at clone time | Are they independent after? | Can changes to bmw affect mercedes? |
|----------|---------------------------|----------------------------|-------------------------------------|
| **Without initialize()** | bmw **starts with** mercedes values<br/>(isManual=true copied from mercedes) | ✅ YES | ❌ NO - they are separate objects |
| **With initialize()** | bmw **starts with** reset values<br/>(isManual=false, ignoring mercedes) | ✅ YES | ❌ NO - they are separate objects |

**Example WITHOUT initialize():**
```java
Car mercedes = new Car();
mercedes.isManual = true;  // mercedes: {isElectric=false, isManual=true}

Car bmw = (Car) mercedes.clone();  // WITHOUT initialize()
// bmw COPIES mercedes values: {isElectric=false, isManual=true}
// BUT they are SEPARATE objects in memory

bmw.isElectric = true;
// bmw: {isElectric=true, isManual=true}
// mercedes: {isElectric=false, isManual=true}  <- UNCHANGED!
```

**Example WITH initialize():**
```java
Car mercedes = new Car();
mercedes.isManual = true;  // mercedes: {isElectric=false, isManual=true}

Car bmw = (Car) mercedes.clone();  // WITH initialize()
// bmw first copies: {isElectric=false, isManual=true}
// Then initialize() resets: {isElectric=false, isManual=false}

bmw.isElectric = true;
// bmw: {isElectric=true, isManual=false}
// mercedes: {isElectric=false, isManual=true}  <- UNCHANGED!
```

**Key Point**: The word "impacting" suggests one affects the other. That's NOT happening. What you're seeing is:
- **Without initialize()**: bmw **inherits** mercedes's initial values (but remains independent)
- **With initialize()**: bmw **ignores** mercedes's values and starts fresh

---

## Your Questions Answered

### 1. Is this a deep copy when calling initialize()?

**Answer: NO, this is still a SHALLOW COPY, but with field reset.**

**Explanation:**

In your [`Vehicle.clone()`](src/designPatterns/Creational/Prototype/Vehicle.java:8) method:

```java
@Override
public Vehicle clone() throws CloneNotSupportedException {
    Vehicle vehicle = (Vehicle) super.clone();  // This creates a SHALLOW copy
    vehicle.initialize();                        // This just resets primitive fields
    return vehicle;
}
```

- `super.clone()` performs a **shallow copy** by default
- For your current `Vehicle` class, this doesn't matter much because you only have **primitive fields** (`boolean isElectric`, `boolean isManual`)
- Primitives are **always copied by value**, so even a shallow copy creates independent copies of these fields

**When would deep vs shallow matter?**

If your `Vehicle` class had **object references** (not primitives), then:

```java
// Example with object references
public abstract class Vehicle implements Cloneable {
    public Engine engine;  // Object reference
    public List<String> features;  // Object reference
    
    @Override
    public Vehicle clone() throws CloneNotSupportedException {
        Vehicle vehicle = (Vehicle) super.clone();  // SHALLOW COPY
        // vehicle.engine still points to the SAME Engine object as original
        // vehicle.features still points to the SAME List as original
        
        // For DEEP COPY, you would need:
        vehicle.engine = this.engine.clone();  // Clone the Engine too
        vehicle.features = new ArrayList<>(this.features);  // Create new List
        
        return vehicle;
    }
}
```

**What does initialize() do?**

The [`initialize()`](src/designPatterns/Creational/Prototype/Vehicle.java:14) method just **resets the fields to default values**:

```java
protected void initialize() {
    this.isManual = false;
    this.isElectric = false;
}
```

This is **NOT** creating a deep copy - it's just resetting the cloned object's fields to `false`.

---

### 2. Why doesn't modifying bmw affect mercedes?

**Answer: Because primitives are ALWAYS copied by value, creating independent copies.**

**Your Code Flow:**

```java
Car mercedes = new Car();
mercedes.isManual = true;  // mercedes: {isElectric=false, isManual=true}

Car bmw = (Car) mercedes.clone();  // Creates a new Car object
// After clone():
// - super.clone() copies primitive values: bmw gets its OWN copy of isElectric=false, isManual=true
// - initialize() resets: bmw now has isElectric=false, isManual=false
// - mercedes is UNCHANGED: {isElectric=false, isManual=true}

bmw.isElectric = true;  // Only modifies bmw's copy
// bmw: {isElectric=true, isManual=false}
// mercedes: {isElectric=false, isManual=true}  // UNCHANGED
```

**Why mercedes is NOT affected:**

1. **Primitive fields are copied by value**: When `super.clone()` runs, Java creates a **new** `Car` object with its **own** copies of `isElectric` and `isManual`
2. **bmw and mercedes are separate objects**: They have their own memory locations
3. **No shared references**: Since there are no object references (only primitives), there's nothing shared between them

**When WOULD you see shared state (shallow copy problem)?**

Only if you had **object references**:

```java
// Example showing shallow copy problem
public class Car extends Vehicle {
    public Engine engine;  // Object reference
}

Car mercedes = new Car();
mercedes.engine = new Engine("V8");

Car bmw = (Car) mercedes.clone();  // Shallow copy
// Both mercedes.engine and bmw.engine point to the SAME Engine object

bmw.engine.setType("V6");  // This WOULD affect mercedes too!
// Because they share the same Engine object
```

---

## Visual Memory Representation

### WITHOUT initialize() - Values Copied but Objects Independent

```
After: Car bmw = (Car) mercedes.clone();

Memory:
┌─────────────────────────────┐
│ mercedes (Object @123)      │
│  - isElectric = false       │
│  - isManual = true          │
└─────────────────────────────┘
         ↑
         │ These are SEPARATE objects
         │ in different memory locations
         ↓
┌─────────────────────────────┐
│ bmw (Object @456)           │
│  - isElectric = false       │  ← Copied from mercedes
│  - isManual = true          │  ← Copied from mercedes
└─────────────────────────────┘

Changing bmw.isElectric = true:
┌─────────────────────────────┐
│ mercedes (Object @123)      │
│  - isElectric = false       │  ← UNCHANGED
│  - isManual = true          │
└─────────────────────────────┘

┌─────────────────────────────┐
│ bmw (Object @456)           │
│  - isElectric = true        │  ← CHANGED
│  - isManual = true          │
└─────────────────────────────┘
```

### WITH initialize() - Values Reset but Objects Still Independent

```
After: Car bmw = (Car) mercedes.clone();

Memory:
┌─────────────────────────────┐
│ mercedes (Object @123)      │
│  - isElectric = false       │
│  - isManual = true          │
└─────────────────────────────┘
         ↑
         │ These are SEPARATE objects
         │ in different memory locations
         ↓
┌─────────────────────────────┐
│ bmw (Object @456)           │
│  - isElectric = false       │  ← Reset by initialize()
│  - isManual = false         │  ← Reset by initialize()
└─────────────────────────────┘

Changing bmw.isElectric = true:
┌─────────────────────────────┐
│ mercedes (Object @123)      │
│  - isElectric = false       │  ← UNCHANGED
│  - isManual = true          │
└─────────────────────────────┘

┌─────────────────────────────┐
│ bmw (Object @456)           │
│  - isElectric = true        │  ← CHANGED
│  - isManual = false         │
└─────────────────────────────┘
```

---

## Summary

| Aspect | Your Current Implementation |
|--------|----------------------------|
| **Copy Type** | Shallow copy (but only has primitives) |
| **Are objects independent?** | YES - because primitives are always copied by value |
| **Does initialize() create deep copy?** | NO - it just resets field values |
| **Can bmw changes affect mercedes?** | NO - they have separate primitive field copies |
| **Would it matter if you had object fields?** | YES - you'd need explicit deep copying for those |
| **Does initialize() prevent mercedes values from being copied?** | YES - it resets bmw to default values after copying |

---

## Recommendations

### Current Code (Only Primitives)
Your current implementation works fine because:
- Primitives are always independent
- `initialize()` provides a clean slate for cloned objects (useful if you want all clones to start fresh)

### If You Want Clones to Inherit Original Values
Remove the `initialize()` call:

```java
@Override
public Vehicle clone() throws CloneNotSupportedException {
    Vehicle vehicle = (Vehicle) super.clone();
    // Don't call initialize() - let the clone inherit the original's values
    return vehicle;
}
```

### If You Add Object References Later
You would need to modify the clone method for deep copying:

```java
@Override
public Vehicle clone() throws CloneNotSupportedException {
    Vehicle vehicle = (Vehicle) super.clone();
    
    // Deep copy any object references
    if (this.engine != null) {
        vehicle.engine = this.engine.clone();
    }
    if (this.features != null) {
        vehicle.features = new ArrayList<>(this.features);
    }
    
    vehicle.initialize();  // Optional - only if you want to reset
    return vehicle;
}
```

---

## Key Takeaway

**Shallow vs Deep Copy only matters for OBJECT REFERENCES, not primitives.**

- **Primitives** (int, boolean, char, etc.): Always copied by value → Independent objects
- **Object References** (String, List, custom objects): Shallow copy shares the same object → Need explicit deep copying for independence

**The role of initialize():**
- Does NOT affect whether objects are independent (they always are with primitives)
- Only determines whether the clone **inherits** the original's values or **starts fresh** with defaults
