package com.twu.biblioteca.model;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


public class UserModelTest {

    private UserModel userModel;

    @Before
    public void setUp() throws Exception {
        userModel = new UserModel("123-1000", "123456", "Tom", "tom@gmail.com", "14643534");
    }

    @Test
    public void user_name_is_right() {
        String expectName = "Tom";
        assertEquals(userModel.getName(), expectName);
    }


}
