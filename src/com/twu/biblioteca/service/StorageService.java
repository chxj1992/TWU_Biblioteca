package com.twu.biblioteca.service;

import com.google.common.collect.ImmutableMap;

import java.util.Map;
import java.util.Scanner;

public abstract class StorageService {

    public abstract void list();

    public abstract void processServiceInput(String input);

    abstract void checkout(String input);

    abstract void returns(String input);


    public void processInput(String option, String serviceName) {
        Map<String, String> optionMap = ImmutableMap.of("1", "checkout", "2", "return");

        System.out.println("Input the "+serviceName+" NAME to "+optionMap.get(option));
        String input = new Scanner(System.in).nextLine();

        switch (option) {
            case "1":
                checkout(input);
                break;
            default:
                returns(input);
                break;
        }
    }
}
