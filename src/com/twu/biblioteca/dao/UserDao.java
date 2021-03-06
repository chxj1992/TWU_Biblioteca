package com.twu.biblioteca.dao;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;
import com.twu.biblioteca.model.User;

import java.util.List;

import static com.google.common.collect.FluentIterable.from;

public class UserDao {

    private List<User> userList;

    public UserDao() {
        userList = Lists.newArrayList(
                new User("123-1000", "123", "Tom", "tom@gmail.com", "14643534"),
                new User("123-1234", "123", "Andy", "andy@gmail.com", "14643545")
        );
    }

    public User getUserById(final String userId) {

        return from(userList).firstMatch(new Predicate<User>(){
            @Override
            public boolean apply(User user) {
                return user.getUserId().equals(userId);
            }
        }).orNull();
    }

    public boolean checkLogin(String userId, String password) {

        User user = getUserById(userId);
        return user != null && user.getPassword().equals(password);
    }

}
