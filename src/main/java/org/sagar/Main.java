package org.sagar;

import org.sagar.entity.Book;
import org.sagar.entity.BorrowRecord;
import org.sagar.entity.Patron;
import org.sagar.entity.PhysicalBook;

public class Main {
    public static void main(String[] args) {
        Book book = BookFactory.createBook(
                "PHYSICAL",
                "Clean Code",

                "Robert Martin",
                "ISBN123"
        );

        //Create Patron
        Patron patron = new Patron("P1", "Sagar");
        //Strategy Pattern
        FineStrategy fineStrategy = new StandardFineStrategy();
        //Lending Service (Dependency Injection)
        LendingService lendingService = new LendingService(fineStrategy);
        //Observer (Notification System)
        LibraryObserver emailNotifier = new EmailNotifier();
        lendingService.addObserver(emailNotifier);

        BorrowRecord record = null;
        //BORROW
        if(book instanceof PhysicalBook physicalBook) {
            record = lendingService.checkout(physicalBook, patron);
        }

        System.out.println("Borrowing completed");

        //RETURN
        if(book instanceof PhysicalBook physicalBook) {
            lendingService.returnBook(physicalBook, patron, record);
        }

        System.out.println("Return completed.");
    }
}