# Proxy Pattern — Secure & Lazy-Load Reports

## Problem Statement (PS)

The **CampusVault CLI tool** allows users to open internal reports.
In the starter code, the `ReportViewer` directly interacts with `ReportFile`, which causes several design problems.

### Issues in the Original Design

1. **No Access Control**

   * Any user can open any report, even restricted ones.

2. **No Lazy Loading**

   * Reports are loaded from disk every time they are opened, even if they might not be needed.

3. **No Caching**

   * The same report can be loaded repeatedly, wasting resources.

4. **Tight Coupling**

   * The client depends directly on a concrete implementation (`ReportFile`).

---

## Solution (SOL)

We refactored the design using the **Proxy Design Pattern**.

A **Proxy** acts as a middle layer between the client and the real object.
It controls access and manages expensive operations.

### Responsibilities of the Proxy

The `ReportProxy` performs three important tasks:

1. **Access Control**

   * Checks whether the user has permission to access the report.

2. **Lazy Loading**

   * The real report (`RealReport`) is created only when the report is actually viewed.

3. **Caching**

   * Once the report is loaded, the same instance is reused for subsequent views through the same proxy.

---

## Architecture

Client interacts with the proxy instead of the real report.

```
User
  ↓
ReportViewer
  ↓
Report (interface)
  ↓
ReportProxy
   ├─ Access Control
   ├─ Lazy Loading
   └─ Caching
        ↓
RealReport
   └─ Expensive disk loading
```

---

## Key Components

### 1. Report (Interface)

Defines the common method:

```
void display(User user)
```

Both `RealReport` and `ReportProxy` implement this interface.

---

### 2. RealReport (Real Subject)

Responsible for:

* Expensive disk loading
* Displaying report content

```
[disk] loading report R-303 ...
```

---

### 3. ReportProxy (Proxy)

Adds additional logic before delegating to `RealReport`.

Responsibilities:

* Access control
* Lazy creation of the real report
* Reusing the loaded report

Example console output:

```
[proxy] checking access for Kshitij
ACCESS GRANTED
[proxy] creating real report...
[disk] loading report R-303 ...
```

Second access:

```
[proxy] using cached report...
```

---

### 4. AccessControl

Contains logic to check permissions based on user roles.

Roles supported:

* STUDENT
* FACULTY
* ADMIN

Report classifications:

* PUBLIC
* FACULTY
* ADMIN

---

### 5. ReportViewer (Client)

The client class that opens reports.
It depends only on the `Report` abstraction.

---

## Files Modified / Added

| File                 | Purpose                                                  |
| -------------------- | -------------------------------------------------------- |
| `Report.java`        | Interface for reports                                    |
| `RealReport.java`    | Real subject that loads reports from disk                |
| `ReportProxy.java`   | Proxy handling access control, lazy loading, and caching |
| `ReportViewer.java`  | Client that interacts with the report abstraction        |
| `AccessControl.java` | Handles authorization logic                              |
| `User.java`          | Represents system users                                  |
| `App.java`           | Main demo application                                    |
| `QuickCheck.java`    | Simple verification program                              |

---

## Build & Run

From inside the `src` directory:

```
javac com/example/reports/*.java
java com.example.reports.App
```

Quick verification:

```
java com.example.reports.QuickCheck
```

---

## Expected Behavior

✔ Unauthorized users cannot view restricted reports
✔ Real reports are loaded only when needed (lazy loading)
✔ Disk loading happens only once per proxy instance
✔ Clients interact through the proxy instead of the real object

---

## Design Pattern Used

**Proxy Pattern**

The Proxy pattern provides a surrogate or placeholder for another object to control access to it.

Typical uses:

* Access control
* Lazy loading
* Logging
* Caching
