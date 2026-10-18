package ru.aston.hometask3.validators;

import ru.aston.models.User;

import java.util.Objects;

public class UsernameValidationHandler extends UserValidationHandler {
    @Override
    public void validate(User user) throws ValidationException {
        Objects.requireNonNull(user.getName(), "Имя пользователя не может быть null");
        if (user.getName().trim().isEmpty()) {
            throw new ValidationException("User name cannot be empty");
        }

        if (!user.getName().matches("^[A-Za-z0-9_]+$")) {
            throw new ValidationException("Invalid user format");
        }

        validateNext(user);
    }
}
