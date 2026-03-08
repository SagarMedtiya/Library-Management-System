package org.sagar;

import org.sagar.entity.BorrowRecord;
import org.sagar.entity.Patron;
import org.sagar.entity.PhysicalBook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class LendingService {


    private FineStrategy fineStrategy;
    private List<LibraryObserver> observers = new ArrayList<>();

    public LendingService(FineStrategy fineStrategy) {
        this.fineStrategy = fineStrategy;
    }
    public void addObserver(LibraryObserver observer) {
        observers.add(observer);
    }
    private void notifyObservers(String message) {
        for(LibraryObserver observer: observers) {
            observer.update(message);
        }
    }
    public BorrowRecord checkout(PhysicalBook book, Patron patron){
        if(!book.isAvailable()){
            throw new RuntimeException("Book not available");
        }
        book.borrowCopy();

        BorrowRecord record = new BorrowRecord(book, patron);
        patron.borrowBook(book, record);
        notifyObservers("Book issued to "+ patron.getId());
        return record;
    }
    public void returnBook(PhysicalBook book, Patron patron, BorrowRecord record){
        book.returnCopy();
        patron.returnBook(book);
        record.markReturned();


        double fine =fineStrategy.calculateFine(record.getDueDate(), LocalDate.now());

        notifyObservers("Book returned by "+ patron.getId() + ", Fine: "+ fine);
    }
}
