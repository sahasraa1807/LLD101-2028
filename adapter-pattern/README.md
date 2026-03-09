# Adapter Pattern — Payment Gateway Refactoring

## Problem Statement (PS)

The current payment system in the project directly interacts with two different SDKs:

* `FastPayClient`
* `SafeCashClient`

The `OrderService` class manages these providers using a provider string and contains glue logic to handle their different APIs.

### Problems with the Existing Design

1. **Tight Coupling**

   * `OrderService` depends directly on concrete SDK classes.

2. **Provider Switching Logic**

   * The system uses provider strings to select payment logic.

3. **Different APIs**

   * Each SDK has different method signatures.

4. **Poor Extensibility**

   * Adding a new payment provider would require modifying `OrderService`.

---

## Solution (SOL)

We refactored the design using the **Adapter Design Pattern**.

The Adapter pattern allows incompatible interfaces to work together by converting the interface of a class into another interface that the client expects.

### Refactored Architecture

`OrderService` now depends only on the `PaymentGateway` interface.

Adapters translate calls from the system to the respective SDKs.

```
OrderService
     ↓
PaymentGateway (interface)
     ↓
Adapters
 ↓           ↓
FastPayAdapter   SafeCashAdapter
 ↓                 ↓
FastPayClient   SafeCashClient
```

---

## Components

### 1. PaymentGateway (Target Interface)

Defines a standard method used by the system.

```
String charge(String customerId, int amountCents)
```

---

### 2. FastPayAdapter

Adapter that wraps `FastPayClient`.

Converts:

```
charge(customerId, amount)
```

into

```
FastPayClient.payNow(...)
```

---

### 3. SafeCashAdapter

Adapter that wraps `SafeCashClient`.

Converts:

```
charge(customerId, amount)
```

into

```
SafeCashClient.createPayment(...)
```

and confirms the transaction.

---

### 4. OrderService

Client class responsible for processing payments.

Instead of depending on specific providers, it now works with the `PaymentGateway` interface.

---

### 5. App

Registers adapters in a `Map<String, PaymentGateway>` and demonstrates payment processing for multiple providers.

---

## Files in the Project

| File                   | Purpose                      |
| ---------------------- | ---------------------------- |
| `PaymentGateway.java`  | Interface used by the system |
| `FastPayAdapter.java`  | Adapter for FastPay SDK      |
| `SafeCashAdapter.java` | Adapter for SafeCash SDK     |
| `FastPayClient.java`   | External SDK                 |
| `SafeCashClient.java`  | External SDK                 |
| `SafeCashPayment.java` | SDK payment object           |
| `OrderService.java`    | Payment service              |
| `App.java`             | Demo program                 |

---

## Build & Run

From inside the `src` folder:

```
javac com/example/payments/*.java
java com.example.payments.App
```

---

## Expected Output

Example output:

```
FP#cust-1:1299
SC#pay(cust-2,1299)
```

Each provider returns its own transaction ID.

---

## Design Pattern Used

**Adapter Pattern**

The Adapter pattern allows classes with incompatible interfaces to work together by wrapping them in an adapter that exposes the expected interface.
