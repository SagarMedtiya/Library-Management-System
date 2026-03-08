package org.sagar.entity;

import java.util.Objects;
import java.util.UUID;

public abstract class Book {
    private final String id;
    private String title;
    private String author;
    private String isbn;
    private boolean available;
    public Book(String title, String author, String isbn) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.available = true;
    }

    public abstract String getType();

    public String getIsbn() {
        return isbn;
    }
    public String getTitle(){
        return title;
    }
    public boolean isAvailable(){
        return available;
    }

    public void setAvailable(boolean available){
        this.available = available;
    }


    public void updateBook(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.available = false;
    }
}
