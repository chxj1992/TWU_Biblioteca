package com.twu.biblioteca.dao;

import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Lists;
import com.twu.biblioteca.model.Movie;

import java.util.List;

public class MovieDao extends ItemDao {

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

    public List<Movie> getList() {
        return movieList;
    }

    @Override
    public List getAvailableList() {
        return FluentIterable.from(movieList).filter(new Predicate<Movie>(){
            @Override
            public boolean apply(Movie movie) {
                return movie.isAvailable();
            }
        }).toList();
    }


    @Override
    public boolean checkoutItem(String itemName) {

        for ( Movie movie : movieList) {
            if (movie.getMovieName().equals(itemName) && movie.isAvailable()) {
                movie.setMovieNumber(movie.getMovieNumber() - 1);
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean returnItem(String itemName) {

        for (Movie movie : movieList) {
            if (movie.getMovieName().equals(itemName) ) {
                movie.setMovieNumber(movie.getMovieNumber()+1);
                return true;
            }
        }

        return false;
    }

}
