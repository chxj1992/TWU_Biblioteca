package com.twu.biblioteca;

import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {

    public static BookDao bookDao = new BookDao();

    public static void main(String[] args) {
        String input;
        Scanner reader = new Scanner(System.in);
        showMainMenu();
        while ( true ) {
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
            System.out.println("(Enter '0' to show the main menu)\n");
            return;
        }

        switch ( i ) {
            case 0:
                showMainMenu();
                break;

            case 1:
                listBooks();
                break;

            case 2:
                checkoutBook();
                break;

            case 3:
                returnBook();
                break;

            default:
                System.out.println("Select a valid option!");
                System.out.println("(Enter '0' to show the main menu)\n");
                break;
        }
    }

    private static void showMainMenu() {
        System.out.println("Main Menu(Enter a number to select option or \"Quit\" to quit):");
        System.out.println(" 1. List Books");
        System.out.println(" 2. Checkout Book");
        System.out.println(" 3. Return Book");
    }

    private static void listBooks() {
        List<BookModel> bookList = bookDao.getAvailableBookList();
        System.out.println("Available book list:");

        for (BookModel book : bookList)
            System.out.println(book.getBookName()+" | "+ book.getAuthor()+" | "+book.getYear());
    }

    private static void checkoutBook() {
        System.out.println("Input the BOOK NAME to checkout:");
        String input = new Scanner(System.in).nextLine();

        if ( bookDao.checkoutBook(input) )
            System.out.println("Thank you! Enjoy the book.\n");
        else
            System.out.println("That book is not available.\n");
    }

    private static void returnBook() {
        System.out.println("Input the BOOK NAME to return:");
        String input = new Scanner(System.in).nextLine();

        if ( bookDao.returnBook(input) )
            System.out.println("Thank you for returning the book.\n");
        else
            System.out.println("That is not a valid book to return.\n");
    }


}
