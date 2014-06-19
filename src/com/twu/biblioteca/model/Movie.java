package com.twu.biblioteca.model;

public class Movie extends Item {

    private String name;
    private String director;
    private Integer year;
    private Integer movieRating;
    private Integer number;

    public Movie(String name, String director, Integer year, Integer movieRating, Integer number) {
        this.name = name;
        this.director = director;
        this.year = year;
        this.movieRating = movieRating;
        this.number = number;
    }


    public String getName() {
        return name;
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

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setMovieRating(Integer movieRating) {
        this.movieRating = movieRating;
    }

    @Override
    public String toString() {
        return getName()+" | "+ getDirector()+" | "+ getYear()+" | "+ getMovieRating() + "\n";
    }

}
