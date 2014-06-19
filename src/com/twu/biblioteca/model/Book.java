package com.twu.biblioteca.model;

public class Book extends Item {

    private String name;
    private String author;
    private Integer year;
    private Integer number;

    public Book(String name, String author, Integer year, Integer number) {
        this.name = name;
        this.author = author;
        this.year = year;
        this.number = number;
    }

    public Book(String name, String author, Integer year) {
        this.name = name;
        this.author = author;
        this.year = year;
        this.number = 1;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getYear() {
        return year;
    }

    @Override
    public Integer getNumber() {
        return number;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return getName()+" | "+ getAuthor()+" | "+ getYear() + "\n";
    }

}
