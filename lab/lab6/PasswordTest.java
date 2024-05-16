package org.example;

import static org.junit.Assert.*;

import org.example.PasswordValidator;
import org.junit.Test;

public class PasswordTest {
    @Test
    public void testPasswordLengthPartition() {
        assertFalse(PasswordValidator.isValid("abc")); // Partition 1
        assertTrue(PasswordValidator.isValid("abc12")); // Partition 2
        assertFalse(PasswordValidator.isValid("abcdefghi123")); // Partition 3
    }

    @Test
    public void testCharacterCompositionPartition() {
        assertFalse(PasswordValidator.isValid("abcdef")); // Partition 4
        assertFalse(PasswordValidator.isValid("123456")); // Partition 5
        assertTrue(PasswordValidator.isValid("abc123")); // Partition 6
        assertFalse(PasswordValidator.isValid("abc@123")); // Partition 7
        assertFalse(PasswordValidator.isValid("abc 123")); // Partition 8
    }

    @Test
    public void testPresenceOfLetterAndDigitPartition() {
        assertTrue(PasswordValidator.isValid("abc123")); // Partition 9
        assertFalse(PasswordValidator.isValid("abcdef")); // Partition 10
        assertFalse(PasswordValidator.isValid("123456")); // Partition 11
    }
}
