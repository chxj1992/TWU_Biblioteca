package com.twu.biblioteca.service;

import com.twu.biblioteca.dao.UserDao;
import com.twu.biblioteca.model.User;
import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;

public class UserServiceTest {

    private UserService userService;
    private UserDao userDao;

    @Before
    public void before() throws Exception {
        userDao = mock(UserDao.class);
        userService = new UserService();
        userService.setUserDao(userDao);
    }

    @Test
    public void should_return_user_id_when_login_success() {
        given(userDao.checkLogin(anyString(), anyString())).willReturn(true);

        String output = userService.login("123-1234", "111");

        assertThat(output).isEqualTo("123-1234");
    }

    @Test
    public void should_return_empty_str_when_login_fail() {
        given(userDao.checkLogin(anyString(), anyString())).willReturn(false);

        String output = userService.login("123-1234", "1");

        assertThat(output).isEqualTo("");
    }

    @Test
    public void should_return_user_info() {
        given(userDao.getUserById(anyString())).willReturn(new User("123-1234", "123", "Andy", "andy@gmail.com", "14643545"));

        String userInfo = userService.userInfo("123-1234");

        assertThat(userInfo).isEqualTo("123-1234 | Andy | andy@gmail.com | 14643545\n");
    }

}
