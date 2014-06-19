package com.twu.biblioteca.service;

import com.google.common.collect.Lists;
import com.twu.biblioteca.dao.BookDao;
import com.twu.biblioteca.model.Book;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;

public class MovieServiceTest {

    private BookService bookService;
    private BookDao bookDao;

    @Before
    public void before() throws Exception {
        bookDao = mock(BookDao.class);
        bookService = new BookService();
        bookService.setItemDao(bookDao);
    }

    @Test
    public void should_get_the_right_service_name() {
        String serviceName = bookService.getName();

        assertThat(serviceName).isEqualTo("book");
    }

    @Test
    public void should_return_right_book_list() {
        List<Book> books = Lists.newArrayList(new Book("Lord of the Rings", "J.R.R.Tolkien", 1954, 3));
        given(bookDao.getAvailableList()).willReturn(books);

        String listInfo = bookService.list();

        assertThat(listInfo).isEqualTo("Available book list:\n" +
                "Lord of the Rings | J.R.R.Tolkien | 1954\n");
    }

    @Test
    public void should_return_success_info_when_checkout_success() {
        given(bookDao.checkoutItem(anyString())).willReturn(true);

        String checkoutInfo = bookService.checkoutItem("");

        assertThat(checkoutInfo).isEqualTo("Thank you! Enjoy the book.\n");
    }

    @Test
    public void should_return_fail_info_when_checkout_fail() {
        given(bookDao.checkoutItem(anyString())).willReturn(false);

        String checkoutInfo = bookService.checkoutItem("");

        assertThat(checkoutInfo).isEqualTo("That book is not available.\n");
    }


    @Test
    public void should_return_success_info_when_return_success() {
        given(bookDao.returnItem(anyString())).willReturn(true);

        String checkoutInfo = bookService.returnItem("");

        assertThat(checkoutInfo).isEqualTo("Thank you for returning the book.\n");
    }

    @Test
    public void should_return_fail_info_when_return_fail() {
        given(bookDao.returnItem(anyString())).willReturn(false);

        String checkoutInfo = bookService.returnItem("");

        assertThat(checkoutInfo).isEqualTo("That is not a valid book to return.\n");
    }

}
