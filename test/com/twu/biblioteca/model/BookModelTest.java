package com.twu.biblioteca.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class BookModelTest {

    private BookModel bookModel;

    @Before
    public void setUp() throws Exception {
        bookModel = new BookModel("Gone with the Wind", "Margaret Mitchell", 1936, 2);
    }

    @Test
    public void book_name_is_right() {
        String expectName = "Gone with the Wind";

        assertEquals(bookModel.getBookName(), expectName);
    }

    @Test
    public void number_of_book_should_be_2() {
        assertEquals((Object) bookModel.getBookNumber(), 2);
    }

}
