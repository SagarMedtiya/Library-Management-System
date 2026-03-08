package org.sagar;

import org.sagar.entity.Book;
import org.sagar.entity.EBook;
import org.sagar.entity.PhysicalBook;

public class BookFactory {
    public static Book createBook(String type, String title, String author, String isbn){
        switch(type){
            case "PHYSICAL":
                return new PhysicalBook(title, author, isbn, 5);
            case "EBOOK":
                return new EBook(title, author, isbn);
            default:
                throw new IllegalArgumentException("Invalid book type");
        }
    }
}
