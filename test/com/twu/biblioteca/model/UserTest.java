package com.twu.biblioteca.model;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


public class UserTest {

    private User user;

    @Before
    public void setUp() throws Exception {
        user = new User("123-1000", "123456", "Tom", "tom@gmail.com", "14643534");
    }

    @Test
    public void user_name_is_right() {
        String expectName = "Tom";
        assertEquals(user.getName(), expectName);
    }


}
