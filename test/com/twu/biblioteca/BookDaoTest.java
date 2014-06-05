package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


public class BookDaoTest {

    private BookDao bookDao;

    @Before
    public void setUp() throws Exception {
        bookDao = new BookDao();
    }

    @Test
    public void size_of_book_list_should_be_5 () {
        Integer sizeOfBookList = bookDao.getBookList().size();

        assertThat(sizeOfBookList, is(5));
    }

    @Test
    public void size_of_available_book_list_should_be_4 () {
        Integer sizeOfAvailableBookList = bookDao.getAvailableBookList().size();

        assertThat(sizeOfAvailableBookList, is(4));
    }

    @Test
    public void checkout_book_successful() {
        assertTrue(bookDao.checkoutBook("Lord of the Rings"));
    }

    @Test
    public void checkout_book_not_exist() {
        assertFalse(bookDao.checkoutBook("Lord of the Chains"));
    }

    @Test
    public void checkout_book_not_in_stock() {
        assertFalse(bookDao.checkoutBook("A Tale of Two Cities"));
    }

    @Test
    public void return_book_successful() {
        assertTrue(bookDao.returnBook("Lord of the Rings"));
    }

    @Test
    public void return_book_not_belong_to_the_library() {
        assertFalse(bookDao.returnBook("Head First Java"));
    }

}
