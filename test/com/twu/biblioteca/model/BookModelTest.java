package com.twu.biblioteca.model;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class BookModelTest {

    private BookModel bookModel;

    @Before
    public void setUp() throws Exception {
        bookModel = new BookModel("Gone with the Wind", "Margaret Mitchell", 1936, 2);
    }

    @Test
    public void book_name_is_right() {
        String expectName = "Gone with the Wind";

        assertThat(bookModel.getBookName(), is(expectName));
    }

    @Test
    public void number_of_book_should_be_2() {

        assertThat(bookModel.getBookNumber(), is(2));
    }

}
