package com.gmail.valeriipiliaiev;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    public void testConstructor_withValidLoginAndPassword_doesNotThrowExceptions() {
        // Given
        String login = "username";
        String password = "Password1";
        String confirmPassword = "Password1";

        // When/Then
        assertDoesNotThrow(() -> new User(login, password, confirmPassword));
    }

    @Test
    public void testConstructor_withInvalidLogin_throwsWrongLoginException() {
        // Given
        String login = "invalidlogin!@#";
        String password = "Password1";
        String confirmPassword = "Password1";

        // When/Then
        assertThrows(WrongLoginException.class, () -> new User(login, password, confirmPassword));
    }

    @Test
    public void testConstructor_withInvalidPassword_throwsWrongPasswordException() {
        // Given
        String login = "username";
        String password = "password";
        String confirmPassword = "password";

        // When/Then
        assertThrows(WrongPasswordException.class, () -> new User(login, password, confirmPassword));
    }

    @Test
    public void testConstructor_withMismatchedPasswords_throwsWrongPasswordException() {
        // Given
        String login = "username";
        String password = "Password1";
        String confirmPassword = "Password2";

        // When/Then
        assertThrows(WrongPasswordException.class, () -> new User(login, password, confirmPassword));
    }
}
