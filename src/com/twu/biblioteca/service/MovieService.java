package com.twu.biblioteca.service;


import com.twu.biblioteca.dao.MovieDao;
import com.twu.biblioteca.model.Movie;

import java.util.List;
import java.util.Scanner;

public class MovieService extends StorageService{


    public MovieDao movieDao = new MovieDao();

    @Override
    public void list() {
        List<Movie> movieList = movieDao.getAvailableMovieList();
        System.out.println("Available book list:");

        for (Movie movie : movieList)
            System.out.println(movie.toString());

        System.out.println("Enter a number to select option:");
        System.out.println(" 1. Checkout Movie");
        System.out.println(" 2. Return Movie");

        String input = new Scanner(System.in).nextLine();
        processInput(input);

    }

    @Override
    public void checkout() {
        System.out.println("Input the MOVIE NAME to checkout:");
        String input = new Scanner(System.in).nextLine();

        if ( movieDao.checkoutMovie(input) )
            System.out.println("Thank you! Enjoy the movie.\n");
        else
            System.out.println("That movie is not available.\n");
    }

    @Override
    public void returns() {
        System.out.println("Input the MOVIE NAME to return:");
        String input = new Scanner(System.in).nextLine();

        if ( movieDao.returnMovie(input) )
            System.out.println("Thank you for returning the movie.\n");
        else
            System.out.println("That is not a valid movie to return.\n");
    }


}
