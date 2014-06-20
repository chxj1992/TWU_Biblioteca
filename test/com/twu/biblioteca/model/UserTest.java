package com.twu.biblioteca.model;

import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;


public class UserTest {

    private User user;

    @Before
    public void before() throws Exception {
        user = new User("123-1000", "123456", "Tom", "tom@gmail.com", "14643534");
    }

    @Test
    public void user_name_should_be_right() {
        String expectName = "Tom";

        assertThat(user.getName()).isEqualTo(expectName);
    }


}
