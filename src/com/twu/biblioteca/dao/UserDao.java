package com.twu.biblioteca.dao;

import com.google.common.collect.Lists;
import com.twu.biblioteca.model.UserModel;

import java.util.List;

public class UserDao {

    private List<UserModel> userList;

    public UserDao() {
        userList = Lists.newArrayList(
                new UserModel("123-1000", "123456", "Tom", "tom@gmail.com", "14643534"),
                new UserModel("123-1234", "123456", "Andy", "andy@gmail.com", "14643545")
        );
    }

    public UserModel getUserByNumber(String number) {

        for ( UserModel user : userList ) {
            if (user.getNumber().equals(number))
                return user;
        }

        return null;
    }

    public boolean login(String number, String password) {

        UserModel user = getUserByNumber(number);
        if( user != null && user.getPassword().equals(password) )
            return true;

        return false;
    }

}
