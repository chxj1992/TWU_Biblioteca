package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {

        String input = "";
        Scanner reader = new Scanner(System.in);
        while ( !input.equals("Quit") ) {
            System.out.println("Hello, world!");
            input = reader.nextLine();
        }
    }

}
