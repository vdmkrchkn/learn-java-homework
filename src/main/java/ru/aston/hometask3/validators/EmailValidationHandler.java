package ru.aston.hometask3.validators;

import ru.aston.hometask.User;

public class EmailValidationHandler extends UserValidationHandler {
    @Override
    public void validate(User user) throws Exception {
        if (user.getEmail() == null || user.getEmail().trim().isEmpty()) {
            throw new Exception("Email cannot be empty");
        }

        if (!user.getEmail().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new Exception("Invalid email format");
        }

        validateNext(user);
    }
}
