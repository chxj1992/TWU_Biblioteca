package com.twu.biblioteca;

import com.twu.biblioteca.service.BookService;
import com.twu.biblioteca.service.MovieService;

import java.util.Scanner;

public class BibliotecaApp {


    public static void main(String[] args) {
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
            default:
                System.out.println("Select a valid option!");
                break;
        }
    }

    private static void showMainMenu() {
        System.out.println("Main Menu(Enter a number to select option or \"Quit\" to quit):");
        System.out.println(" 1. List Books");
        System.out.println(" 2. List Movies");
    }

}
