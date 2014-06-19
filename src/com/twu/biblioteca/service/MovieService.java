package com.twu.biblioteca.service;


import com.twu.biblioteca.dao.MovieDao;
import com.twu.biblioteca.model.Movie;

import java.util.List;

public class MovieService extends StorageService{

    public MovieDao movieDao = new MovieDao();

    @Override
    public void list() {
        List<Movie> movieList = movieDao.getAvailableMovieList();
        System.out.println("Available movie list:");

        for (Movie movie : movieList)
            System.out.println(movie.toString());

        System.out.println("Enter a number to select option:");
        System.out.println(" 1. Checkout Movie");
        System.out.println(" 2. Return Movie");
    }

    @Override
    public void processServiceInput(String option) {
        processInput(option, "MOVIE");
    }

    @Override
    public void checkout(String input) {
        if ( movieDao.checkoutMovie(input) )
            System.out.println("Thank you! Enjoy the movie.\n");
        else
            System.out.println("That movie is not available.\n");
    }

    @Override
    public void returns(String input) {
        if ( movieDao.returnMovie(input) )
            System.out.println("Thank you for returning the movie.\n");
        else
            System.out.println("That is not a valid movie to return.\n");
    }

}
