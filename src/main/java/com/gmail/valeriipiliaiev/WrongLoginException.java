package com.gmail.valeriipiliaiev;

class User {
    private String login;
    private String password;

    public User(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        if (!isValidLogin(login)) {
            throw new WrongLoginException("Wrong login format");
        }

        if (!isValidPassword(password, confirmPassword)) {
            throw new WrongPasswordException("Wrong password format");
        }

        this.login = login;
        this.password = password;
    }

    private boolean isValidLogin(String login) {
        return login.length() <= 20 && login.matches("[a-zA-Z]+");
    }

    private boolean isValidPassword(String password, String confirmPassword) {
        if (password.length() < 6 || password.length() > 25) {
            return false;
        }

        boolean hasLetter = false;
        boolean hasDigit = false;

        for (char c : password.toCharArray()) {
            if (Character.isLetter(c)) {
                hasLetter = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            }
        }

        return hasLetter && hasDigit && password.equals(confirmPassword);
    }
}

class WrongLoginException extends Exception {
    public WrongLoginException(String message) {
        super(message);
    }
}

class WrongPasswordException extends Exception {
    public WrongPasswordException(String message) {
        super(message);
    }
}


