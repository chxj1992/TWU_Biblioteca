package com.twu.biblioteca.service;

import com.google.common.collect.Lists;
import com.twu.biblioteca.dao.BookDao;
import com.twu.biblioteca.dao.MovieDao;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Movie;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;

public class MovieServiceTest {

    private MovieService movieService;
    private MovieDao movieDao;

    @Before
    public void before() throws Exception {
        movieDao = mock(MovieDao.class);
        movieService = new MovieService();
        movieService.setItemDao(movieDao);
    }

    @Test
    public void should_get_the_right_service_name() {
        String serviceName = movieService.getName();

        assertThat(serviceName).isEqualTo("movie");
    }

    @Test
    public void should_return_right_movie_list() {
        List<Movie> movies = Lists.newArrayList( new Movie("The Shawshank Redemption", "Frank A. Darabont", 1994, 9, 2));
        given(movieDao.getAvailableList()).willReturn(movies);

        String listInfo = movieService.list();

        assertThat(listInfo).isEqualTo("Available movie list:\n" +
                "The Shawshank Redemption | Frank A. Darabont | 1994 | 9\n");
    }

    @Test
    public void should_return_success_info_when_checkout_success() {
        given(movieDao.checkoutItem(anyString())).willReturn(true);

        String checkoutInfo = movieService.checkoutItem("");

        assertThat(checkoutInfo).isEqualTo("Thank you! Enjoy the movie.\n");
    }

    @Test
    public void should_return_fail_info_when_checkout_fail() {
        given(movieDao.checkoutItem(anyString())).willReturn(false);

        String checkoutInfo = movieService.checkoutItem("");

        assertThat(checkoutInfo).isEqualTo("That movie is not available.\n");
    }


    @Test
    public void should_return_success_info_when_return_success() {
        given(movieDao.returnItem(anyString())).willReturn(true);

        String checkoutInfo = movieService.returnItem("");

        assertThat(checkoutInfo).isEqualTo("Thank you for returning the movie.\n");
    }

    @Test
    public void should_return_fail_info_when_return_fail() {
        given(movieDao.returnItem(anyString())).willReturn(false);

        String checkoutInfo = movieService.returnItem("");

        assertThat(checkoutInfo).isEqualTo("That is not a valid movie to return.\n");
    }

}
