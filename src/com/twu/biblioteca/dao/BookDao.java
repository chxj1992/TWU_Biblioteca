package com.twu.biblioteca.dao;

import com.google.common.collect.Lists;
import com.twu.biblioteca.model.Book;

import java.util.List;

public class BookDao extends ItemDao {

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

    @Override
    public List<Book> getList() {
        return bookList;
    }

}
