package com.twu.biblioteca.model;

import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;


public class BookTest {

    private Book book;

    @Before
    public void before() throws Exception {
        book = new Book("Gone with the Wind", "Margaret Mitchell", 1936, 2);
    }

    @Test
    public void book_name_should_be_right() {
        String expectName = "Gone with the Wind";

        assertThat(book.getName()).isEqualTo(expectName);
    }

    @Test
    public void number_of_book_should_be_2() {
        assertThat(book.getNumber()).isEqualTo(2);
    }

}
