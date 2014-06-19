package com.twu.biblioteca.dao;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class BookDaoTest {

    private BookDao bookDao;

    @Before
    public void setUp() throws Exception {
        bookDao = new BookDao();
    }

    @Test
    public void size_of_book_list_should_be_5 () {
        Integer sizeOfBookList = bookDao.getList().size();

        assertEquals((Object) sizeOfBookList, 5);
    }

    @Test
    public void size_of_available_book_list_should_be_4 () {
        Integer sizeOfAvailableBookList = bookDao.getAvailableList().size();

        assertEquals((Object) sizeOfAvailableBookList, 4);
    }

    @Test
    public void checkout_book_successful() {
        assertTrue(bookDao.checkoutItem("Lord of the Rings"));
    }

    @Test
    public void checkout_book_not_exist() {
        assertFalse(bookDao.checkoutItem("Lord of the Chains"));
    }

    @Test
    public void checkout_book_not_in_stock() {
        assertFalse(bookDao.checkoutItem("A Tale of Two Cities"));
    }

    @Test
    public void return_book_successful() {
        assertTrue(bookDao.returnItem("Lord of the Rings"));
    }

    @Test
    public void return_book_not_belong_to_the_library() {
        assertFalse(bookDao.returnItem("Head First Java"));
    }

}
