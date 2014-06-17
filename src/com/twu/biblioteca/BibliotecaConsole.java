package com.twu.biblioteca;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.twu.biblioteca.service.BookService;
import com.twu.biblioteca.service.MovieService;
import com.twu.biblioteca.service.StorageService;
import com.twu.biblioteca.service.UserService;

import java.util.Map;
import java.util.Scanner;

public class BibliotecaConsole {

    private String QUIT = "Quit";
    private UserService userService = new UserService();

    private BookService bookService = new BookService();
    private MovieService movieService = new MovieService();

    private final Map<String, StorageService> services;

    private String userNumber = "";
    private final Scanner scanner;

    public BibliotecaConsole() {
        services = ImmutableMap.of("1", bookService, "2", movieService);
        scanner = new Scanner(System.in);
    }

    public void start() {
//        System.out.println("**Login**");
        //
//        while (userNumber.equals(""))
//            userNumber = userService.login(scanner);

        String input;
        while (true) {
            showMainMenu();
            input = scanner.nextLine();
            if (input.equals(QUIT))
                break;
            processInput(input);
        }
    }


    private void processInput(String input) {
        StorageService service = services.get(input);
        service.list();
        service.processInput(scanner.nextLine());
    }

    private void showMainMenu() {
        System.out.println("Main Menu(Enter a number to select option or \"Quit\" to quit):");
        System.out.println(" 1. List Books");
        System.out.println(" 2. List Movies");
        System.out.println(" 3. Show User Information");
    }


}
