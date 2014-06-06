package com.twu.biblioteca.dao;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.twu.biblioteca.model.MovieModel;

import java.util.List;

public class MovieDao {

    private List<MovieModel> movieList;

    public MovieDao() {
        movieList = Lists.newArrayList(
                new MovieModel("The Shawshank Redemption", "Frank A. Darabont", 1994, 9, 2),
                new MovieModel("Léon", "Luc Besson", 1994, 8, 3),
                new MovieModel("Forrest Gump", "Robert Zemeckis", 1994, 9, 2),
                new MovieModel("Inception", "Christopher Nolan", 2010, 0, 1),
                new MovieModel("3 Idiots", "Raju Hirani", 2009, 9, 0)
        );
    }

    public List<MovieModel> getMovieList() {
        return movieList;
    }

    public List<MovieModel> getAvailableMovieList() {

        return Lists.newArrayList(Collections2.filter(movieList, new Predicate<MovieModel>(){
            @Override
            public boolean apply(MovieModel movieModel) {
                if( movieModel.getMovieNumber().equals(0) )
                    return false;
                return true;
            }
        }));
    }

    public boolean checkoutMovie(String movieName) {

        for ( MovieModel movie : movieList) {
            if (movie.getMovieName().equals(movieName) && !movie.getMovieNumber().equals(0) ) {
                movie.setMovieNumber(movie.getMovieNumber() - 1);
                return true;
            }
        }

        return false;
    }

    public boolean returnMovie(String movieName) {

        for (MovieModel movie : movieList) {
            if (movie.getMovieName().equals(movieName) ) {
                movie.setMovieNumber(movie.getMovieNumber()+1);
                return true;
            }
        }

        return false;
    }

}
