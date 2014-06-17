package com.twu.biblioteca.model;

public class Book {

    private String bookName;
    private String author;
    private Integer year;
    private Integer bookNumber;

    public Book(String bookName, String author, Integer year, Integer bookNumber) {
        this.bookName = bookName;
        this.author = author;
        this.year = year;
        this.bookNumber = bookNumber;
    }

    public Book(String bookName, String author, Integer year) {
        this.bookName = bookName;
        this.author = author;
        this.year = year;
        this.bookNumber = 1;
    }


    public String getBookName() {
        return bookName;
    }

    public Integer getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(Integer bookNumber) {
        this.bookNumber = bookNumber;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getYear() {
        return year;
    }

    @Override
    public String toString() {
        return getBookName()+" | "+ getAuthor()+" | "+ getYear();
    }

    public boolean isAvailable() {
        return !getBookNumber().equals(0);
    }
}
