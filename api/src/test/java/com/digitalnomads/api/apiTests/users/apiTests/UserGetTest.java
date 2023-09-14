package com.digitalnomads.api.apiTests.users.apiTests;

import com.digitalnomads.api.asserts.ApiAsserts;
import com.digitalnomads.api.entities.User;
import com.digitalnomads.api.utils.EntityManager;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.assertEquals;

public class UserGetTest extends BaseApiTests {
    @Test
    public void getUserByEmail() {
        String expectedEmail = "tulenbaevaltyn@gmail.com";
        String expectedEmailNegative = "tulenbaevaltyn@gmail.com";
        userController.getUserByEmail(expectedEmail);
        User user = userController.extractObjectFromResponse(User.class);
        System.out.println(user.toString());
        assertEquals(user.getEmail(), expectedEmailNegative, "User email is not correct");
    }

    @Test
    public void getUsers() {
        User[] user = userController.getAllUsers().as(User[].class);
        System.out.println(Arrays.toString(user));
    }

    @Test
    public void isUserOnline() {
        userController.isUserOnline("1");
        ApiAsserts.assertThat(userController.getResponse())
                .isCorrectStatusCode(200);

    }

    @Test
    public void userLimit() {
        boolean result = userController.checkUserLimit();
        User user = EntityManager.generateUser();
        if (result) {
            User[] users = userController.getAllUsers().as(User[].class);
            userController.deleteUser(users[1].getId());
        }
        User createdUser = userController.createUser(user);
        User userInDataBase = userController.getUserByEmail(createdUser.getEmail()).as(User.class);
        Assert.assertEquals(userInDataBase.getLogin(), user.getLogin());
    }

    @Test
    public void getUserByUserName() {
        String expectedUsername = "altynai";
        String expectedUsernameNegative = "altynai";
        userController.getUserByUsername(expectedUsername);
        User user = userController.extractObjectFromResponse(User.class);
        System.out.println(user.toString());
        assertEquals(user.getLogin(), expectedUsernameNegative, "Username is not correct");
    }

    @Test
    public void deleteUserById() {
        userController.deleteUser("3");
        ApiAsserts.assertThat(userController.getResponse())
                .isCorrectStatusCode(200);
    }
}

