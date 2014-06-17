package com.twu.biblioteca.dao;

import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Lists;
import com.twu.biblioteca.model.Movie;

import java.util.List;

public class MovieDao {

    private List<Movie> movieList;

    public MovieDao() {
        movieList = Lists.newArrayList(
                new Movie("The Shawshank Redemption", "Frank A. Darabont", 1994, 9, 2),
                new Movie("Léon", "Luc Besson", 1994, 8, 3),
                new Movie("Forrest Gump", "Robert Zemeckis", 1994, 9, 2),
                new Movie("Inception", "Christopher Nolan", 2010, 0, 1),
                new Movie("3 Idiots", "Raju Hirani", 2009, 9, 0)
        );
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public List<Movie> getAvailableMovieList() {

        return FluentIterable.from(movieList).filter(new Predicate<Movie>(){
            @Override
            public boolean apply(Movie movie) {
                return movie.isAvailable();
            }
        }).toList();
    }

    public boolean checkoutMovie(String movieName) {

        for ( Movie movie : movieList) {
            if (movie.getMovieName().equals(movieName) && movie.isAvailable()) {
                movie.setMovieNumber(movie.getMovieNumber() - 1);
                return true;
            }
        }

        return false;
    }

    public boolean returnMovie(String movieName) {

        for (Movie movie : movieList) {
            if (movie.getMovieName().equals(movieName) ) {
                movie.setMovieNumber(movie.getMovieNumber()+1);
                return true;
            }
        }

        return false;
    }

}
