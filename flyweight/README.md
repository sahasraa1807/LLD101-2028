# Flyweight Pattern – Map Marker Style Deduplication

## Overview

This project demonstrates the use of the **Flyweight Design Pattern** to optimize memory usage in a map rendering system.

The application simulates rendering **thousands of map markers**, where each marker has a visual style (shape, color, size, filled).

Initially, the system created **a new style object for every marker**, even when many markers shared identical styles. This caused unnecessary **memory duplication**.

The refactoring introduces a **shared style mechanism using Flyweight**, allowing markers with identical styles to reuse the same object.

---

# Problem Statement

The original implementation had the following issue:

Each `MapMarker` object created its own `MarkerStyle`.

Example scenario:

```
Marker 1 → PIN | RED | 12 | FILLED
Marker 2 → PIN | RED | 12 | FILLED
Marker 3 → PIN | RED | 12 | FILLED
```

Even though these styles are identical, the system created **separate `MarkerStyle` objects**.

With thousands of markers, this resulted in:

* Large number of duplicate style objects
* Increased memory consumption
* Poor scalability

---

# Solution

To solve this, the **Flyweight Design Pattern** was introduced.

The idea is to **separate shared data from unique data**.

### Intrinsic State (Shared)

These properties are identical across many markers and are stored once:

* Shape
* Color
* Size
* Filled

These are stored in the **`MarkerStyle`** class.

### Extrinsic State (Unique)

These properties belong to individual markers:

* Latitude
* Longitude
* Label

These remain in the **`MapMarker`** class.

---

# Flyweight Implementation

A **`MarkerStyleFactory`** is introduced to manage shared styles.

Instead of creating a new style every time, the factory:

1. Generates a unique key for the style
2. Checks if the style already exists in the cache
3. Returns the existing style if found
4. Otherwise creates a new style and stores it in the cache

Example key format:

```
shape | color | size | filled
```

Example:

```
PIN|RED|12|F
```

This ensures that **all markers with identical styles share the same object**.

---

# Files Modified During Refactoring

## 1. MarkerStyle.java

Changes made:

* Converted class to **immutable**
* All fields marked as `final`
* Removed setter methods

Purpose:

Ensures shared style objects **cannot be modified after creation**, which is important for Flyweight safety.

---

## 2. MarkerStyleFactory.java

Changes made:

* Implemented **style caching using HashMap**
* Added logic to return existing style objects instead of creating duplicates

Purpose:

Acts as the **central manager for shared style instances**.

---

## 3. MapMarker.java

Changes made:

* Removed direct creation of `MarkerStyle`
* Constructor now receives a `MarkerStyle` object instead of style parameters

Purpose:

Markers now **reference shared styles instead of creating new ones**.

---

## 4. MapDataSource.java

Changes made:

* Added `MarkerStyleFactory`
* Used `styleFactory.get(...)` when creating markers

Before:

```
new MarkerStyle(...)
```

After:

```
MarkerStyle style = styleFactory.get(...)
```

Purpose:

Ensures markers obtain **shared style instances from the factory**.

---

# Files That Remained Unchanged

The following files did not require modification:

* `App.java` – application entry point
* `MapRenderer.java` – handles marker rendering
* `QuickCheck.java` – verifies Flyweight sharing

---

# Validation

The `QuickCheck` class verifies that style objects are shared.

Command:

```
java com.example.map.QuickCheck
```

Expected result:

```
Markers: 20000
Unique style instances: <= 96
```

Why 96?

Possible combinations:

```
3 shapes × 4 colors × 4 sizes × 2 fill options = 96
```

Even with **20,000 markers**, the system creates **at most 96 style objects**.

---

# Benefits of the Refactor

After applying the Flyweight pattern:

* Eliminated thousands of duplicate objects
* Reduced memory usage
* Improved scalability
* Maintained the same external behavior

---

# Build & Run

Compile:

```
javac com/example/map/*.java
```

Run the application:

```
java com.example.map.App
```

Run verification:

```
java com.example.map.QuickCheck
```

---

# Summary

The project refactors the marker rendering system using the **Flyweight Design Pattern**.

Shared style data is extracted into immutable flyweight objects and reused through a factory cache. This significantly reduces memory usage while keeping the rendering behavior unchanged.
