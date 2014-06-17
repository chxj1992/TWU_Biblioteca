package com.twu.biblioteca.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class BookTest {

    private Book book;

    @Before
    public void setUp() throws Exception {
        book = new Book("Gone with the Wind", "Margaret Mitchell", 1936, 2);
    }

    @Test
    public void book_name_is_right() {
        String expectName = "Gone with the Wind";

        assertEquals(book.getBookName(), expectName);
    }

    @Test
    public void number_of_book_should_be_2() {
        assertEquals((Object) book.getBookNumber(), 2);
    }

}
