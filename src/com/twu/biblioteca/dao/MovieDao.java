package com.twu.biblioteca.dao;

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

    @Override
    public List getList() {
        return movieList;
    }

}
