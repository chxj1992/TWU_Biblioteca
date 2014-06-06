package com.twu.biblioteca;

import com.twu.biblioteca.service.BookService;
import com.twu.biblioteca.service.MovieService;
import com.twu.biblioteca.service.UserService;

import java.util.Scanner;

public class BibliotecaApp {


    private static String userNumber = "";


    public static void main(String[] args) {

        System.out.println("**Login**");

        while ( userNumber.equals("") )
            userNumber =  UserService.checkLogin();

        String input;
        Scanner reader = new Scanner(System.in);
        while ( true ) {
            showMainMenu();
            input = reader.nextLine();
            if( input.equals("Quit") )
                break;
            processInput(input);
        }
    }


    private static void processInput(String input) {
        Integer i;
        try {
            i = Integer.parseInt(input);
        } catch (Exception e) {
            System.out.println("Select a valid option!");
            return;
        }

        switch ( i ) {
            case 1:
                BookService.listBooks();
                break;
            case 2:
                MovieService.listMovies();
                break;
            case 3:
                UserService.userInfo(userNumber);
                break;
            default:
                System.out.println("Select a valid option!");
                break;
        }
    }

    private static void showMainMenu() {
        System.out.println("Main Menu(Enter a number to select option or \"Quit\" to quit):");
        System.out.println(" 1. List Books");
        System.out.println(" 2. List Movies");
        System.out.println(" 3. Show User Information");
    }

}
