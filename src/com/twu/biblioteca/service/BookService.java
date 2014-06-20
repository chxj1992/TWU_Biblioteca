package com.twu.biblioteca.service;

import com.twu.biblioteca.dao.BookDao;
import com.twu.biblioteca.dao.ItemDao;

public class BookService extends ItemService {

    public String name ="book";


    public ItemDao itemDao = new BookDao();


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
