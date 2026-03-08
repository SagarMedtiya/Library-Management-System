package org.sagar.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    private Map<String, Book> books = new HashMap<>();
    private Map<String, Patron> patrons = new HashMap<>();

    //Add Book
    public void addBook(Book book){
        books.put(book.getIsbn(), book);
    }
    //remove book
    public void removeBook(String isbn){
        books.remove(isbn);
    }
    //update book
    public void updateBook(String isbn, String title, String author, int year){
        Book book = books.get(isbn);
        if(book != null){
            book.updateBook(title, author, year);
        }
    }
    //search book
    public List<Book> searchByTitle(String title){
        List<Book> result = new ArrayList<>();
        for(Book book: books.values()){
            if(book.getTitle().equalsIgnoreCase(title)){
                result.add(book);
            }
        }
        return result;
    }

    public Book searchByISBN(String isbn){
        return books.get(isbn);
    }

}






















