# Library Management System

## 📌 Overview

This is a console-based **Library Management System** implemented in Java using Object-Oriented Programming principles, SOLID principles, and design patterns.

The system supports:

-   Book management

-   Patron management

-   Book checkout and return

-   Fine calculation using strategy pattern

-   Notification system using observer pattern

-   Borrow history tracking

# 🚀 Features

## 1️⃣ Book Management

# 

-   Abstract `Book` class
    
-   `PhysicalBook` implementation
    
-   BookFactory for object creation
    
-   Tracks available copies
    

## 2️⃣ Patron Management

# 

-   Add patrons
    
-   Track borrowed books
    
-   Maintain borrowing history
    

## 3️⃣ Lending Process

# 

-   Checkout books
    
-   Return books
    
-   Prevent duplicate borrow
    
-   Track due dates
    
-   Calculate late fines
    

## 4️⃣ Fine Calculation

# 

-   Strategy Pattern for flexible fine policies
    
-   Example: `StandardFineStrategy`
    
-   Easily pluggable alternative strategies
    

## 5️⃣ Notifications

# 

-   Observer Pattern implementation
    
-   EmailNotifier example
    
-   Automatically notifies on checkout and return
  
# 🏗️ Design Patterns Used

### 1️⃣ Factory Pattern

`BookFactory` creates different types of books.

### 2️⃣ Strategy Pattern

`FineStrategy` allows dynamic fine calculation rules.

### 3️⃣ Observer Pattern

`LibraryObserver` notifies users about transactions.

* * *

# 🧠 SOLID Principles Applied

### ✅ Single Responsibility

-   `Book` → metadata
    
-   `BorrowRecord` → transaction details
    
-   `LendingService` → business logic
    

### ✅ Open/Closed

-   Add new fine strategies without modifying existing code
    

### ✅ Liskov Substitution

-   `PhysicalBook` extends `Book` properly
    

### ✅ Interface Segregation

-   FineStrategy and LibraryObserver are small focused interfaces
    

### ✅ Dependency Inversion

-   `LendingService` depends on `FineStrategy` abstraction

# Class Diagram (UML Representation)

                `+-------------------+
                |      Book         |
                |-------------------|
                | - id              |
                | - title           |
                | - author          |
                | - isbn            |
                | - available       |
                |-------------------|
                | + getType()       |
                +-------------------+
                          ^
                          |
                          |
                +-------------------+
                |  PhysicalBook     |
                |-------------------|
                | - availableCopies |
                |-------------------|
                | + borrowCopy()    |
                | + returnCopy()    |
                +-------------------+

                +-------------------+
                |     Patron        |
                |-------------------|
                | - borrowedBooks   |
                | - borrowHistory   |
                |-------------------|
                | + borrowBook()    |
                | + returnBook()    |
                +-------------------+

                +-------------------+
                |   BorrowRecord    |
                |-------------------|
                | - book            |
                | - patron          |
                | - borrowDate      |
                | - dueDate         |
                | - returnDate      |
                +-------------------+

                +-------------------+
                |  LendingService   |
                |-------------------|
                | - fineStrategy    |
                | - observers       |
                |-------------------|
                | + checkout()      |
                | + returnBook()    |
                +-------------------+
                          |
                          v
                +-------------------+
                |  FineStrategy     |
                |-------------------|
                | + calculateFine() |
                +-------------------+
                          ^
                          |
                +-------------------+
                | StandardFineStrategy |
                +-------------------+

                +-------------------+
                | LibraryObserver   |
                |-------------------|
                | + update()        |
                +-------------------+
                          ^
                          |
                +-------------------+
                |   EmailNotifier   |
                +-------------------+
