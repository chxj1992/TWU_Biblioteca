package com.twu.biblioteca.dao;

import com.twu.biblioteca.model.Item;

import java.util.List;

public abstract class ItemDao {

    public abstract List<Item> getAvailableList();

    public abstract boolean checkoutItem(String itemName);

    public abstract boolean returnItem(String itemName);

}
