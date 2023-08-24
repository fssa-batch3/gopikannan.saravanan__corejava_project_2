package com.fssa.pin.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.pin.validation.exceptions.InvalidUserException;

class TestValidateEmail {

    @Test
    void testValidEmail() {
        try {
            assertTrue(UserValidator.validateEmail("soffan2906@gmail.com"));
            System.out.println("Valid email");
        } catch (InvalidUserException e) {
            System.out.println(e.getMessage());
            fail();
        }
    }

    @Test
    void testInvalidEmailWithoutAtSymbol() {
        try {
            assertFalse(UserValidator.validateEmail("soffan2906gmail.com"));
            System.out.println("Invalid email: Missing '@' symbol");
        } catch (InvalidUserException e) {
            System.out.println("Valid email");
        }
    }

    @Test
    void testInvalidEmailWithoutcom() {
        try {
            assertFalse(UserValidator.validateEmail("soffan2906@"));
            System.out.println("Invalid email: Missing domain");
        } catch (InvalidUserException e) {
            System.out.println("Valid email");
        }
    }
}
