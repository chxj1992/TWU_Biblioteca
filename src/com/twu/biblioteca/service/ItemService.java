package com.twu.biblioteca.service;

import com.google.common.collect.ImmutableMap;
import com.twu.biblioteca.dao.ItemDao;
import com.twu.biblioteca.model.Item;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public abstract class ItemService {

    abstract public String getName();

    abstract public ItemDao getItemDao();


    public void list() {
        List<Item> itemList = getItemDao().getAvailableList();
        System.out.println("Available movie list:");
        for (Item item : itemList)
            System.out.println(item.toString());

        serviceMenu();
    }

    public void serviceMenu() {
        System.out.println("Enter a number to select option:");
        System.out.println(" 1. Checkout "+getName());
        System.out.println(" 2. Return "+getName());
    }

    public void processInput(String option) {
        Map<String, String> optionMap = ImmutableMap.of("1", "checkout", "2", "return");

        System.out.println("Input the " + getName() + " NAME to " + optionMap.get(option));
        String input = new Scanner(System.in).nextLine();

        switch (option) {
            case "1":
                checkoutItem(input);
                break;
            case "2":
                returnItem(input);
                break;
            default:
                System.out.println("Please select a valid option!");
                break;
        }
    }

    public void checkoutItem(String input) {
        if ( getItemDao().checkoutItem(input) )
            System.out.println("Thank you! Enjoy the "+getName()+".");
        else
            System.out.println("That "+getName()+" is not available.");
    }

    public void returnItem(String input) {
        if ( getItemDao().returnItem(input) )
            System.out.println("Thank you for returning the "+getName()+".");
        else
            System.out.println("That is not a valid "+getName()+" to return.");
    }

}
