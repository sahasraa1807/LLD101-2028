# 🛗 Elevator System (LLD)

## 📌 Overview

This project implements a **multi-elevator system** optimized for:

* ⏱️ Minimum wait time
* ⚡ Reduced energy consumption

The system uses **direction-based scheduling and request batching** to ensure efficient elevator movement.

---

## 🎯 Features

* Multiple elevators support
* Handles floor requests dynamically
* Direction-based optimization
* Nearest elevator allocation
* Efficient request batching

---

## 🧠 Key Optimization Techniques

### 🔹 Direction-Based Scheduling

* Elevator continues in the same direction
* Avoids unnecessary direction changes

---

### 🔹 Request Batching

* Groups requests in same direction
* Reduces travel time and energy usage

---

### 🔹 Smart Elevator Selection

* Assigns closest elevator
* Minimizes waiting time

---

## 🏗️ System Design

### 🔹 Core Components

* **Elevator** → Handles movement and requests
* **Scheduler** → Chooses best elevator
* **Controller** → Manages system flow
* **Request** → Represents user input

---

## 📁 Project Structure

```
elevator-system/
│
├── Main.java
├── enums/
├── models/
├── services/
```

---

## 🔌 APIs

```
requestElevator(floor)

step()
```

---

## 🚀 How to Run

1. Navigate to project folder:

   ```
   cd elevator-system
   ```

2. Compile:

   ```
   javac -d . Main.java models/*.java enums/*.java services/*.java
   ```

3. Run:

   ```
   java Main
   ```

---

## 🧪 Sample Output

```
Elevator 0 at floor 3
Elevator 1 at floor 5
...
```

---

## ⚠️ Edge Cases Handled

* Multiple simultaneous requests
* Direction switching logic
* Idle elevator handling

---

## 🔮 Future Enhancements

* 🚦 Direction-aware smart scheduler
* 🧠 AI-based traffic prediction
* 🏢 Multi-building support
* 🔄 Concurrency handling
* 📊 Analytics dashboard

---

## 💡 Key Takeaway

> This system demonstrates how directional scheduling and batching significantly improve elevator efficiency and reduce energy consumption.

---

## 👨‍💻 Author

Built as part of Low-Level Design (LLD) practice for system design interviews.
