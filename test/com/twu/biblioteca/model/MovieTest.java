package com.twu.biblioteca.model;

import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;


public class MovieTest {

    private Movie movie;

    @Before
    public void before() throws Exception {
        movie = new Movie("The Shawshank Redemption", "Frank A. Darabont", 1994, 9, 2);
    }

    @Test
    public void movie_name_should_be_right() {
        String expectName = "The Shawshank Redemption";

        assertThat(movie.getName()).isEqualTo(expectName);
    }

    @Test
    public void number_of_movie_should_be_2() {
        assertThat(movie.getNumber()).isEqualTo(2);
    }

    @Test
    public void rating_of_movie_should_be_9() {
        assertThat(movie.getMovieRating()).isEqualTo("9");
    }

    @Test
    public void rating_of_unrated_movie_should_be_unrated() {
        movie.setMovieRating(0);
        assertThat(movie.getMovieRating()).isEqualTo("unrated");
    }

}
