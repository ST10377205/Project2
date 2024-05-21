/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.mavenproject2;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;


/**
 *
 * @author RC_Student_lab
 */


public class LoginTest {

    @Test
    public void testLoginSuccessful() {
        Account account = new Account("user_1", "P@ssw0rd!", "John", "Doe");
        Login login = new Login(account);
        assertTrue(login.loginUser("user_1", "P@ssw0rd!"));
    }

    @Test
    public void testLoginFailed_WrongPassword() {
        Account account = new Account("user_1", "P@ssw0rd!", "John", "Doe");
        Login login = new Login(account);
        assertFalse(login.loginUser("user_1", "WrongP@ssw0rd!"));
    }

    @Test
    public void testLoginFailed_WrongUsername() {
        Account account = new Account("user_1", "P@ssw0rd!", "John", "Doe");
        Login login = new Login(account);
        assertFalse(login.loginUser("wrong_user", "P@ssw0rd!"));
    }

    @Test
    public void testLoginFailed_WrongUsernameAndPassword() {
        Account account = new Account("user_1", "P@ssw0rd!", "John", "Doe");
        Login login = new Login(account);
        assertFalse(login.loginUser("wrong_user", "WrongP@ssw0rd!"));
    }

    @Test
    public void testReturnLoginStatus_Success() {
        Account account = new Account("user_1", "P@ssw0rd!", "John", "Doe");
        Login login = new Login(account);
        assertTrue(login.loginUser("user_1", "P@ssw0rd!"));
        assertTrue(login.returnLoginStatus(true).contains("Welcome John Doe, it is great to see you again."));
    }

    @Test
    public void testReturnLoginStatus_Failure() {
        Account account = new Account("user_1", "P@ssw0rd!", "John", "Doe");
        Login login = new Login(account);
        assertFalse(login.loginUser("user_1", "WrongP@ssw0rd!"));
        assertTrue(login.returnLoginStatus(false).contains("Username or password incorrect, please try again."));
    }
}

