package ru.aston.hometask3.validators;

import ru.aston.hometask.User;

public class UsernameValidationHandler extends UserValidationHandler {
    @Override
    public void validate(User user) throws Exception {
        if (user.getName() == null || user.getName().trim().isEmpty()) {
            throw new Exception("User name cannot be empty");
        }

        if (!user.getName().matches("^[A-Za-z0-9_]+$")) {
            throw new Exception("Invalid user format");
        }

        validateNext(user);
    }
}
