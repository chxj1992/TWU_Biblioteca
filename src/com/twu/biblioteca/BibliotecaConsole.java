package com.twu.biblioteca;

import com.google.common.collect.ImmutableMap;
import com.twu.biblioteca.service.BookService;
import com.twu.biblioteca.service.ItemService;
import com.twu.biblioteca.service.MovieService;
import com.twu.biblioteca.service.UserService;

import java.util.Map;
import java.util.Scanner;

public class BibliotecaConsole {

    private static final String QUIT = "Quit";
    private UserService userService = new UserService();

    private final Map<String, ItemService> services;

    private final Scanner scanner;

    private String userId = "";

    public BibliotecaConsole() {
        services = ImmutableMap.of("1", new BookService(), "2", new MovieService());
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("**Login**");

        while (userId.equals("")) {
            System.out.println("Input your library number:");
            String userId = scanner.nextLine();
            System.out.println("Input password:");
            String password = scanner.nextLine();
            this.userId = userService.login(userId, password);
            if (this.userId.equals(""))
                System.out.println("User authentication Failed! Please check your input.\n");
        }

        while (true) {
            mainMenu();
            if ( !processMainMenuInput(scanner.nextLine()) ) break;
        }
    }

    private void mainMenu() {
        System.out.println("");
        System.out.println("Main Menu(Enter a number to select option or \"Quit\" to quit):");
        System.out.println(" 1. List Books");
        System.out.println(" 2. List Movies");
        System.out.println(" 3. Show User Information");
    }

    private boolean processMainMenuInput(String option) {
        if ( QUIT.equals(option) )
            return false;
        ItemService service = services.get(option);
        if ( service != null ) {
            serviceMenu(service);
            processServiceMenuInput(service, scanner.nextLine());
        } else if ( option.equals("3") ) {
            System.out.print(userService.userInfo(userId));
        } else {
            System.out.println("Please input a valid option!");
        }

        return true;
    }


    private void serviceMenu(ItemService service) {
        System.out.print(service.list());
        System.out.print(service.serviceMenu());
    }

    private void processServiceMenuInput(ItemService service, String option) {
        System.out.print(service.askForInput(option));

        switch (option) {
            case "1":
                System.out.print(service.checkoutItem(scanner.nextLine()));
                break;
            case "2":
                System.out.print(service.returnItem(scanner.nextLine()));
                break;
            default:
                System.out.println("Please select a valid option!");
        }
    }


}
