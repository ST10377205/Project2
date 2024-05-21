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



public class AccountTest {

    @Test
    public void testUsernameCorrectlyFormatted() {
        assertTrue(Account.isUsernameValid("kyl_1"));
    }

    @Test
    public void testUsernameIncorrectlyFormatted_NoUnderscore() {
        assertFalse(Account.isUsernameValid("kyl1"));
    }

    @Test
    public void testUsernameIncorrectlyFormatted_TooLong() {
        assertFalse(Account.isUsernameValid("kyl_123"));
    }

    @Test
    public void testPasswordMeetsComplexityRequirements() {
        assertTrue(Account.isPasswordValid("Ch&&sec@ke99!"));
    }

    @Test
    public void testPasswordDoesNotMeetComplexityRequirements_NoSpecialCharacter() {
        assertFalse(Account.isPasswordValid("Chasecake99"));
    }

    @Test
    public void testPasswordDoesNotMeetComplexityRequirements_NoNumber() {
        assertFalse(Account.isPasswordValid("Ch&&sec@ke"));
    }

    @Test
    public void testPasswordDoesNotMeetComplexityRequirements_NoUpperCaseLetter() {
        assertFalse(Account.isPasswordValid("ch&&sec@ke99"));
    }

    @Test
    public void testPasswordDoesNotMeetComplexityRequirements_TooShort() {
        assertFalse(Account.isPasswordValid("Ch&&se9"));
    }
}
