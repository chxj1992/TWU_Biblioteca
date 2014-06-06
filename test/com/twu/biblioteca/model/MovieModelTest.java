package com.twu.biblioteca.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class MovieModelTest {

    private MovieModel movieModel;

    @Before
    public void setUp() throws Exception {
        movieModel = new MovieModel("The Shawshank Redemption", "Frank A. Darabont", 1994, 9, 2);
    }

    @Test
    public void movie_name_is_right() {
        String expectName = "The Shawshank Redemption";

        assertEquals(movieModel.getMovieName(), expectName);
    }

    @Test
    public void number_of_movie_should_be_2() {
        assertEquals((Object) movieModel.getMovieNumber(), 2);
    }

    @Test
    public void rating_of_movie_should_be_9() {
        assertEquals(movieModel.getMovieRating(), "9");
    }

    @Test
    public void rating_of_unrated_movie_should_be_unrated() {

        movieModel.setMovieRating(0);
        assertEquals(movieModel.getMovieRating(), "unrated");
    }

}
