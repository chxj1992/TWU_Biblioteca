package com.twu.biblioteca.service;

import com.twu.biblioteca.dao.UserDao;
import com.twu.biblioteca.model.User;

public class UserService {

    private UserDao userDao = new UserDao();

    public String login(String userId, String password) {
        if (userDao.checkLogin(userId, password))
            return userId;

        System.out.println("User authentication Failed! Please check your input.\n");
        return "";
    }

    public void userInfo(String userId) {
        User user = userDao.getUserById(userId);
        if (user == null) {
            System.out.println("The user doesn't exist!");
            return;
        }

        System.out.println(user);
    }

}
