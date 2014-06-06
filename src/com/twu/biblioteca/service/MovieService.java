package com.twu.biblioteca.service;


import com.twu.biblioteca.dao.MovieDao;
import com.twu.biblioteca.model.MovieModel;

import java.util.List;
import java.util.Scanner;

public class MovieService {


    public static MovieDao movieDao = new MovieDao();

    public static void listMovies() {
        List<MovieModel> movieList = movieDao.getAvailableMovieList();
        System.out.println("Available book list:");

        for (MovieModel movie : movieList)
            System.out.println(movie.getMovieName()+" | "+ movie.getDirector()+" | "+movie.getYear()+" | "+movie.getMovieRating());

        System.out.println("Enter a number to select option:");
        System.out.println(" 1. Checkout Movie");
        System.out.println(" 2. Return Movie");

        String input = new Scanner(System.in).nextLine();
        processMovieInput(input);

    }

    private static void processMovieInput(String input) {

        int i;
        try {
            i = Integer.parseInt(input);
        } catch (Exception e) {
            System.out.println("Select a valid option!");
            return;
        }

        switch (i) {
            case 1:
                checkoutMovie();
                break;
            case 2:
                returnMovie();
                break;
            default:
                break;
        }
    }

    private static void checkoutMovie() {
        System.out.println("Input the MOVIE NAME to checkout:");
        String input = new Scanner(System.in).nextLine();

        if ( movieDao.checkoutMovie(input) )
            System.out.println("Thank you! Enjoy the movie.\n");
        else
            System.out.println("That movie is not available.\n");
    }

    private static void returnMovie() {
        System.out.println("Input the MOVIE NAME to return:");
        String input = new Scanner(System.in).nextLine();

        if ( movieDao.returnMovie(input) )
            System.out.println("Thank you for returning the movie.\n");
        else
            System.out.println("That is not a valid movie to return.\n");
    }


}
