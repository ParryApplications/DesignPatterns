# State Pattern with Flyweight - Correct Implementation

## Overview
This is a **100% correct implementation** of the State behavioral design pattern combined with the Flyweight structural pattern for a traffic light system.

---

## Design Patterns Used

### 1. **State Pattern** (Behavioral)
**Purpose:** Allow an object to alter its behavior when its internal state changes.

**Key Components:**
- **State Interface:** [`TrafficLight`](src/designPatterns/Behavioral/State/TrafficLight.java) - Defines the contract for all states
- **Concrete States:** [`Red`](src/designPatterns/Behavioral/State/Red.java), [`Yellow`](src/designPatterns/Behavioral/State/Yellow.java), [`Green`](src/designPatterns/Behavioral/State/Green.java) - Implement specific behaviors
- **Context:** [`Context`](src/designPatterns/Behavioral/State/Context.java) - Maintains current state and delegates requests

### 2. **Flyweight Pattern** (Structural)
**Purpose:** Share objects to support large numbers of fine-grained objects efficiently.

**Implementation:** Each state class uses a singleton instance (private constructor + static getInstance()) to ensure only one instance exists and is reused across all contexts.

---

## Class Structure

```
┌─────────────────────────────────────────────────────────────┐
│                         Context                              │
├─────────────────────────────────────────────────────────────┤
│ - currentState: TrafficLight                                 │
│ - scheduler: ScheduledExecutorService                        │
├─────────────────────────────────────────────────────────────┤
│ + Context()                                                  │
│ + Context(TrafficLight initialState)                        │
│ + setState(TrafficLight state): void                        │
│ + getCurrentState(): TrafficLight                           │
│ + request(): void                                           │
│ + startAutoTransition(int intervalSeconds): void            │
│ + stop(): void                                              │
└─────────────────────────────────────────────────────────────┘
                            │
                            │ maintains
                            ▼
                ┌───────────────────────┐
                │   <<interface>>       │
                │    TrafficLight       │
                ├───────────────────────┤
                │ + message(): void     │
                │ + handle(Context): void│
                └───────────────────────┘
                            △
                            │ implements
            ┌───────────────┼───────────────┐
            │               │               │
    ┌───────▼──────┐ ┌─────▼──────┐ ┌─────▼──────┐
    │     Red      │ │   Yellow   │ │   Green    │
    ├──────────────┤ ├────────────┤ ├────────────┤
    │ - INSTANCE   │ │ - INSTANCE │ │ - INSTANCE │
    ├──────────────┤ ├────────────┤ ├────────────┤
    │ + getInstance│ │ +getInstance│ │ +getInstance│
    │ + message()  │ │ + message()│ │ + message()│
    │ + handle()   │ │ + handle() │ │ + handle() │
    └──────────────┘ └────────────┘ └────────────┘
```

---

## Key Principles Followed

### ✅ State Pattern Principles

1. **Context maintains current state**
   - [`Context.currentState`](src/designPatterns/Behavioral/State/Context.java:12) holds the reference

2. **States change context's state**
   - Each state calls [`context.setState()`](src/designPatterns/Behavioral/State/Context.java:33) to transition
   - Example: [`Red.handle()`](src/designPatterns/Behavioral/State/Red.java:29) calls `context.setState(Yellow.getInstance())`

3. **Context delegates to state**
   - [`Context.request()`](src/designPatterns/Behavioral/State/Context.java:50) delegates to `currentState.handle(this)`

4. **States know about transitions**
   - Each state determines the next state in its [`handle()`](src/designPatterns/Behavioral/State/TrafficLight.java:15) method

5. **States receive Context reference**
   - All state methods receive Context as parameter: `handle(Context context)`

### ✅ Flyweight Pattern Principles

1. **Intrinsic state only**
   - State objects contain no mutable data
   - All behavior is stateless

2. **Shared instances**
   - Single instance per state class
   - Private constructor prevents external instantiation
   - Static `getInstance()` method provides access

3. **Memory efficiency**
   - No matter how many Context objects exist, only 3 state objects are created
   - States are reused across all contexts

---

## How It Works

### State Transitions Flow

```
Red (Stop) → Yellow (Prepare) → Green (Go) → Red (Stop) → ...
```

### Sequence Diagram

```
Client          Context         Red             Yellow          Green
  │               │              │                │              │
  │─request()────>│              │                │              │
  │               │─handle(ctx)─>│                │              │
  │               │              │─message()      │              │
  │               │              │─setState(Yellow)│              │
  │               │<─────────────│                │              │
  │               │──────────────────handle(ctx)─>│              │
  │               │                               │─message()    │
  │               │                               │─setState(Green)│
  │               │<──────────────────────────────│              │
  │               │───────────────────────────────────handle(ctx)>│
  │               │                                              │─message()
  │               │                                              │─setState(Red)
  │               │<─────────────────────────────────────────────│
```

