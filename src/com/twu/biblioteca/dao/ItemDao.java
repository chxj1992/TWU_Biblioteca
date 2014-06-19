package com.twu.biblioteca.dao;

import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.twu.biblioteca.model.Item;

import java.util.List;

public abstract class ItemDao {

    public abstract List<Item> getList();

    public List<Item> getAvailableList() {
        return FluentIterable.from(getList()).filter(new Predicate<Item>(){
            @Override
            public boolean apply(Item item) {
                return item.isAvailable();
            }
        }).toList();
    }

    public boolean checkoutItem(String itemName) {
        for ( Item item : getList() ) {
            if (item.getName().equals(itemName) && item.isAvailable()) {
                item.setNumber(item.getNumber() - 1);
                return true;
            }
        }

        return false;
    }

    public boolean returnItem(String itemName) {
        for (Item item : getList()) {
            if (item.getName().equals(itemName) ) {
                item.setNumber(item.getNumber() + 1);
                return true;
            }
        }

        return false;
    }

}
