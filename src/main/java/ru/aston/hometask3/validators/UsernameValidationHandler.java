package ru.aston.hometask3.validators;

import ru.aston.models.User;

public class UsernameValidationHandler extends UserValidationHandler {
    @Override
    public void validate(User user) throws ValidationException {
        if (user.getName() == null || user.getName().trim().isEmpty()) {
            throw new ValidationException("User name cannot be empty");
        }

        if (!user.getName().matches("^[A-Za-z0-9_]+$")) {
            throw new ValidationException("Invalid user format");
        }

        validateNext(user);
    }
}
