# 🎬 Movie Ticket Booking System (LLD)

## 📌 Overview

This project implements a **Movie Ticket Booking System** using Java, designed with clean architecture and object-oriented principles.
It simulates how real-world platforms like ticket booking apps handle seat selection, booking, and payment.

---

## 🎯 Features

* 🎥 Browse movies and shows
* 💺 View and select seats
* 🔒 Seat locking mechanism to prevent double booking
* 🎟️ Booking creation and confirmation
* 💰 Payment simulation
* 📊 Modular and scalable design

---

## 🧠 Key Concepts Implemented

### 🔹 Seat Locking (Core Feature)

To avoid multiple users booking the same seat:

* Seats are **locked before booking**
* If booking succeeds → seats are confirmed
* If booking fails → seats can be released

---

### 🔹 Booking Flow

1. User selects a show
2. User selects seats
3. System locks seats
4. Payment is processed
5. Booking is confirmed
6. Seats are marked as booked

---

### 🔹 Separation of Concerns

* Models → represent entities
* Services → handle business logic
* Enums → define constants

---

## 🏗️ System Design

### 🔹 Core Entities

* **Movie**
* **Theater**
* **Screen**
* **Seat**
* **Show**
* **User**
* **Booking**

---

### 🔹 Services

* `MovieService`
* `ShowService`
* `SeatLockService`
* `BookingService`
* `PaymentService`

---

## 📁 Project Structure

```id="kl2p9z"
moviebooking/
│
├── Main.java
│
├── enums/
│   ├── SeatType.java
│   ├── BookingStatus.java
│
├── models/
│   ├── Movie.java
│   ├── Theater.java
│   ├── Screen.java
│   ├── Seat.java
│   ├── Show.java
│   ├── User.java
│   ├── Booking.java
│
├── services/
│   ├── MovieService.java
│   ├── ShowService.java
│   ├── SeatLockService.java
│   ├── BookingService.java
│   ├── PaymentService.java
```

---

## 🔌 APIs (Conceptual)

```id="2qapvl"
getMovies()

getShows(movieId)

getAvailableSeats(showId)

createBooking(user, show, seats)

makePayment(amount)

confirmBooking(booking)
```

---

## 💰 Pricing

* Based on seat type (Regular / Premium)
* Can be extended for dynamic pricing

---

## 🚀 How to Run

1. Navigate to project directory:

   ```
   cd ticketBooking-design
   ```

2. Compile all files:

   ```
   javac -d . Main.java models/*.java enums/*.java services/*.java
   ```

3. Run the program:

   ```
   java Main
   ```

---

## 🧪 Sample Output

```
Booking Confirmed!
```

---

## ⚠️ Edge Cases Handled

* Prevents double booking using seat locking
* Handles unavailable seats
* Ensures booking consistency

---

## 🔮 Future Enhancements

* ⏱️ Seat lock timeout (auto-release)
* 🔄 Concurrency handling (multi-user booking)
* 🏢 Multi-theater & multi-city support
* 💳 Real payment gateway integration
* 📊 Admin dashboard

---

## 💡 Design Principles Used

* Separation of Concerns
* Modular Design
* Scalability
* Maintainability

---

## 🎯 Key Takeaway

> This project demonstrates how real-world booking systems manage seat allocation, prevent race conditions, and maintain consistency using structured design.

---

## 👨‍💻 Author

Built as part of Low-Level Design (LLD) practice for system design interviews.
