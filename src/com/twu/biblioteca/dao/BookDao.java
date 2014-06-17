package com.twu.biblioteca.dao;

import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Lists;
import com.twu.biblioteca.model.Book;

import java.util.List;

public class BookDao {

    private List<Book> bookList;

    public BookDao() {
        bookList = Lists.newArrayList(
                new Book("Lord of the Rings", "J.R.R.Tolkien", 1954, 3),
                new Book("Jane Eyre", "Charlotte Brontë", 1847, 2),
                new Book("Gone with the Wind", "Margaret Mitchell", 1936, 2),
                new Book("Peter Pan", "James Barrie", 1904),
                new Book("A Tale of Two Cities", "Charles Dickens", 1859, 0)
        );
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public List<Book> getAvailableBookList() {

        return FluentIterable.from(bookList).filter(new Predicate<Book>(){
            @Override
            public boolean apply(Book book) {
                return book.isAvailable();
            }
        }).toList();
    }

    public boolean checkoutBook(String bookName) {

        for ( Book book : bookList ) {
            if (book.getBookName().equals(bookName) && book.isAvailable()) {
                book.setBookNumber(book.getBookNumber()-1);
                return true;
            }
        }

        return false;
    }

    public boolean returnBook(String bookName) {

        for ( Book book : bookList ) {
            if (book.getBookName().equals(bookName) ) {
                book.setBookNumber(book.getBookNumber()+1);
                return true;
            }
        }

        return false;
    }

}
