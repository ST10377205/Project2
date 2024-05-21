/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject2;

/**
 *
 * @author RC_Student_lab
 */


import java.util.Objects;

public class Login {
    private final Account account;

    public Login(Account account) {
        this.account = account;
    }

    public boolean loginUser(String enteredUsername, String enteredPassword) {
        return Objects.equals(enteredUsername, account.getUsername()) && Objects.equals(enteredPassword, account.getPassword());
    }

    public String returnLoginStatus(boolean isLoggedIn) {
        if (isLoggedIn) {
            return String.format("Welcome %s %s, it is great to see you again.", account.getFirstName(), account.getLastName());
        } else {
            return "Username or password incorrect, please try again.";
        }
    }

    boolean isUsernameFormatCorrect() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

