package com.twu.biblioteca.dao;

import com.google.common.base.Predicate;
import com.twu.biblioteca.model.Item;

import java.util.List;

import static com.google.common.collect.FluentIterable.from;

public abstract class ItemDao<T extends Item> {

    public abstract List<T> getList();

    public List<T> getAvailableList() {
        return from(getList()).filter(new Predicate<T>() {
            @Override
            public boolean apply(T item) {
                return item.isAvailable();
            }
        }).toList();
    }

    public boolean checkoutItem(String itemName) {
        for (T item : getList()) {
            if (item.getName().equals(itemName) && item.isAvailable()) {
                item.setNumber(item.getNumber() - 1);
                return true;
            }
        }

        return false;
    }

    public boolean returnItem(String itemName) {
        for (T item : getList()) {
            if (item.getName().equals(itemName)) {
                item.setNumber(item.getNumber() + 1);
                return true;
            }
        }

        return false;
    }

}
