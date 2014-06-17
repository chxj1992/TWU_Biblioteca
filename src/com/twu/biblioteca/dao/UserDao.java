package com.twu.biblioteca.dao;

import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Lists;
import com.twu.biblioteca.model.User;

import java.util.List;

public class UserDao {

    private List<User> userList;

    public UserDao() {
        userList = Lists.newArrayList(
                new User("123-1000", "123456", "Tom", "tom@gmail.com", "14643534"),
                new User("123-1234", "123456", "Andy", "andy@gmail.com", "14643545")
        );
    }

    public User getUserByNumber(final String number) {

        return FluentIterable.from(userList).firstMatch(new Predicate<User>(){
            @Override
            public boolean apply(User user) {
                return user.getNumber().equals(number);
            }
        }).orNull();
    }

    public boolean checkLogin(String number, String password) {

        User user = getUserByNumber(number);
        return user != null && user.getPassword().equals(password);
    }

}
