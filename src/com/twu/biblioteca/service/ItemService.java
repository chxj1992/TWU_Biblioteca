package com.twu.biblioteca.service;

import com.google.common.collect.ImmutableMap;
import com.twu.biblioteca.dao.ItemDao;
import com.twu.biblioteca.model.Item;

import java.util.List;
import java.util.Map;

public abstract class ItemService {

    abstract public String getName();

    abstract public ItemDao getItemDao();


    public String list() {
        String output = "Available movie list:\n";
        List<Item> itemList = getItemDao().getAvailableList();
        for (Item item : itemList)
            output += item;

        return output;
    }

    public String serviceMenu() {
        return "Enter a number to select option:\n" +
                " 1. Checkout "+getName()+"\n" +
                " 2. Return "+getName()+"\n";
    }

    public String askForInput(String option) {
        Map<String, String> optionMap = ImmutableMap.of("1", "checkout", "2", "return");
        if ( !optionMap.containsKey(option) )
            return "";

        return "Input the " + getName() + " name to " + optionMap.get(option) + "\n";
    }

    public String checkoutItem(String input) {
        if ( getItemDao().checkoutItem(input) )
            return "Thank you! Enjoy the "+getName()+".\n";
        else
            return "That "+getName()+" is not available.\n";
    }

    public String returnItem(String input) {
        if ( getItemDao().returnItem(input) )
            return "Thank you for returning the "+getName()+".\n";
        else
            return "That is not a valid "+getName()+" to return.\n";
    }

}
