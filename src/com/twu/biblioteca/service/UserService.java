package com.twu.biblioteca.service;

import com.twu.biblioteca.dao.UserDao;
import com.twu.biblioteca.model.User;

public class UserService {

    private UserDao userDao = new UserDao();

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public String login(String userId, String password) {
        if (userDao.checkLogin(userId, password))
            return userId;

        return "";
    }

    public String userInfo(String userId) {
        User user = userDao.getUserById(userId);
        if (user == null)
            return "The user doesn't exist!";

        return user.toString();
    }
    

}
