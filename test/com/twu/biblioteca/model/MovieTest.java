package com.twu.biblioteca.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class MovieTest {

    private Movie movie;

    @Before
    public void setUp() throws Exception {
        movie = new Movie("The Shawshank Redemption", "Frank A. Darabont", 1994, 9, 2);
    }

    @Test
    public void movie_name_is_right() {
        String expectName = "The Shawshank Redemption";

        assertEquals(movie.getMovieName(), expectName);
    }

    @Test
    public void number_of_movie_should_be_2() {
        assertEquals((Object) movie.getMovieNumber(), 2);
    }

    @Test
    public void rating_of_movie_should_be_9() {
        assertEquals(movie.getMovieRating(), "9");
    }

    @Test
    public void rating_of_unrated_movie_should_be_unrated() {

        movie.setMovieRating(0);
        assertEquals(movie.getMovieRating(), "unrated");
    }

}
