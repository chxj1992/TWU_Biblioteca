package com.twu.biblioteca.dao;

import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class UserDaoTest {

    private UserDao userDao;

    @Before
    public void before() throws Exception {
        userDao = new UserDao();
    }

    @Test
    public void get_user_by_number_success_should_return_the_user_object() {
        String expectUsername = "Andy";

        assertThat(userDao.getUserById("123-1234").getName()).isEqualTo(expectUsername);
    }

    @Test
    public void get_not_exist_user_by_number_should_return_null() {
        assertThat(userDao.getUserById("123-1235")).isNull();
    }

    @Test
    public void login_success_should_return_true() {
        assertThat(userDao.checkLogin("123-1234", "123")).isTrue();
    }

    @Test
    public void login_with_wrong_password_should_return_false() {
        assertThat(userDao.checkLogin("123-1234", "12345")).isFalse();
    }

    @Test
    public void login_with_wrong_number_should_return_false() {
        assertThat(userDao.checkLogin("123-1235", "123")).isFalse();
    }

}
