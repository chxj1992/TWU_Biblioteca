package com.twu.biblioteca.dao;

import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class MovieDaoTest {

    private MovieDao movieDao;

    @Before
    public void before() throws Exception {
        movieDao = new MovieDao();
    }

    @Test
    public void size_of_available_movie_list_should_be_4 () {
        Integer sizeOfAvailableMovieList = movieDao.getAvailableList().size();

        assertThat(sizeOfAvailableMovieList).isEqualTo(4);
    }

    @Test
    public void checkout_available_movie_should_return_true() {
        assertThat(movieDao.checkoutItem("The Shawshank Redemption")).isTrue();
    }

    @Test
    public void checkout_movie_not_exist_should_return_false() {
        assertThat(movieDao.checkoutItem("The Tom Redemption")).isFalse();
    }

    @Test
    public void checkout_movie_not_in_stock_should_return_false() {
        assertThat(movieDao.checkoutItem("3 Idiots")).isFalse();
    }

    @Test
    public void return_movie_successful_should_return_true() {
        assertThat(movieDao.returnItem("3 Idiots")).isTrue();
    }

    @Test
    public void return_movie_not_belong_to_the_library_should_return_false() {
        assertThat(movieDao.returnItem("4 Idiots")).isFalse();
    }

}
