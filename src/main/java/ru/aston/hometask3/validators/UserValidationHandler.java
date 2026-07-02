package ru.aston.hometask3.validators;

import ru.aston.models.User;

public abstract class UserValidationHandler {
    protected UserValidationHandler next;

    public void setNext(UserValidationHandler next) {
        this.next = next;
    }

    public abstract void validate(User user) throws ValidationException;

    protected void validateNext(User user) throws ValidationException {
        if (next != null) {
            next.validate(user);
        }
    }
}
