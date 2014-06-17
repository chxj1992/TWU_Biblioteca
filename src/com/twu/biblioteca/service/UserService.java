package com.twu.biblioteca.service;

import com.twu.biblioteca.dao.UserDao;
import com.twu.biblioteca.model.User;

import java.util.Scanner;

public class UserService {

    private UserDao userDao = new UserDao();

    public String login(Scanner scanner) {
        System.out.println("Input your library number:");
        String number = scanner.nextLine();

        System.out.println("Input password:");
        String password = scanner.nextLine();

        if( userDao.checkLogin(number, password) )
            return number;

        System.out.println("User authentication Failed! Please check your input.\n");
        return "";
    }

    public void userInfo(String userNumber) {
        User user = userDao.getUserByNumber(userNumber);
        if ( user == null ) {
            System.out.println("The user doesn't exist!");
            return;
        }

        System.out.println(user);
    }

}
