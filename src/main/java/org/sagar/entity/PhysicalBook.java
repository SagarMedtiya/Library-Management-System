package org.sagar.entity;

import java.time.LocalDate;

public class PhysicalBook extends Book{
    private int availableCopies;
    private LocalDate borrowDate;
    public PhysicalBook(String title, String author, String isbn, int copies){
        super(title, author, isbn);
        this.availableCopies = copies;
    }

    @Override
    public String getType(){
        return "PHYSICAL";
    }
    public boolean isAvailable(){
        return availableCopies > 0;
    }
    public void borrowCopy(){
        availableCopies--;
    }
    public void returnCopy(){
        availableCopies++;
    }
    public void setBorrowedDate(LocalDate borrowedDate){
        this.borrowDate = borrowedDate;
    }
}
