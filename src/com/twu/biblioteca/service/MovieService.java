package com.twu.biblioteca.service;


import com.twu.biblioteca.dao.ItemDao;
import com.twu.biblioteca.dao.MovieDao;

public class MovieService extends ItemService {

    public String name ="movie";

    public ItemDao itemDao = new MovieDao();

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ItemDao getItemDao() {
        return itemDao;
    }

    public void setItemDao(ItemDao itemDao) {
        this.itemDao = itemDao;
    }

}
