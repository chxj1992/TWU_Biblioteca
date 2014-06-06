package com.twu.biblioteca.model;

public class MovieModel {

    private String movieName;
    private String director;
    private Integer year;
    private Integer movieRating;
    private Integer movieNumber;

    public MovieModel(String movieName, String director, Integer year, Integer movieRating, Integer movieNumber) {
        this.movieName = movieName;
        this.director = director;
        this.year = year;
        this.movieRating = movieRating;
        this.movieNumber = movieNumber;
    }

    public MovieModel(String movieName, String director, Integer year, Integer movieRating) {
        this.movieName = movieName;
        this.director = director;
        this.year = year;
        this.movieRating = movieRating;
        this.movieNumber = 1;
    }

    public MovieModel(String movieName, String director, Integer year) {
        this.movieName = movieName;
        this.director = director;
        this.year = year;
        this.movieRating = 0;
        this.movieNumber = 1;
    }


    public String getMovieName() {
        return movieName;
    }

    public String getDirector() {
        return director;
    }

    public Integer getYear() {
        return year;
    }

    public String getMovieRating() {
        if( movieRating.equals(0) )
            return "unrated";

        return String.valueOf(movieRating);
    }

    public Integer getMovieNumber() {
        return movieNumber;
    }

    public void setMovieNumber(Integer movieNumber) {
        this.movieNumber = movieNumber;
    }

    public void setMovieRating(Integer movieRating) {
        this.movieRating = movieRating;
    }
}
