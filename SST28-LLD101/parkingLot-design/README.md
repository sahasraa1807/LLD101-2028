# 🚗 Multilevel Parking Lot System (LLD)

## 📌 Overview

This project implements a **Multilevel Parking Lot System** using object-oriented design principles in Java. The system supports different vehicle types, intelligent slot allocation, and billing based on slot usage.

---

## 🎯 Problem Statement

Design a parking lot system that:

* Supports multiple vehicle types (Bike, Car, Bus)
* Allocates the **nearest available compatible slot**
* Generates parking tickets on entry
* Calculates billing on exit based on **slot type**
* Handles multiple entry gates
* Provides real-time parking status

---

## 🏗️ System Design

### 🔹 Vehicle Types

* **Bike (2-wheeler)**
* **Car**
* **Bus**

---

### 🔹 Slot Types

* **Small** → Bikes
* **Medium** → Cars
* **Large** → Buses

---

### 🔹 Compatibility Rules

| Vehicle | Allowed Slots        |
| ------- | -------------------- |
| Bike    | Small, Medium, Large |
| Car     | Medium, Large        |
| Bus     | Large only           |

---

### 🔹 Billing Rule

Billing is based on **slot type**, NOT vehicle type.

Example:

> Bike parked in Medium slot → charged as Medium

---

## ⚙️ Features

### ✅ Smart Slot Allocation

* Finds **nearest available slot**
* Ensures **compatibility**
* Falls back to larger slot if needed

---

### 🎟️ Ticket Generation

Each ticket stores:

* Vehicle details
* Slot ID
* Slot Type
* Entry Time

---

### 💰 Billing System

* Calculates duration (in hours)
* Applies rate based on slot type
* Ensures minimum 1-hour billing

---

### 📊 Status Tracking

* Displays available slots by type in real time

---

## 📁 Project Structure

```
parkinglot/
│
├── Main.java
│
├── enums/
│   ├── VehicleType.java
│   ├── SlotType.java
│
├── models/
│   ├── Vehicle.java
│   ├── ParkingSlot.java
│   ├── ParkingTicket.java
│   ├── EntryGate.java
│
├── services/
│   ├── ParkingLotService.java
│   ├── BillingService.java
│
├── utils/
│   ├── SlotAllocator.java
```

---

## 🔌 APIs

### 🚗 park(vehicle, entryTime)

* Allocates nearest compatible slot
* Marks slot as occupied
* Returns Parking Ticket

---

### 📊 status()

* Displays available slots grouped by type

---

### 🚪 exit(ticket, exitTime)

* Frees allocated slot
* Calculates parking fee
* Returns bill amount

---

## 🧠 Design Principles Used

* **Separation of Concerns**

  * Allocation, billing, and orchestration are separated

* **Extensibility**

  * Easy to add new vehicle/slot types

* **Scalability**

  * Slot allocation logic can be optimized further

* **Clean Code Practices**

  * Modular structure
  * Reusable components

---

## 🚀 Future Enhancements

* Multi-floor parking support
* Priority Queue for faster nearest-slot lookup
* Concurrency handling for multiple gates
* Reservation system
* Dynamic pricing (peak hours)

---

## ▶️ How to Run

1. Clone the repository
2. Navigate to project directory
3. Compile:

   ```
   javac Main.java
   ```
4. Run:

   ```
   java Main
   ```

---

## 🧪 Sample Flow

1. Vehicle enters → slot assigned
2. Ticket generated
3. Vehicle exits → bill calculated
4. Slot becomes available again

---

## 💡 Key Takeaway

> This system demonstrates how to design a scalable, real-world parking solution using clean architecture, modular design, and efficient allocation strategies.

---

## 👨‍💻 Author

Built as part of Low-Level Design practice for system design interviews.
