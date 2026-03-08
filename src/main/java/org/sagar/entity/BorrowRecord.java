package org.sagar.entity;

import java.time.LocalDate;

public class BorrowRecord {
    private Book book;
    private LocalDate borrowDate;
    private LocalDate returnDate;
    private Patron patron;
    private LocalDate dueDate;

    public BorrowRecord(Book book, Patron patron){
        this.book = book;
        this.patron = patron;
        this.borrowDate = LocalDate.now();
        this.dueDate = borrowDate.plusDays(7);
    }
    public void markReturned(){
        this.returnDate = LocalDate.now();
    }
    public LocalDate getDueDate() {
        return dueDate;
    }

    public LocalDate getBorrowDate(){
        return borrowDate;
    }
    public Book getBook(){ return book;}
    public LocalDate getReturnDate(){ return returnDate;}
}
