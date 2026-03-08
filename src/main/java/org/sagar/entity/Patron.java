package org.sagar.entity;

import java.util.*;

public class Patron {
    private final String id;
    private String name;

    //currently borrowed book
    private Set<Book> borrowedBooks = new HashSet<>();

    //Full borrow history
    private List<BorrowRecord> borrowHistory = new ArrayList<>();

    public Patron(String id, String name) {
        this.id = id;
        this.name = name;
    }
    public void addBorrowRecord(BorrowRecord record){
        borrowHistory.add(record);
    }
    public List<BorrowRecord> getBorrowHistory(){
        return Collections.unmodifiableList(borrowHistory);
    }
    public String getId() {
        return id;
    }

    public void borrowBook(Book book, BorrowRecord record) {
        if(borrowedBooks.contains(book)){
            throw new IllegalStateException("Book already borrowed");
        }
        borrowedBooks.add(book);

        borrowHistory.add(record);
    }

    public void returnBook(Book book) {
        if(!borrowedBooks.contains(book)){
            throw new IllegalStateException("Book not borrowed");
        }
        borrowedBooks.remove(book);
        //update return date in borrow history
        for(BorrowRecord record : borrowHistory){
            if(record.getBook().equals(book) && record.getReturnDate() == null){
                record.markReturned();
                break;
            }
        }
    }
    public Set<Book> getCurrentlyBorrowedBooks() {
        return Collections.unmodifiableSet(borrowedBooks);
    }
    public List<BorrowRecord> getBorrowedBooks() {
        return Collections.unmodifiableList(borrowHistory);
    }
}




























