package org.example;

public class PasswordValidator {
        public static boolean isValid(String password) {
            // Check length
            if (password.length() < 5 || password.length() > 9) {
                return false;
            }

            // Check character composition
            if (!password.matches("[a-zA-Z0-9]+")) {
                return false;
            }

            // Check presence of at least one letter and one digit
            boolean hasLetter = false;
            boolean hasDigit = false;
            for (char c : password.toCharArray()) {
                if (Character.isLetter(c)) {
                    hasLetter = true;
                }
                if (Character.isDigit(c)) {
                    hasDigit = true;
                }
            }
            return hasLetter && hasDigit;
        }
}
