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
