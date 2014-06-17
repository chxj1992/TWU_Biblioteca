package com.twu.biblioteca.dao;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoTest {

    private UserDao userDao;

    @Before
    public void setUp() throws Exception {
        userDao = new UserDao();
    }

    @Test
    public void get_user_by_number_success() {
        String expectUsername = "Andy";

        assertEquals(userDao.getUserById("123-1234").getName(), expectUsername);
    }

    @Test
    public void get_not_exist_user_by_number_should_be_null() {
        assertEquals(userDao.getUserById("123-1235"), null);
    }

    @Test
    public void login_success() {
        assertTrue(userDao.checkLogin("123-1234", "123456"));
    }

    @Test
    public void login_with_wrong_password() {
        assertFalse(userDao.checkLogin("123-1234", "12345"));
    }

    @Test
    public void login_with_wrong_number() {
        assertFalse(userDao.checkLogin("123-1235", "123456"));
    }

}
