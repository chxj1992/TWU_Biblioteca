package com.twu.biblioteca.service;

import com.twu.biblioteca.dao.BookDao;
import com.twu.biblioteca.model.BookModel;

import java.util.List;
import java.util.Scanner;

public class BookService {

    public static BookDao bookDao = new BookDao();

    public static void listBooks() {
        List<BookModel> bookList = bookDao.getAvailableBookList();
        System.out.println("Available book list:");

        for (BookModel book : bookList)
            System.out.println(book.getBookName()+" | "+ book.getAuthor()+" | "+book.getYear());

        System.out.println("Enter a number to select option:");
        System.out.println(" 1. Checkout Book");
        System.out.println(" 2. Return Book");

        String input = new Scanner(System.in).nextLine();
        processBookInput(input);

    }

    private static void processBookInput(String input) {

        int i;
        try {
            i = Integer.parseInt(input);
        } catch (Exception e) {
            System.out.println("Select a valid option!");
            return;
        }

        switch (i) {
            case 1:
                checkoutBook();
                break;
            case 2:
                returnBook();
                break;
            default:
                break;
        }
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
