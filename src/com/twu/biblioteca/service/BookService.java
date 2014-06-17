package com.twu.biblioteca.service;

import com.twu.biblioteca.dao.BookDao;
import com.twu.biblioteca.model.Book;

import java.util.List;
import java.util.Scanner;

public class BookService extends StorageService {

    public BookDao bookDao = new BookDao();

    @Override
    public void list() {
        List<Book> bookList = bookDao.getAvailableBookList();
        System.out.println("Available book list:");

        for (Book book : bookList)
            System.out.println(book);

        System.out.println("Enter a number to select option:");
        System.out.println(" 1. Checkout Book");
        System.out.println(" 2. Return Book");
    }

    @Override
    public void checkout() {
        System.out.println("Input the BOOK NAME to checkout:");
        String input = new Scanner(System.in).nextLine();

        if ( bookDao.checkoutBook(input) )
            System.out.println("Thank you! Enjoy the book.\n");
        else
            System.out.println("That book is not available.\n");
    }

    @Override
    public void returns() {
        System.out.println("Input the BOOK NAME to return:");
        String input = new Scanner(System.in).nextLine();

        if ( bookDao.returnBook(input) )
            System.out.println("Thank you for returning the book.\n");
        else
            System.out.println("That is not a valid book to return.\n");
    }

}
