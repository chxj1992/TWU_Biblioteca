package com.twu.biblioteca.dao;

import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;


public class BookDaoTest {

    private BookDao bookDao;

    @Before
    public void before() throws Exception {
        bookDao = new BookDao();
    }

    @Test
    public void size_of_available_book_list_should_be_4 () {
        Integer sizeOfAvailableBookList = bookDao.getAvailableList().size();

        assertThat( sizeOfAvailableBookList).isEqualTo(4);
    }

    @Test
    public void checkout_available_book_should_return_true() {
        assertThat(bookDao.checkoutItem("Lord of the Rings")).isTrue();
    }

    @Test
    public void checkout_book_not_exist_should_return_false() {
        assertThat(bookDao.checkoutItem("Lord of the Chains")).isFalse();
    }

    @Test
    public void checkout_book_not_in_stock_should_return_false() {
        assertThat(bookDao.checkoutItem("A Tale of Two Cities")).isFalse();
    }

    @Test
    public void return_book_successful_should_return_true() {
        assertThat(bookDao.returnItem("Lord of the Rings")).isTrue();
    }

    @Test
    public void return_book_not_belong_to_the_library_should_return_false() {
        assertThat(bookDao.returnItem("Head First Java")).isFalse();
    }

}
