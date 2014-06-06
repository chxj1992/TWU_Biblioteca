package com.twu.biblioteca.service;

import com.twu.biblioteca.dao.UserDao;
import com.twu.biblioteca.model.UserModel;

import java.util.Scanner;

public class UserService {

    private static UserDao userDao = new UserDao();

    public static String checkLogin() {
        Scanner usernameReader = new Scanner(System.in);
        System.out.println("Input your library number:");
        String number = usernameReader.nextLine();

        Scanner passwordReader = new Scanner(System.in);
        System.out.println("Input password:");
        String password = passwordReader.nextLine();

        if( userDao.login(number, password) )
            return number;

        System.out.println("User authentication Failed! Please check your input.\n");
        return "";
    }

    public static void userInfo(String userNumber) {
        UserModel user = userDao.getUserByNumber(userNumber);
        if ( user == null ) {
            System.out.println("The user doesn't exist!");
            return;
        }

        System.out.println(user.getNumber()+" | "+
                user.getName()+" | "+user.getEmail()+" | "+user.getPhone()+"\n");
    }

}