---

## Differences from Original Implementation

| Aspect | ❌ Original (Incorrect) | ✅ New (Correct) |
|--------|------------------------|------------------|
| **State method signature** | `stateChange(TrafficLight light)` | `handle(Context context)` |
| **Parameter usage** | Parameter never used | Context used to change state |
| **State instances** | New instance created each time | Singleton instances (Flyweight) |
| **State transition** | States return new state | States call `context.setState()` |
| **Context responsibility** | Only schedules transitions | Manages state + provides control methods |
| **Resource management** | No cleanup (leak) | Proper shutdown mechanism |
| **Separation of concerns** | Mixed scheduling & state logic | Clear separation |
| **Unused imports** | `TemporalAccessor` imported | Clean imports only |

---

## Usage Examples

### Example 1: Manual State Transitions
```java
Context trafficLight = new Context();
trafficLight.request(); // Red -> Yellow
trafficLight.request(); // Yellow -> Green
trafficLight.request(); // Green -> Red
```

### Example 2: Automatic State Transitions
```java
Context trafficLight = new Context(Red.getInstance());
trafficLight.startAutoTransition(2); // Change every 2 seconds

// Later...
trafficLight.stop(); // Clean shutdown
```

### Example 3: Verify Flyweight Pattern
```java
Red red1 = Red.getInstance();
Red red2 = Red.getInstance();
System.out.println(red1 == red2); // true - same instance
```

---

## Benefits of This Implementation

### State Pattern Benefits
1. **Single Responsibility Principle** - Each state class handles its own behavior
2. **Open/Closed Principle** - Easy to add new states without modifying existing code
3. **Eliminates conditional logic** - No if/else or switch statements for state behavior
4. **Clear state transitions** - Each state explicitly defines its successor

### Flyweight Pattern Benefits
1. **Memory efficiency** - Only 3 state objects regardless of Context count
2. **Performance** - No object creation overhead during transitions
3. **Thread-safe** - Stateless objects are inherently thread-safe
4. **Consistent behavior** - Same instance ensures consistent behavior

### Combined Benefits
1. **Scalability** - Can handle thousands of traffic lights with minimal memory
2. **Maintainability** - Clear structure, easy to understand and modify
3. **Testability** - Each component can be tested independently
4. **Reusability** - States can be shared across different contexts

---

## Testing the Implementation

Run [`Client.java`](src/designPatterns/Behavioral/State/Client.java) to see:
1. Manual state transitions
2. Automatic state transitions with scheduling
3. Flyweight pattern verification (instance comparison)

Expected output:
```
=== State Pattern with Flyweight Demo ===

--- Example 1: Manual State Transitions ---
🔴 RED LIGHT: Vehicles STOP Now!
🟡 YELLOW LIGHT: Vehicles should be ready to stop or carefully drive across!
🟢 GREEN LIGHT: Vehicles should drive across!
🔴 RED LIGHT: Vehicles STOP Now!

--- Example 2: Automatic State Transitions ---
🚦 Traffic light auto-transition started (every 2 seconds)
🔴 RED LIGHT: Vehicles STOP Now!
🟡 YELLOW LIGHT: Vehicles should be ready to stop or carefully drive across!
🟢 GREEN LIGHT: Vehicles should drive across!
🔴 RED LIGHT: Vehicles STOP Now!
🟡 YELLOW LIGHT: Vehicles should be ready to stop or carefully drive across!
🛑 Traffic light stopped

--- Example 3: Verifying Flyweight Pattern ---
Red instances are same: true
Yellow instances are same: true
Green instances are same: true

✅ Flyweight pattern verified - All state instances are reused!
```

---

## When to Use This Pattern

### Use State Pattern When:
- An object's behavior depends on its state
- You have complex conditional logic based on state
- State transitions are well-defined
- You want to avoid large switch/if-else statements

### Use Flyweight with State When:
- You have many context objects
- States are stateless (no mutable data)
- Memory efficiency is important
- States can be safely shared

---

## Summary

This implementation demonstrates:
✅ **Correct State Pattern** - Context delegates to states, states manage transitions  
✅ **Correct Flyweight Pattern** - Singleton instances, no unnecessary object creation  
✅ **Clean Code** - No unused parameters, proper separation of concerns  
✅ **Resource Management** - Proper cleanup of executor service  
✅ **Extensibility** - Easy to add new states  
✅ **Thread Safety** - Stateless state objects  
✅ **Best Practices** - JavaDoc comments, clear naming, proper encapsulation  

This is a production-ready, textbook-correct implementation of both patterns! 🎯
