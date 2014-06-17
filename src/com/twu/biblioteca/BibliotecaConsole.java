package com.twu.biblioteca;

import com.twu.biblioteca.service.BookService;
import com.twu.biblioteca.service.MovieService;
import com.twu.biblioteca.service.UserService;

import java.util.Scanner;

public class BibliotecaConsole {

    private String QUIT = "Quit";
    private UserService userService = new UserService();
    private BookService bookService = new BookService();
    private MovieService movieService = new MovieService();
    private String userNumber = "";

    public void start() {
        System.out.println("**Login**");
        Scanner scanner = new Scanner(System.in);

        while (userNumber.equals(""))
            userNumber = userService.login(scanner);

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
        Integer i;
        try {
            i = Integer.parseInt(input);
        } catch (Exception e) {
            System.out.println("Select a valid option!");
            return;
        }

        switch ( i ) {
            case 1:
                bookService.listBooks();
                break;
            case 2:
                movieService.listMovies();
                break;
            case 3:
                userService.userInfo(userNumber);
                break;
            default:
                System.out.println("Select a valid option!");
                break;
        }
    }

    private void showMainMenu() {
        System.out.println("Main Menu(Enter a number to select option or \"Quit\" to quit):");
        System.out.println(" 1. List Books");
        System.out.println(" 2. List Movies");
        System.out.println(" 3. Show User Information");
    }


}
