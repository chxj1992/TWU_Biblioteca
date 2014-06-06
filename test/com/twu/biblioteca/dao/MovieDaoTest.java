package com.twu.biblioteca.dao;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class MovieDaoTest {

    private MovieDao movieDao;

    @Before
    public void setUp() throws Exception {
        movieDao = new MovieDao();
    }

    @Test
    public void size_of_movie_list_should_be_5 () {
        Integer sizeOfMovieList = movieDao.getMovieList().size();

        assertEquals((Object) sizeOfMovieList, 5);
    }

    @Test
    public void size_of_available_movie_list_should_be_4 () {
        Integer sizeOfAvailableMovieList = movieDao.getAvailableMovieList().size();

        assertEquals((Object) sizeOfAvailableMovieList, 4);
    }

    @Test
    public void checkout_movie_successful() {
        assertTrue(movieDao.checkoutMovie("The Shawshank Redemption"));
    }

    @Test
    public void checkout_movie_not_exist() {
        assertFalse(movieDao.checkoutMovie("The Tom Redemption"));
    }

    @Test
    public void checkout_movie_not_in_stock() {
        assertFalse(movieDao.checkoutMovie("3 Idiots"));
    }

    @Test
    public void return_movie_successful() {
        assertTrue(movieDao.returnMovie("3 Idiots"));
    }

    @Test
    public void return_movie_not_belong_to_the_library() {
        assertFalse(movieDao.returnMovie("4 Idiots"));
    }

}
